# Gerenciamento de dependencias e build em JAVA com Maven

`O que é o Maven`

- Ferramenta para gerenciar a `build` e dependências de um projeto
- Auxilia com o empacotamento e compilação da aplicação;
- `POM → Project Object Model`

`Instalação:`

   https://maven.apache.org/download.cgi

- baixar o arquivo,
- Extrair e coloca na pasta de trabalho de nossa escolha
- Após é preciso indicar o caminho para pasta nas variáveis ambientes do sistema, através das configurações avançadas no painel de controle;

`Comandos`

- `mvn compile`  para compilar os arquivos
- `mvn test` executa os testes
- `mvn package` empacota a aplicação, cria o executável `.JAR`
- `mvn clean` limpa o diretório de trabalho, exclui a pasta `target`

### `Maven archetype`

Arquétipos de projetos ( template ) de projetos com diferentes finalidades.

<aside>
📌 https://maven.apache.org/archetypes/index.html

</aside>

## `POM`

Arquivo principal do `MAVEN`, sem ele o `MAVEN` não funciona;

Detalha toda a aplicação e suas configurações e dependências

## `Dependências`

Existem 2 tipos de dependências no `Maven`, **diretas e transitivas**

`Diretas` são as declaradas no POM.xml

`Transitivas` dependências obrigatórias das que são declaradas no `POM`

Os escopo podem limitar a transitividade das dependências, existem 6 tipos:

`ClassPath` referências que a aplicação tem no momento de execução:

- `RUNTIME ->` tempo execução
- `TEST ->` tempo de execução dos testes
- `COMPILE ->` tempo de compilação

Escopo Compile `Default` → padrão é fornecida em toda aplicação, é transitiva

Escoco `Provided` → dependência é fornecida no momento da execução `runtime` , não é transitiva

Escopo `runtime` → dependência é necessário somente na excução

Escopo `test` → dependência disponível apenas na horas dos testes e da compilação

Escopo `System` → similar ao `provided,` mas precisa prover o `JAR` explicitamente

Escopo `import` → indica reutilização de dependências de outros projetos

`Maven Build LifeCycle`

`Default` → Ciclo principal, responsável pela `deploy` local;

`Clean` → responsável pela limpeza do projeto;

`Site` → ciclo final, responsável pela criação do site de documentação.

`Projeto Multi-módulos`

`Plugins`

Funcionalidades são providas por plugins;

Escritos em `JAVA` e disponibilizados em arquivos `.jar`

`Maven` é construído dentro de uma arquitetura de plugins

`mvn [plugin-name] : [goal-name]`