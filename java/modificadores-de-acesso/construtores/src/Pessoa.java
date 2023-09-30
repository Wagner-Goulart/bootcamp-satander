public class Pessoa {
    private String nome;
    private String cpf;
    private String endereco;

    // CONTRUTOR
    // CPS E NOME SÃO INFORMAÇÕES OBRIGATÓRIAS QUE DEVEM SER PASSADAS
    // SEMPRE QUE UM OBJETO FOR INSTACIADO
    public Pessoa ( String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getNome() { 
        return nome;
    }
    public String getCpf(){
        return cpf;
    }

    public String endereco(){
         return endereco;
    }
    public void setEndereco( String newEndereco){
        this.endereco = newEndereco;
    }
}
