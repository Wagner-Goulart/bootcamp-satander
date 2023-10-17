package edu.junit;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

public class AssertionTest {
    
    @Test
    public void validarLancamentos(){
        int[] primeiroLancamento = { 10,20,30,40,50};
        int[] segundoLancamento = { 10,20,30,40,50};

        Assert.assertArrayEquals(primeiroLancamento, segundoLancamento);
    }

    @Test
    public void validarSeObjetoEstanulo(){
        Pessoa pessoa = null;

        Assert.assertNull(pessoa);

        pessoa = new Pessoa("Jose", LocalDateTime.now());

        Assert.assertNotNull(pessoa);
    }
}
