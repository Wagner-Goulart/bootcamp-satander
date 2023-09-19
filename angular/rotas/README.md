# ROTAS

![Angular](https://img.shields.io/badge/angular-%23DD0031.svg?style=for-the-badge&logo=angular&logoColor=white)

Caminhos que o usuário pode acesso dentro da aplicação, cada rota leva a um conjunto de componentes de funcionalidades específicas.

Ao iniciarmos projetos com o Angular, podemos optar por iniciar o projeto com roteamento, dessa forma o Angular irá criar o módulo de rotas.

```jsx
//--------ARQUIVO ROTAS CRIADO PELO ANGULAR

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

// AQUI SÃO DEFIINICADAS AS ROTAS DA APLICAÇÃO
// ROTAS SÃO PASSADAS EM FORMATO DE OBJETO
const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
```

### Declaração de um rota:

```jsx
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TitleComponent } from './pages/index/title/title.component';
import { CardComponent } from './pages/portifolio/card/card.component';

const routes: Routes = [
  {
    path: '', // INDICA O CAMINHO DA ROTA
    component: TitleComponent, // INDICA QUAL COMPONENTE DEVE SER RENDERIZADO QUANDO A ROTA É ACESSADA
    pathMatch:'full' // INDICA INDICA SE A ROTA PRECISA SER EXATAMENTA IGUAL OU NÃO AO DECLARADO EM PATH
  },
  {
    path:'portifolio',
    component: CardComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
```

### Rotas Coringa:

Caso o usuário tente acessar alguma rota que não foi definida na aplicação, essas rotas redirecionam o usuário para outra rota, ou até mesmo para um página de erro.

```jsx
const routes: Routes = [
  {
    path: '', // INDICA O CAMINHO DA ROTA
    component: TitleComponent, // INDICA QUAL COMPONENTE DEVE SER RENDERIZADO QUANDO A ROTA É ACESSADA
    pathMatch:'full' // INDICA INDICA SE A ROTA PRECISA SER EXATAMENTA IGUAL OU NÃO AO DECLARADO EM PATH
  },
  {
    path:'portifolio',
    component: CardComponent,
  },
  {// ROTA CORINGA
    path:'**', // AQUI INDICA QUE O CAMINHO PODE SER QUALQUER COISA
    redirectTo:''// AQUI ESTAMOS DIRECIONANDO O USUÁRIO PARA HOJE, MAS PODERIA SER PASSADO QUALQUER OUTRA ROTA
  }
];
```

### routerLink

Utilizamos o router link para indicar os rotas que queremos acessar, podemos utliza-lo na criação de menus de navegação em nossa aplicação.

<aside>
💡 Apesar de ser possível passar o atributo ‘href’, o uso do mesmo não é indicado pois ele irá recarregar a página, o que fere o conceito de SPA

</aside>

```jsx
<div>
  <ul>
    <li><a [routerLink]="['/']">Home</a></li>
    <li><a [routerLink]="['/portifolio']">Portifolio</a></li>
  </ul>
</div>
```

### *routerLinkActive e routerLinkActiveOptions:*

 O *routerLinkActive* permite usar classes CSS na rota que estiver ativa, e com isso será aplicado os estilos que foram definidos no CSS.

Já o *routerLinkActiveOptions* indica que os estilos devem ser aplicados nas rotas em que os caminhos sejam extamente iguais aos que foram definidos.

```jsx
<div>
  <ul>
    <!-- routerLinkActive
    da a possibilidade de passar uma classe CSS para a rota
    e carregar os estilos definidos nesse classe -->
    <!-- routerLinkActiveOptions
    indica que os estilos do routerLinkActive
    serão adicionados somente a se rota for exatamento igual a que foi definida -->
    <li>
      <a
        [routerLink]="['/']"
        [routerLinkActive]="['activated']"
        [routerLinkActiveOptions]="{exact:true}">
      Home</a>
    </li>
    <li>
      <a
        [routerLink]="['/portifolio']"
        [routerLinkActive]="['activated']"
        [routerLinkActiveOptions]="{exact:true}"
        >Portifolio</a
      >
    </li>
  </ul>
</div>
```

### Rotas com parâmetros

Ao desenvolver aplicações é comum que precisemos resgatar parâmetros da URL para utilizar para utiliza-las.

**Exemplo:**

<aside>
💡 Fazer uma chama na API do banco de dados, e exibir dos detalhes do produtos que foi clicado pela usuário.

</aside>

Para isso, podemos utilizar de uma variável que o Angular nos fornece o ‘:id’ ao informar essa variável ao final de uma rota, dizemos ao Angular que iremos utilizar esse valor.

```jsx
{
    path:'portifolio/:id', // :id indicando ao Angular o usao de paremetros na rota
    component: CardComponent, // Componente que será renderizado ao acessar a rota
  },

// Para que os parametros funcionem corretamento, precisamo ir no componente
// que será renderizado e adicionar a lógica abaixo:

export class CardComponent implements OnInit {

  // Injeção de dependencia no contrutor da class-e
  // ActivatedRoute é um tipagem obrigatória
  constructor(private activeRoute: ActivatedRoute) {

    // Dentro do ActivatedRoute temos acesso a algumas propriedades
    // params.subscribe é utilizado sempre que quisermos resgatar um parametros
    // DENTRO DELE É POSSÍVEL APLICAR QUALQUER LÓGICA.
    this.activeRoute.params.subscribe(
      res => console.log(res)
    )
  }
```

### Recuperando QueryParams de rotas:

Os QuerParms também pode ser recuperados para serem utilizados na aplicaçõa

QueryParams são tudo que vem após um “?” na URL.

```jsx
//http://localhost:4200/portifolio/1?{name=teste&toke=123}
    // APÓS O SINAL DE '?' SÃO OS QUERY PARAMS
    // RECUPERAR OS QUERYPARAMS :
    this.activeRoute.queryParams.subscribe (
      res => console.log(res)
    )
  }
```

### Redirecionamento por componente:

É Possível forçar a navegação e redirecionar para um rota/componente específico.

```jsx
export class CardComponent implements OnInit {

  // Injetado a dependencia private navegador: Router
  // TIPAGEM ROUTER É IMPORTADODO DO ANGULAR E É OBRIGATORIA
  constructor(private activeRoute: ActivatedRoute, private navegador: Router) {
    // AQUI RECUPERA ISSO =>  http://localhost:4200/portifolio/{1} => [:id]
    this.activeRoute.params.subscribe((res) => console.log(res));

    // AQUI RECUPERA ISSO => http://localhost:4200/portifolio/1?{name=teste&toke=123} => QUERYPARAMS
    this.activeRoute.queryParams.subscribe((res) => console.log(res));
  }

  ngOnInit(): void {
    setInterval(()=>{
      // DENTRO DO ROUTER TEMOS ACESSO AO NAVIGATE
      // DENTRO DO NAVIGATE É INFORMADO A ROTA QUE IREMOS ACESSAR
      // NESSE TRECHO DE CÓDIGO, APÓS 5 SEGUNDOS É REDIRECIONADO PARA HOME
      this.navegador.navigate(['/'])
    }, 5000)
  }
```

### Rotas Children:

É possível criar sub rotas para os componentes, essas subrotas irão acessar os mesmo componentes ou outros componentes.

```jsx
{
    // CRIAR A ROTA PORTIFOLIO
    //http://localhost:4200/portifolio
    path:'portifolio',
    component: CardComponent,
    // CRIAR A SUBROTA DE PORTIFOLIO PASSANDO O ID COMO PAMETRO
    children: [
      {
        //http://localhost:4200/portifolio/1
        path:':id',
        component: CardComponent,
      },

    ]
  },
```

Para acesso os parâmetros das rotas filho né acesso ajustar a lógica do construto com o código abaixo:

```
//RECUPERA OS PAREMETROS DO COMPONENTE FILHO
    // firstChild PARA ACESSAR OS PARAMETROS DAS ROTAS FILHAS
    // firstChild? "?" É UMA VALIDAÇÃO QUE INDICA QUE ESSE PARAMETRO PODE EXISTIR OU NÃO
    this.activeRoute.firstChild?.params.subscribe((res) => console.log(res));
```