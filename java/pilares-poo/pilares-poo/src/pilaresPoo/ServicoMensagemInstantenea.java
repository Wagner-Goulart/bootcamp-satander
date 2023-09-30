package pilaresPoo;
// Palavra reserveda obstract indica uma obstraçaõ.
// Abstração são métodos que a classe pai não sabe como funcionam
// mas que obrigatoriamente tem que estar implementados nas classes filhas
public abstract class ServicoMensagemInstantenea {

    public abstract void enviarMensagem();
    public abstract void receberMensagem();
    // public void enviarMensagem() {
    //     validarConectadoInternet();
    //     System.out.println("Enviando mensagem");
    //     salvarHistoricoMensagem();
    // }

    // public void receberMensagem() {
    //     System.out.println("Recebendo mensagem");
    // }

    // private void validarConectadoInternet() {
    //     System.out.println("Validando se está conectado a internet");
    //  }
    
    // private void salvarHistoricoMensagem() {
    //     System.out.println("Salvando histórico de mensagens");
    //  }
}