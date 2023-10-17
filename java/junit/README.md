# Testes unitário com JUnit

`O que são testes unitários:`

- Também chamados de testes de unidade;
- Testam a menor unidade do código que é possível;
- Via de regra, é escrito enquanto se desenvolve;

`Por que escrever testes ?`

- Melhora a compreensão do código fonte para novos desenvolvedores;
- Corrige `bugs` com segurança;
- Refatorar o código sem introduzir `bugs`
- Entregar com segurança um nova funcionalidade;

`O básico para testar:`

- As classes de teste não devem ser declaras junto com a classes `JAVA;`
- Elas são declaras em arquivos separados, dentro de árvore de testes
- Por convenção, os teste não nomeados da seguinte forma `NomeDaClasseJavaTest`
    
    ```java
    // IREMOS TESTAR A CLASSES PESSO
    public class PessoaTest {
        
        // NOTAÇÃO QUE INDICA UM TESTE
        @Test 
         public void deveCalcularIdadeCorretamente(){
            // CHAMMA A CLASSE QUE IREMOS TESTE
            Pessoa pedrinho = new Pessoa("pedrinho", LocalDateTime.of(2000, 1, 1, 15,0,0));
            // assertEquals PARA VERIFICAR IGUALDADE
            // A ESQUERDA SEMPRE O VALOR QUE ESPERAMOS, E A DIREITO QUE MÉTODO QUE SERÁ CHAMADA
            assertEquals(23, pedrinho.getIdade());
    
        }
    }
    ```
    

`After e Before`

- Classes que auxiliam nos teste, executando antes de depois dos testes;

`Boas práticas` 

- Nomes que facilitem a identificação do teste;
- Comece a testar cedo;
- Padronização na nomenclatura;
- Precisam ser determinísticos;
- Automatizar a execução dos testes;
- Utilizar ferramentas de cobertura de código;