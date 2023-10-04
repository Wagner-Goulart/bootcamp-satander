package set.cojuntoPalavrasUnicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<Palavra> palavraSet;

    public ConjuntoPalavrasUnicas(){
        this.palavraSet = new HashSet<>();
    }

    public void adicionarPalavra( String palavra){
        palavraSet.add(new Palavra(palavra));
    }

    public void removerPalvra(String palavra){
        Palavra palavraParaRemover = null;

        for(Palavra p : palavraSet){
            if(p.getPalavra() == palavra){
                palavraParaRemover = p;
                break;
            }
        }

        palavraSet.remove(palavraParaRemover);
    }

    public boolean verificarPalavra(String palavra){
        return palavraSet.contains(new Palavra(palavra));
    }

    public void exibirPalavrasUnicas(){
        System.out.println(palavraSet);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        conjuntoPalavrasUnicas.adicionarPalavra("A");
        conjuntoPalavrasUnicas.adicionarPalavra("B");
        conjuntoPalavrasUnicas.adicionarPalavra("C");
        conjuntoPalavrasUnicas.adicionarPalavra("D");

       conjuntoPalavrasUnicas.exibirPalavrasUnicas();

       System.out.println(conjuntoPalavrasUnicas.verificarPalavra("C"));

    }

}
