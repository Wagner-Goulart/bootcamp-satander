import interfaces.AperelhoTelefonico;
import interfaces.NavegadorInternet;
import interfaces.ReprodutorMusical;

public class SmartPhone implements AperelhoTelefonico, NavegadorInternet, ReprodutorMusical {

    @Override
    public void tocar() {
        System.out.println("Tocando musica");
    }

    @Override
    public void pausar() {
        System.out.println("Pausando a Musica");
    }

    @Override
    public void selacionarMusica() {
         System.out.println("Selecionando a Musica");
    }

    @Override
    public void exibirPagina() {
         System.out.println("Exibindo a pagina");
    }

    @Override
    public void adicionarPagina() {
         System.out.println("Adicionando a pagina");
    }

    @Override
    public void atualizarPagina() {
         System.out.println("Atualizando a pagina");
    }

    @Override
    public void ligar() {
        System.out.println("Ligando");
    }

    @Override
    public void atender() {
         System.out.println("Atendo o telefone");
    }

    @Override
    public void iniciarCorreioVoz() {
         System.out.println("Iniciando o correio de voz");
    }

}
