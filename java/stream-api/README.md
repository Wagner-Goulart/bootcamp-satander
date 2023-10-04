# Stream API

-
    - Paradigma Funcional entra no JAVA a partir da versão 8;
    - `Stream API` segue os princípios do paradigma funcional para manipular coleções;
    - Utiliza a manipulação de forma mais declarativa, reduzindo a verbosidade do código.
    - Utiliza de `Lambda Expressions` e `Method Reference`
    
    ## `Lambdas :`
    
    - Função sem declaração;
    - Método é declarado no lugar em que é usado.
    - Em JAVA a sintaxe de um `lambda` é definida como `*(argumento) → (corpo)*`
    - As `lambdas` podem receber mais de um argumento.
    
    ```jsx
    itemList.stream()
            .mapToDouble(*item -> item.getPreco() * item.getQuant*())
            .sum();
    ```
    
    ```java
    public class OrdenacaoPessoa {
      //atributo
      private List<Pessoa> pessoaList;
    
      //construtor
      public OrdenacaoPessoa() {
        this.pessoaList = new ArrayList<>();
      }
    
      public List<Pessoa> ordenarPorAltura() {
        if (!pessoaList.isEmpty()) {
          List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);
    			// EM ITÁLICO A LAMBDA
          pessoasPorAltura.sort(*(p1, p2) -> Double.compare(p1.getAltura(), p2.getAltura()));*
          return pessoasPorAltura;
        } else {
          throw new RuntimeException("A lista está vazia!");
        }
      }
    }
    ```
    
    ## `Method Reference`
    
    - Novo recurso do JAVA 8;
    - Permite referencias um classe ou construtor de forma funcional;
    - Para utiliza-lo basta informar uma classe ou referencia com o símbolo `: :`  e nome do método sem os parênteses no final;
        
        ```java
        public class OrdenacaoPessoa {
          //atributo
          private List<Pessoa> pessoaList;
        
          //construtor
          public OrdenacaoPessoa() {
            this.pessoaList = new ArrayList<>();
          }
        
          public List<Pessoa> ordenarPorAltura() {
            if (!pessoaList.isEmpty()) {
              List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);
        		// Method Reference em italico
              pessoasPorAltura.sort(Comparator.comparingDouble(*Pessoa::getAltura*));
              return pessoasPorAltura;
            } else {
              throw new RuntimeException("A lista está vazia!");
            }
          }
        }
        ```
        
    
    ## `Functional Interfaces`
    
    - Qualquer interface com um `SAM ( Single Abstract Method ),`
    - Sua implantação pode ser tratada como expressões `lambda`
    - `Consumer<T>`  representa uma operação que aceita um argumento do tipo `<t>` e não retorno resultado, utilizada para realizar ações ou efeitos no `Stream` sem o modificar.
        
        ```
        /**
         * Representa uma operação que aceita um argumento do tipo T e não retorna nenhum resultado.
         * É utilizada principalmente para realizar ações, ou efeitos colaterais nos elementos do Stream sem modificar, ou
         * retornar um valor.
         */
        public class ConsumerExample {
          public static void main(String[] args) {
            // Criar uma lista de números inteiros
            List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        
            // Usar o Consumer com expressão lambda para imprimir números pares
            Consumer<Integer> imprimirNumeroPar = numero -> {
              if (numero % 2 == 0) {
                System.out.println(numero);
              }
            };
        
            // Usar o Consumer para imprimir números pares no Stream
            numeros.stream()
                .filter(n -> n % 2 == 0)
                .forEach(imprimirNumeroPar);
          }
        }
        ```
        
    - `Supplier<T>` Representa um operação que não aceita nenhum argumento, retorno um resulta do tipo `T,` comumente utilizada para criar ou fornecer novos objetos de um determinado tipos
        
        ```java
        /**
         * Representa uma operação que não aceita nenhum argumento e retorna um resultado do tipo T.
         * É comumente usada para criar ou fornecer novos objetos de um determinado tipo.
         */
        public class SupplierExample {
          public static void main(String[] args) {
            // Usar o Supplier com expressão lambda para fornecer uma saudação personalizada
            Supplier<String> saudacao = () -> "Olá, seja bem-vindo(a)!";
        
            // Usar o Supplier para obter uma lista com 5 saudações
            List<String> listaSaudacoes = Stream.generate(saudacao)
                .limit(5)
                .toList();
        
            // Imprimir as saudações geradas
            listaSaudacoes.forEach(System.out::println);
          }
        }
        ```
        
    - `Function<T, R>` Representa uma função que aceita um argumento do tipo T e retorna um resultado do tipo R. É utilizada para transformar, ou mapear os elementos do Stream em outros valores, ou tipos.
        
        ```java
        /**
         * Representa uma função que aceita um argumento do tipo T e retorna um resultado do tipo R.
         * É utilizada para transformar, ou mapear os elementos do Stream em outros valores, ou tipos.
         */
        public class FunctionExample {
          public static void main(String[] args) {
            // Criar uma lista de números inteiros
            List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        
            // Usar a Function com expressão lambda para dobrar todos os números
            Function<Integer, Integer> dobrar = numero -> numero * 2;
        
            // Usar a função para dobrar todos os números no Stream e armazená-los em outra lista
            List<Integer> numerosDobrados = numeros.stream()
                .map(dobrar)
                .toList();
        
            // Imprimir a lista de números dobrados
            numerosDobrados.forEach(System.out::println);
          }
        }
        ```
        
    - `Predicate<T>`
        
        ```java
        /**
         * Representa uma função que aceita um argumento do tipo T e retorna um valor booleano (verdadeiro oufalso).
         * É comumente usada para filtrar os elementos do Stream com base em alguma condição.
         */
        public class PredicateExample {
          public static void main(String[] args) {
            // Criar uma lista de palavras
            List<String> palavras = Arrays.asList("java", "kotlin", "python", "javascript", "c", "go", "ruby");
        
            // Criar um Predicate que verifica se a palavra tem mais de 5 caracteres
            Predicate<String> maisDeCincoCaracteres = palavra -> palavra.length() > 5;
        
            // Usar o Stream para filtrar as palavras com mais de 5 caracteres e, em seguida,
            // imprimir cada palavra que passou no filtro
            palavras.stream()
                .filter(maisDeCincoCaracteres)
                .forEach(System.out::println);
          }
        }
        ```
        
    - `BinaryOperator<T>`
        
        ```java
        /**
         * Representa uma operação que combina dois argumentos do tipo T e retorna um resultado do mesmo tipo T.
         * É usada para realizar operações de redução em pares de elementos, como somar números ou combinar objetos.
         */
        public class BinaryOperatorExample {
          public static void main(String[] args) {
            // Criar uma lista de números inteiros
            List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        
            // Usar o BinaryOperator com expressão lambda para somar dois números inteiros
            BinaryOperator<Integer> somar = Integer::sum;
        
            // Usar o BinaryOperator para somar todos os números no Stream
            int resultado = numeros.stream()
                .reduce(0, somar);
        
            // Imprimir o resultado da soma
            System.out.println("A soma dos números é: " + resultado);
          }
        }
        ```
        
    - `optional`
        
        Fornece uma abordagem mais segura para o casos de variáveis nulas. `Optional` permite encapsular um valor que pode ser nulo dentro de um objeto `Optional.`