package set.cadastroProdutos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProdutos(long codigo, String nome, double preco, int quantidade) {
        produtoSet.add(new Produto(nome, codigo, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() {
        Set<Produto> produtosPorNome = new TreeSet<>(produtoSet);

        return produtosPorNome;
    }

    public Set<Produto> exibirPorPreco(){
        Set<Produto> produtoPorPreco = new TreeSet<>(new ComparatorPorPreco());

        produtoPorPreco.addAll(produtoSet);

        return produtoPorPreco;
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.adicionarProdutos(1l, "Produto 1", 20d, 5);
        cadastroProdutos.adicionarProdutos(2l, "Produto 6", 17d, 6);
        cadastroProdutos.adicionarProdutos(3l, "Produto 3", 18d, 7);

        System.out.println(cadastroProdutos.exibirPorPreco());

    }

}
