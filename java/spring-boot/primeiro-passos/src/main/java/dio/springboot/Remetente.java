package dio.springboot;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// CRIADA UMA CLASSE JAVA QUE SERÁ UTILIZADA PARA CONFIGURAÇÃO
@Configuration // AO INVÉS DE COMPONENTE, DIFINIMOS ELA COMO @CONFIGURATION
@ConfigurationProperties(prefix = "remetente") // APONTO QUAL PROPRIEDADE ESSA CLASSSE DEVE OLHAR
                                            // NESSE EXEMPLO A PROPRIEDADE "remente" QUE FOI DIFINIDA
                                            // NO ARQUIVO "configuration.properties"
public class Remetente {
    // PROPRIEDADES
	private String nome;
	private String email;
	private List<Long> telefones;

    // GETTERS E SETTERS SÃO CONSTRUÍDOS NORMALMENTE
    public String getNome(){
        return  nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return  email;
    }

    public void setEmail ( String email){
        this.email = email;
    }

    public List<Long> getTelefones(){
        return telefones;
    }

    public void setTelefones(List<Long> telefones){
        this.telefones = telefones;
    }


}
