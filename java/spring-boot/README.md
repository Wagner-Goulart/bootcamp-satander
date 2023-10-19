# Spring Boot

## `Arquitetura Rest`

- Dados são transportadora através do protocolo `HTTP`, e são escritos em `JSON` ;
- Ausência de estado, ou seja, a requisição é encerrada ao se obter a resposta;

## `Spring FrameWork`

- Criado com o objetivo de facilitar o desenvolvimento de aplicações;
- Possui cerca de 20 módulos;
- Estrutura composta por módulos;
- Inversão de controle, parte da execução do código é redirecionado para um `container` ;
- `Beans`, objetos que são criados/instanciados, mantidos e gerenciados pelo `container` ;
- `Autowired →` anotação que indica onde deverá ocorrer um injeção de dependências; `( byName, byType, byConstructor )`
- `Spring boot framework opensource Java`, traz agilidade no desenvolvimento, reduz o gasto com configurações iniciais. Está dentro do guarda-chuva do `Spring FrameWork`

## `SpringBoot`

- `Starters →` configurações pré-definidas de dependências.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/b873b622-685d-41c1-9cf3-d1644eb0b2cc/341963f8-521b-4ed0-96d4-a63f04c6474c/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/b873b622-685d-41c1-9cf3-d1644eb0b2cc/8cf7982b-df18-4345-94e3-ebbaad118fec/Untitled.png)

## `Primeiros Passos`

1. Criar um projeto no `Spring Initialr ( https://start.spring.io/ )` algumas `IDes` como o `VSCode` também contam com assitente integrado para a criação;
    
    ```java
    @Component // Define um componente que implemente um ComandLineRuner
    public class MyApp implements CommandLineRunner {
        
        @Autowired // Injeção de dependencia, cria a instancia de uma calculadores de a necessidade do new
        private Calculadora calculadora;
    
        @Override
        public void run(String... args) throws Exception {
           System.out.println("Resultado " + calculadora.somar(2, 7));
        }
        
    }
    ```
    
2. `Beans versus Component`
    
    `Componente` são usados quando temos acesso ao código fonte;
    
    `Bean` quando as classes pertence a uma biblioteca externa
    
3. `Scopes` 
    
    `Singleton →` apenas uma instancia do objeto na aplicação;
    
    `Prototype →` várias instancias do objetos na aplicação;
    
4. `Properties value` 
    
    As propriedades devem ser definidas no arquivo `apliccation.properties`
    
    `@values→` anotação para definir uma `property`
    
    `Default values →` valores padrão, caso as propriedades não sejam encontradas no arquivo `aplication.properties`, o `springBoot` irá utilizar desse valor ao invés de lançar um erro.
    
    ```java
    public class SistemaMensagem implements CommandLineRunner {
        // ANOTAÇÃO @VALUE DEFININDO UM PROPRIEDADE
    	@Value("${name: NoReply-Dio}") // PROPRIEDADE name COM DEFAULT VALUE "NoReply-Dio"
    	private String nome;
    	@Value("${email}")
    	private String email;
    	@Value("${telefones}")
    	private List<Long> telefones =
    			new ArrayList<>(Arrays.asList(new Long[]{11956781254L}));
    
    	@Override
    	public void run(String... args) throws Exception {
    		System.out.println("Mensagem enviada por: " + nome
    				+ "\nE-mail:" + email
    				+ "\nCom telefones para contato: " + telefones);
    		System.out.println("Seu cadastro foi aprovado");
    	}
    }
    ```
    
    ```
    Propriedade definidas no arquiva application.properties
    
    name = "Wagner Goulart"
    email = "test@test.com.br"
    telefones = 11888524529
    ```
    
5. `Configuration Propererties`
    
    Utilizar a notação `@value` pode aumentar a verbosidade do código conforme a aplicação cresce;
    
    É possível utilizar dos `configurations properties` para resolver esse problema
    
    ```
    ** Propriedades definidas no arquivos, configuration. properties;
    ** Utilizado o padrão -> classeConfiguracao.propriedade = valor
    
    remetente.nome = "Wagner Goulart 2"
    remetente.email = "test@test.com.br"
    remetente.telefones = 11888524529
    ```
    
    ```java
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
    ```
    
    ```java
    @Component
    public class SistemaMensagem implements CommandLineRunner {
        
        // CLASSE DE CONFIGURA É INJETADA COM A NOTAÇÃO @Autowired
        @Autowired
        private Remetente remetente;
    
    	@Override
    	public void run(String... args) throws Exception {
    		System.out.println("Mensagem enviada por: " + remetente.getNome()
    				+ "\nE-mail:" + remetente.getEmail()
    				+ "\nCom telefones para contato: " + remetente.getTelefones());
    		System.out.println("Seu cadastro foi aprovado");
    	}
    }
    ```
    
6. `ORM e JPA` 
    
    `ORM → ( mapeamente objeto-relacional )` aproxima o paradigma da orientação a objeto ao contexto de banco de dados relacional;
    
    `JPA → ( java persistence API)` Especificação baseada em interface, que utiliza de um `frameWork` para realizar operações de persistência de dados em `JAVA` dentro do ecosistema o `frameWork` predominante é o `HIBERNATE` 
    
7. `Spring Data JPA` 
    
    Interação de banco de dados através de `herança, métodos e interfaces`
    
    ```java
    // MODELO DE USUÁRIO COM INFORMAÇÃO DA TABELA DO BANCO DE DADOS
    @Entity
    @Table(name = "tab_user")
    public class User {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id" )
        private Integer id;
    
        @Column(length = 50, nullable = false)
        private String name;
    
        @Column(length = 20, nullable = false)
        private String userName;
    
        @Column(length = 100, nullable = false)
        private String password;
    ```
    
    ```java
    
    // CLASSES REPOSITORY QUE EXTENDE DE JPAREPOSITORY
    package dio.aula.repository;
    
    import org.springframework.data.jpa.repository.JpaRepository;
    import dio.aula.model.User;
    
    public interface UserRepository extends JpaRepository<User, Integer> {
        
    }
    ```
    
    ```
    
    // SALVANDO NO BANCO
    @Component
    public class StartApp implements CommandLineRunner {
        
        @Autowired
        private UserRepository repository;
    
        public void run(String... args) throws Exception {
            User user = new User();
    
            user.setName("Natasha");
            user.setUserName("Ngoulart");
            user.setPassword("123456");
    
            repository.save(user);
    
            for(User u : repository.findAll()){
                System.out.println(" AQUIIIII " + u);
            }
    ```
    

## `Arquitetura de 3 camadas com SpringBoot`

- Promove a separação de funcionalidades, usando camadas para separação;
- Torna um sistema mais flexível, permitindo que as camadas sejam independentes;

