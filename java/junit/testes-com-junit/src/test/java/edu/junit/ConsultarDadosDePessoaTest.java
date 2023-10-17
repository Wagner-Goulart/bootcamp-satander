package edu.junit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConsultarDadosDePessoaTest {
    
   @BeforeClass
   public static void configurarConexao(){
        bancoDeDados.iniciarConexao();
   }

   @Test
   public void validadeDadosDeRetorno(){
    Assert.assertTrue(true);
   }

   @AfterClass
      public static void finzalizarConexao(){
        bancoDeDados.finzalizarConexao();
   }

}
