# Controle de Fluxo com Java

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

- Estruturas condicionais ( if - else, switch-case )
    - ***Condicional Simples:***
        
        Só há 2 fluxos na condicional, ou o resultado é verdadeiro ou é falso.
        
        O bloco condicional só é executado se a condição for atendida, ou seja, o resultado tem que ser TRUE.
        
        ```java
        public static void main(String[] args) throws Exception {
                double saldo = 25.0;
                double valorSolicitado = 17.0;
        
                // A CONDIÇÃO PRECISA SER VERDADEIRA PARA QUE O BLOCO SEGUINTE SEJA EXCUTADO;
                // SE O RESULTADO FOR FALSE, IRÁ PASSAR PARA A PRÓXIMA LINHA.
                if(valorSolicitado < saldo) 
                    saldo = saldo - valorSolicitado;
        
                System.out.println(saldo);
            }
        }
        ```
        
    - ***Condicional Composta:***
        
        Compreende o tratamento para as condições quando os resultados forem TRUE ou FALSE
        
        ```java
        public static void main(String[] args) {
                int nota = 6;
        
                // CONDICIONAL QUE VAI DETERMINAR O CAMINHO DO FLUXO
                if(nota >= 7) {
                    System.out.println("Aprovado"); // EXECUTA QUANDO O RESULTADO É TRUE
                } else {
                    System.out.println("Reprovado"); // EXECUTA QUANDO O RESULTADO É FALSE
                }
            }
        ```
        
    - ***Condicional Encadeada:***
        
        Quando o controle de fluxo condicional tem + de 2 condições.
        
        ```java
        public static void main(String[] args) {
                int nota = 4;
        
                // CONDICIONAL
                if(nota >= 7) {
                    System.out.println("Aprovado"); // EXECUTA QUANDO O RESULTADO É TRUE
                } else if (nota >= 5 && nota < 7) { // NOVA CONDICIONAL
                    System.out.println("Recuperação"); // EXCUTA QUANDO TRUE
                } else {
                    System.out.println("Reprovado"); // EXCECUTA QUANDO FALSE
                }
            }
        ```
        
    - ***Condição ternária:***
        
        A condição ternária uma é forma de reescrita de um if-else, tornando o código mais limpo e menos verboso:
        
        ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/b873b622-685d-41c1-9cf3-d1644eb0b2cc/fe54c268-3a27-425d-bc26-aea2248139b7/Untitled.png)
        
        ```java
        public static void main(String[] args) {
                int nota = 6;
        
                String resultado = nota >= 7 ? "aprovado" : "reprovado";
        
                System.out.println(resultado);
            }
        ```
        
    - ***Switch Case:***
        
        ```java
        public static void main(String[] args) {
                String sigla = "P";
        
                switch(sigla) {
                    case "P": {
                         System.out.println("PEQUENO");
                         break;
                    }
                    case "M": {
                            System.out.println("MÉDIO");
                         break;
                    }
                    case "G": {
                            System.out.println("GRANDE");
                         break;
                    }
                    default: {
                         System.out.println("INDEFINIDO");
                    }
                }
            }}
        ```
        
- Estruturas de repetição ( for, while, do-while)
    - ***FOR:***
        
        ```java
        public static void main(String[] args) throws Exception {
               for(int carneirinhos = 1; carneirinhos <= 20; carneirinhos++){
                    System.out.println("Contando carneirinhos " + carneirinhos);
               }
            }
        ```
        
        ***Break e Continue:***
        
        Break → interrompe o laço;
        
        Continue → interrompe apenas a iteração atual.
        
        ```java
        public static void main(String[] args) {
                for (int numero =1; numero <= 5; numero++){
                    if(numero ==3) 
                    break; // Vai interromper o FOR
        
                    System.out.println(numero);
                }
            }
        }
        ```
        
    - ***WHILE:***
        
        Testa a condição antes de executar o bloco de código.
        
        O comando é executado até que a condição seja false.
        
        ```java
        public static void main(String[] args) {
                double mesada = 50.0;
        
                while(mesada>0) {
                    double valorDoce = valorAleatorio();
        
                    if(valorDoce > mesada) {
                        valorDoce = mesada;
                    };
                    System.out.println("Doce do valor: " + valorDoce + " Adicionado ao carrinho");
                    mesada = mesada - valorDoce;
                };
        
                System.out.println("Mesada: " + mesada);
                System.out.println(" Joãozinho gastou toda a sua mesada ");
            };
        ```
        
    - ***DO-WHILE***:
        
        Enquando o While testa primeiro e executa depois, o DO-WHILE primeiro executa e depois testa a condição.
        
        Ele sempre executa o código apenas um vez.
        
        ```java
        public static void main(String[] args) {
                System.out.println("Discando...");
        
                do {
                    System.out.println("Telefone tocando");
                } while(tocando());
        
                System.out.println("Alô !!!");
            }
        
            public static boolean tocando(){
                boolean atendeu = new Random().nextInt(3)==1;
                System.out.println("Atendeu ? " + atendeu);
        
                return ! atendeu;
            }
        ```
        
- Estruturas de exceceção ( try-catch-finally, thow)
    
    Exceções são fluxos inesperados na aplicação, 
    
    - ***TRY/CATCH:***
        
        ```java
        public class TryCatch {
            public static void main(String[] args) throws Exception {
                try {
                Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        
                System.out.println("Digite seu nome");
                String nome = scanner.next();
        
                System.out.println("Digite seu Sobrenome");
                String sobrenome = scanner.next();
        
                System.out.println("Digite sua Idade");
                int idade = scanner.nextInt();
        
                System.out.println("Digite sua Altura");
                double altura = scanner.nextDouble();
        
                System.out.println("Olá me chamo"+ " "+ nome +" " + sobrenome);
                System.out.println("Tenho " + idade + "" + " anos de idade");
                System.err.println("Minha altura é " + altura);
                } catch(InputMismatchException e) {
                    System.out.println(("Os campos idade e altura precisam ser numéricos"));
                }
            
            }
        }
        ```
        
    - ***HIERARQUIA DE EXCEÇÕES E EXEÇÕES CUSTOMIZADAS:***
        
        Classes de exeçoes são organizadas em 2 grupos ( checked e unchecked )

        