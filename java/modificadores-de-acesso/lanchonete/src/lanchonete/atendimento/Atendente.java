package lanchonete.atendimento;

public class Atendente {
    public void servindoMesa(){
        pegarLancheCozinha();
        System.out.println("Servindo a mesa");
    }

      private void pegarLancheCozinha(){
        System.out.println("Pegando o lanche na cozinha");
    }

      void trocarGas(){
        System.out.println("Atendente trocando o gas");
    }
}


