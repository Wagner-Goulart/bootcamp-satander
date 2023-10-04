package map.dicionario;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionarioMap;

    public Dicionario(){
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalvra(String palavra, String descricao){
        dicionarioMap.put(palavra, descricao);
    }

    public void removerPalavra(String palavra){
        if(!dicionarioMap.isEmpty()){
            dicionarioMap.remove(palavra);
        }
    }

    public void exibirPalvras(){
        System.out.println(dicionarioMap);
    }

    public String pesquisarPorPavalra( String palavra){
        String palavraPesquisada = null;

        if(!dicionarioMap.isEmpty()){
            palavraPesquisada = dicionarioMap.get(palavra);
        }

        return palavraPesquisada;
    }

    public static void main(String[] args) {
       Dicionario dicionario = new Dicionario();

       dicionario.adicionarPalvra("moto", "automovel");
       dicionario.adicionarPalvra("carro", "automovel");
       dicionario.adicionarPalvra("casa", "imovel");

       dicionario.removerPalavra("carro");

       dicionario.exibirPalvras();
       
       System.err.println(dicionario.pesquisarPorPavalra("casa"));

    }


}
