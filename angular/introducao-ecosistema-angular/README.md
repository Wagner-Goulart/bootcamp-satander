# Introdução ao Angular

![Angular](https://img.shields.io/badge/angular-%23DD0031.svg?style=for-the-badge&logo=angular&logoColor=white)

Com uma arquitetura baseada em components, foco em SPA’s. O Angular é um dos frameworks mais antigos no mercadoria, mantido pela gigante Gooogle, esse framework passou por diversas mudanças ao longo de sua história, e desde 2016 passou a utilizar o Typescript como linguagem.

O Angular é uma ferramenta com opnião, onde cada coisa precisa estar no seu lugar, dessa forma ele nos apresenta uma estrutura que deve ser seguida nos projetos. Ele também possui diversas ferramentas nativas para solução de problemas comuns em construções em aplicações SPA, como por exemplo roteamento, dessa forma não há a necessidade de ficar instalando bibliotecas terceiras e adcionando complexidade ao projeto.

## As 4 camadas de uma Web app 🍰

Quando se fala em construções SPA, independente do framework/biblioteca que se escolha para realizar o desenvolvimento, essa tarefa envolve 4 camadas:

- Componentes/Components
- Gerenciamento de estato/state
- Roteamento/Router
- Renderização/render

### Components 🧩

É o elemento visual da página, ele é customizável e reutilizável.

### State 📲

Responsável pela comunicação entre os componentes e troca de informações entre eles.

### Router 🛣️

Responsável pela navegação entre os componentes, realizar a troca da URL sem a necessidade de atualizar a pagina a cada troca.

### Render 🎫

Responsável por entregar o componente para o Browser densenhar na tela.

Existem 3 tipos:

- 100% server - SSR
    - A renderização acontece no SERVER, e os componentes são entregues para o CLIENT.
    - Vantagens
        - Melhora SEO;
        - Carregamento inicial mais rápido.
    - Desvantagens:
        - Aumento da carga no servidor
        - Menor interatividade
    <hr>
- Part server e Part client
    - Renderização ocorre parte no SERVER e parte no CLIENT
    - Vantagens
        - Melhora SEO;
        - Carregamento inicial mais rápido.
        - Interatividade
    - Desvantagens:
        - Aumento da carga no servidor
        - Compatibilidade entre navegadores
    <hr>
- 100 % client
    - renderização acontece 100 % no CLIENT, é como a maioria dos frameworks/bibliotecas tratam a renderização.
    - Vantagens
        - Interatividade
        - Desenvolvimento mais ágil
    - Desvantagens:
        - SEO limitado
        - Carragamento inicial mais lento
    <hr>