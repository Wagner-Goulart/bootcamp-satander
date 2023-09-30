# Fundamentos programação oriendata a objetos

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

Paradigma da programação que é baseado no conceito de objetos. Tem a característica de abstrair o código um objetos do mundo real.

Tudo ao nosso redor é representado como um objeto.

### Classes

São todos os arquivos .java, onde os códigos são escritos.

<aside>
💡 ***A classes é o contrato, a estrutura que todo objeto deve seguir.***

</aside>

Toda classe é composta por:

- Identificador;
    
    ⇒ Propósito para existência do objeto;
    
- Características;
    
    ⇒ Atributos / Estados é toda informação que representa aquele objeto
    
- Comportamento
    
    ⇒ Ações / Métodos, toda parte comportamental da classe / objeto
    
- Instanciar;
    
    ⇒ Ato de criar um novo objeto;
    

![Untitled](/Captura%20de%20tela%202023-09-30%20173053.png)

Seguindo algumas convenções as classes são classificadas como:

- **Classe de modelo ( model );**
    
    ⇒ Respresentam a estrutura de dominio da aplicação;
    
- **Classe de serviço ( service );**
    
    ⇒ Contém as regras de negócio
    
- **Classe de repositório ( repository )**
    
    ⇒ Contém integração com os bancos de dados
    
- **Classe de controle( controller )**
    
    ⇒ Disponibilizam algum comunicação externa a nossa aplicação
    
- **Classe de utilidades ( util )**
    
    ⇒ Contém recursos comuns a toda programação.
    

### Pacotes

São subdiretórios criados a partir da pasta SRC do projeto.
Utilizamos esse hirarqui de pastas, para organizar as classes de acordo com suas funções.

### Visibilidade de recursos ( Modificadores )

Modificadores de acesso que concedem ou não acesso a atributos, métodos e até mesmo outras classes. Em JAVA indicados por 3 palavras reservadas e um conceito Default, onde não há palavra reservada.

***Modificadores:***

Public ⇒ Qualquer classe em qualquer outro pacote tem acesso ao recurso.

Default ⇒ restringe a visibilidade apenas dentro do pacote.

Private ⇒ Visibilidade acontece apenas dentro da classe, não sendo visível nem para o pacote

Protect => A visibilidade acontece apenas para as classes filhas.

### Getters e Setters

Utlizados para buscar valores em atributos, ou definir novos valores nesses atributos.

*Getter ⇒ retorno o valor do atributo especificado;*

*Setter ⇒ define outro valor para o atributo especificado*

Seguindo o padrão JAVA BEANS, as propriedades das classes de modelos são definidos como private, e nessas classes são definidos os GETTERS e SETTERS.

```java
public class Aluno {
    // PROPRIEDADES COM MODIFICADOR DE ACESSO PRIVATE
    private String nome;
    private int idade;

    // GETTER -> PADRAO JAVABEANS getAlgumaCoisa()
    public String getNome(){
        return nome;
    }
    // SETTER -> PADRAO JAVABEANS setAlgumaCoisa()
    public void setNome( String newNome){
        nome = newNome;
    }
    // GETTER
    public int getIdade (){
        return idade;
    }
    // SETTER
    public void setIdade( int newIdade){
        idade = newIdade;
    }

}
```

```java
public static void main(String[] args) {
        // UTLIZANDO OS GETTERS E SETTERS DEFINIDOS NA CLASSE
        Aluno felipe = new Aluno();

        felipe.setNome("Felipe");
        felipe.setIdade(8);

        System.out.println("O aluno " + felipe.getNome() + " tem " + felipe.getIdade() + " anos");
    }
```

### Construtores
<br>
<aside>
💡 Classe novoObjeto  = new Classe( )
</aside>
<br>
Métodos construtores não possuem tipo de retorno, e o nome deve ser o mesmo que o da classe.

Os construtores irão informar quais são os atributos obrigatórios a serem passados sempre que um novo objeto é instanciado / criado.

Como boa prática nem todos os atributos devem ser criados no construtor, os contrutores devem receber apenas os atributos que são essenciais para existência do objeto.

```java
// CONTRUTOR
    // CPF E NOME SÃO INFORMAÇÕES OBRIGATÓRIAS QUE DEVEM SER PASSADAS
    // SEMPRE QUE UM OBJETO FOR INSTACIADO
    public Pessoa ( String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
```

```java
public static void main(String[] args) {
        // INSTANCIANDO NOVO OBJETO
        // E PASSANDO OS ATIBUTOS DEFINIDOS NO CONSTRUTOR DA CLASSE
        Pessoa marcos = new Pessoa("1123", "Marcos");

        marcos.setEndereco("Rua das Marias");
    }
```

### Enums

Tipos especial de classe, onde os objetos já existem na aplicação sem precisarmos instancia-los, eles são imutáveis e disponíveis para toda aplicação.

Servem para disponibizarmos informações que mudam pouco.

```java
// CRIANDO UM ENUM DE ESTADOS
public enum EstadoBrasileiro {
    SAO_PAULO("SP", "São Paulo"),
    RIO_DE_JANEIRO("RJ", "Rio de janeiro"),
    PIAUI("PI", "Piaui"),
    MARANHAO("MA", "Maranhão"),
    SANTA_CATARINA("SC", "Santa Catarina");

    private String nome;
    private String sigla;

    private EstadoBrasileiro(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeMaiusculo() {
        return nome.toUpperCase();
    }

}
```

```java
public class SistemaIbge {
    // FAZENDO USO DO ENAUM
    public static void main(String[] args) {
        for ( EstadoBrasileiro e: EstadoBrasileiro.values()){
            System.out.println(e.getSigla() + " - " + e.getNome());
        }

        EstadoBrasileiro eb = EstadoBrasileiro.SANTA_CATARINA;

        System.out.println(eb.getNomeMaiusculo());
    }
}
```

### UML

Linguagem de Modelagem Unificada, notação para representação gráfica do projeto.

Baseado em 3 conceitos:

1- *Diagramas*

**`Estruturais`**

`de Classe ⇒` utilizado para fazer a representação das classes de negócio e outros componentes do sistema, considerado o mais importante

<aside>
📌 identificação → nome e finalidade da classe
Atributos → Propriedades e características
Operações → Ações e Métodos
Relacionamentos → classes que se relacionam.

</aside>

`de obejtos ⇒`  representa os objetos existentes em determinado instante na aplicação.

2- *Elementos*

3- *Relacionamentos*
