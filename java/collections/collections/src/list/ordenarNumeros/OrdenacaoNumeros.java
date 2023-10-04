package list.ordenarNumeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    List<Numero> numeroList;

    public OrdenacaoNumeros(){
        this.numeroList = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        numeroList.add(new Numero(numero));
    }

    public List<Numero> ordenarAscendente(){
        List<Numero> numerosAscendentes = new ArrayList<>(numeroList);

        Collections.sort(numerosAscendentes);

        return numerosAscendentes;
    }

    public List<Numero> ordenarDescendente(){
        List<Numero> numerosDescendentes = new ArrayList<>(numeroList);

        numerosDescendentes.sort(Collections.reverseOrder());

        return numerosDescendentes;
    }

    public void exibirNumeros(){
        for( Numero numero : numeroList){
         System.out.println(numero.getNumero());
        }
     }

    public static void main(String[] args) {
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();

        ordenacaoNumeros.adicionarNumero(1000);
        ordenacaoNumeros.adicionarNumero(3);
        ordenacaoNumeros.adicionarNumero(0);
        ordenacaoNumeros.adicionarNumero(20);

       

       List<Numero> numerosOrdenadosAscendentes = ordenacaoNumeros.ordenarAscendente();
       List<Numero> numerosOrdenadosDescendentes = ordenacaoNumeros.ordenarDescendente();

       for ( Numero numero : numerosOrdenadosDescendentes) {
            System.out.println(numero.getNumero());
       }

         for ( Numero numero : numerosOrdenadosAscendentes) {
            System.out.println(numero.getNumero());
       }

    }

}
