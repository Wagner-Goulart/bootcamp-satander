package list.carrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> listaDeitens;

    public CarrinhoDeCompras(){
        this.listaDeitens = new ArrayList<>();
    }

    public void adicionarItens( String nome, double preco, int quantidade){
        listaDeitens.add(new Item(nome, preco, quantidade));
    }

    public void removerItem( String nome){
        List<Item> itensParaRemover = new ArrayList<>();

        for(Item i : listaDeitens){
            if(i.getNome().equalsIgnoreCase(nome)){
                itensParaRemover.add(i);
            }
        }

        listaDeitens.removeAll(itensParaRemover);
    }

    public double calcularValorTotal(){
        double valorTotal = 0;
        
        for(Item i : listaDeitens){
            double valorItem = i.getPreco() * i.getQuantidade();
            valorTotal += valorItem;
        }
        
        return valorTotal;

    }

    public void exibirItens(){
        System.out.println(listaDeitens);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItens("Tenis", 89.50, 1);
        carrinhoDeCompras.adicionarItens("Bermuda", 70, 1);
        carrinhoDeCompras.adicionarItens("Camista", 100, 1);
        carrinhoDeCompras.adicionarItens("boné", 15, 1);
        carrinhoDeCompras.removerItem("Boné");
        carrinhoDeCompras.exibirItens();
        System.out.println("O valor total é " + carrinhoDeCompras.calcularValorTotal());
    }
}
