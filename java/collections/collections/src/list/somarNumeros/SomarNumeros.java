package list.somarNumeros;

import java.util.ArrayList;
import java.util.List;

public class SomarNumeros {
    List<Numero> numeroList;

    public SomarNumeros() {
        this.numeroList = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numeroList.add(new Numero(numero));
    }

    public int calcularSomar(){
        int somaTotal = 0;

        if(!numeroList.isEmpty()){
            for( Numero numero : numeroList){
                somaTotal += numero.getNumero();
            }
        }

        return somaTotal;
    }

    public int encontarMaiorNumero() {
        int maiorNumero = 0;

        if(!numeroList.isEmpty()){
            for(Numero numero : numeroList) {
                if(numero.getNumero() >= maiorNumero){
                    maiorNumero = numero.getNumero();
                }
            }
        }

        return maiorNumero;
    }

        public int encontarMenorNumero() {
        int menorNumero = Integer.MAX_VALUE;

        if(!numeroList.isEmpty()){
            for(Numero numero : numeroList) {
                if(numero.getNumero() <= menorNumero){
                    menorNumero = numero.getNumero();
                }
            }
        }

        return menorNumero;
    }

    public void exibirNumeros(){
       for( Numero numero : numeroList){
        System.out.println(numero.getNumero());
       }
    }



    public static void main(String[] args) {
        SomarNumeros somarNumeros = new SomarNumeros();

        somarNumeros.adicionarNumero(15);
        somarNumeros.adicionarNumero(100);
        somarNumeros.adicionarNumero(400);
        somarNumeros.adicionarNumero(2);

        System.out.println(somarNumeros.calcularSomar());
        System.out.println(somarNumeros.encontarMaiorNumero());
        System.out.println(somarNumeros.encontarMenorNumero());
        somarNumeros.exibirNumeros();

    }
}
