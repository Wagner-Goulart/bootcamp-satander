package map.produto;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        estoqueProdutosMap.put(cod, new Produto(nome, preco, quantidade));
    }

    public void exibirProdutos() {
        System.out.println(estoqueProdutosMap);
    }

    public double calcularValorProdutos() {
        double valorTotalEstoque = 0d;

        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto p : estoqueProdutosMap.values()) {
                valorTotalEstoque += p.getQuantidade() * p.getPreco();
            }
        }

        return valorTotalEstoque;
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorValor = Double.MIN_VALUE;

        for (Produto p : estoqueProdutosMap.values()) {
            if (p.getPreco() > maiorValor) {
                produtoMaisCaro = p;
            }
        }

        return produtoMaisCaro;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        estoqueProdutos.adicionarProduto(1l, "a", 9, 5);
        estoqueProdutos.adicionarProduto(2l, "b", 10, 5);
        estoqueProdutos.adicionarProduto(3l, "c", 15, 5);

        estoqueProdutos.exibirProdutos();
        System.out.println(estoqueProdutos.calcularValorProdutos());
        System.out.println(estoqueProdutos.obterProdutoMaisCaro());
    }

}
