package escola;

public class Aluno {
    // PROPRIEDADES COM MODIFICADOR DE ACESSO PRIVATE
    private String nome;
    private int idade;

    // GETTER
    public String getNome(){
        return nome;
    }
    // SETTER
    public void setNome( String newNome){
        nome = newNome;
    }
    // GETTER
    public int getIdade (){
        return idade;
    }
    // SETTER
    public void setIdade( int newIdade){
        idade = newIdade;
    }

}
