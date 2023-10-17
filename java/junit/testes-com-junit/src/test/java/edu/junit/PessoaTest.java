package edu.junit;

import java.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;

public class PessoaTest {
    
    // NOTAÇÃO QUE INDICA UM TESTE
    @Test 
     public void deveCalcularIdadeCorretamente(){
        // CHAMMA A CLASSE QUE IREMOS TESTE
        Pessoa pedrinho = new Pessoa("pedrinho", LocalDateTime.of(2000, 1, 1, 15,0,0));
        // assertEquals PARA VERIFICAR IGUALDADE
        // A ESQUERDA SEMPRE O VALOR QUE ESPERAMOS, E A DIREITO QUE MÉTODO QUE SERÁ CHAMADA
        Assert.assertEquals(23, pedrinho.getIdade());

    }

    @Test
    public void deveRetornarSeEhMaiorDeIdade(){
         Pessoa joaozinho = new Pessoa("joaozinho", LocalDateTime.of(1999, 1, 1, 15,0,0));

         Assert.assertTrue(joaozinho.ehMaiorDeIdade());

          Pessoa joao = new Pessoa("joao", LocalDateTime.of(2020, 1, 1, 15,0,0));

          Assert.assertFalse(joao.ehMaiorDeIdade());
    }
}
