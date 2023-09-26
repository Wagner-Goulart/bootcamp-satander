package edu.wagner.segundasemana;

public class MinhaClasse {
    public static void main(String[] args) {
        String primeiroNome = "Wagner";
        String segundoNome = "Goulart";

        // INVOCAÇÃO DO MÉTODO
        String nomeCompleto = nomeCompleto(primeiroNome, segundoNome);

        System.out.println(nomeCompleto);
    }

    // CRIAÇÃO DO MÉTODO
    public static String nomeCompleto(String primeiroNome, String segundoNome){
        return primeiroNome.concat(" ").concat(segundoNome);
    }
}
