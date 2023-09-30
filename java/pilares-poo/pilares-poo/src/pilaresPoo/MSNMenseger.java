package pilaresPoo;
// Herança EXTENDS palavra reserveada para dizer qual a classe pai
// a Classe filho herda todos os métodos e propriedade da classe pais
public class MSNMenseger extends ServicoMensagemInstantenea {
    public void enviarMensagem(){
        System.out.println("Enviando mensagem pela MSN");
    }

    public void receberMensagem(){
        System.out.println("Rcebendo mensagne pela MSN");
    }

}
