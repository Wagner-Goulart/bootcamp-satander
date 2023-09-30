package lanchonete.area.cliente;

public class Cliente {
    public void escolherLanche() {
        System.out.println("Escolhendo o lanche");
    }

    public void fazerPedido() {
        System.out.println("Fazendo pedido");
    }

    public void pagarConta() {
        consultandoSaldoAplicativo();
        System.out.println("Pagando a conta");
    }

    private void consultandoSaldoAplicativo() {
        System.out.println("Consultando o saldo");
    }
}
