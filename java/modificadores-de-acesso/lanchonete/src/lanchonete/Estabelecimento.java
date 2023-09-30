package lanchonete;

import lanchonete.area.cliente.Cliente;
import lanchonete.atendimento.cozinha.Cozinheiro;

public class Estabelecimento {
    public static void main(String[] args) {
        Cozinheiro cozinheiro = new Cozinheiro();

        cozinheiro.adicionarComboNoBalcao();
        cozinheiro.adicionarLancheNoBalcao();
        cozinheiro.adicionarSucoNoBalcao();


        Cliente cliente = new Cliente();

        cliente.escolherLanche();
        cliente.pagarConta();
    }
}
