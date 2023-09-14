# Diretivas do Angular 

As diretivas do Angular são comandos especiais, que são utilizados para manipular a DOM. Existem 2 tipos de diretivas que podemos utilizar, as de atributo e as estruturais.

### Diretivas de Atributo:

Utilizadas para alterar a aparência e o comportamento de outro elemento, componente ou diretiva.

São elas :

- ngClass → permite adicionar ou remover dinamicamente uma classe CSS.
    
    ```jsx
    /* Estilização das classes são difinidas no arquivos Css */
    .enable {
      color: blue;
    
    }
    
    .disable {
      color: red;
    }
    
    export class CompAtributosComponent implements OnInit {
    
      // propriedade de estilo, recebe como default a classe enable
      estilo: string = 'enable'
    
      constructor() { }
    
      ngOnInit(): void {
      }
    
      // métodos trocar() faz a validação do valor que está na propriedade
      // se estiver enable troca para disable
      // se estiver disable troca para enable
      trocar() {
        this.estilo === 'enable' ? this.estilo = 'disable' : this.estilo ='enable'
      }
    
    }
    
    <!-- propertu binding referencia a propriedade estilo 
    que está no arquivo TS -->
    <p [ngClass]="estilo">comp-atributos works!</p>
    
    <!-- Botão com event binding que dispara o método trocar() 
    que está no arquivo TS -->
    <button (click)="trocar()">trocar estilo</button>
    ```
    
- ngStyle → permite adicionar estilos diretamente ao elemento ou componente
    
    ```jsx
    <!-- Property binding,
    Esse bindiing receber um objeto com as propriedades Css
    os valores estão vindo de forma dinamica do aqui TS -->
    <h1 [ngStyle]="{
      'background': corFundo, // corFundo é definida no arquivo TS
      'color': corFonte // corFonte também é definida no arquivo TS
    }">Curso Angular</h1>
    
    export class CompAtributosComponent implements OnInit {
    
      estilo: string = 'enable'
      corFundo: string = 'red' // propriedade definida na class com valor 'red'
      corFonte: string = 'white' // propriedade definida na class com valor 'white'
    
      constructor() { }
    ```
    
- ngModel → cria comunicação de duas vias entre o HTML e Typescript
    
    ```jsx
    export class CompAtributosComponent implements OnInit {
    
      estilo: string = 'enable'
      corFundo: string = 'red'
      corFonte: string = 'white'
      itens : string = '' // propriedade itens recebe string vazia
      lista: string[] = [] // propriedade lista receber array vazio
      constructor() { }
    
      ngOnInit(): void {
      }
    
      trocar() {
        this.estilo === 'enable' ? this.estilo = 'disable' : this.estilo ='enable'
      }
    
      // metodo que adionar os itens na lista
      adicionarLista() {
        this.lista.push(this.itens)
      }
    
    }
    
    <!-- Input receber o two-way data-binding referenciando
    a propriedade itens criada no arquivo TS -->
    <input type="text" [(ngModel)]="itens">
    <!-- Botão receber o event binding com o metodo
    adicionarLista criado no arquivo TS -->
    <button (click)="adicionarLista()">Adicionar</button>
    <!-- <p> redenriza o item enquando é digito através da interpolação -->
    <p>{{itens}}</p>
    
    <ul>
      <!-- ngfor itera sobre o array e lista eles na tela -->
      <li *ngFor="let elemento of lista">{{ elemento }}</li>
    </ul>
    ```
    
- ngTemplate → cria um template ( modelo ) HTML
    
    ```jsx
    <!-- ngTemplate é chamado como se
    fosse um componente normal -->
    
    <!--Não irá rederizar no tela, por padrão ele é false-->
    <ng-template>
      <a href="#">Finalizar compra</a>
    </ng-template>
    <br>
    
    <!-- Esse irá renderizar na tela, pois
    o ngIf está alterando o comportamento padrão
    para true-->
    <ng-template [ngIf]="true">
      <a href="#">Adicionar carrinho</a>
    </ng-template>
    ```
    
- ngContent → permite que o elemento Pai renderize os conteúdos dos elemento filhos
    
    ```jsx
    <!-- app-comp-atributos está recebendo 2 componentes
    filhos, esses filhos não serão renderizados até que
    o ng-content seja definido no pai -->
    <app-comp-atributos>
      <h2>Olé</h2> <!-- Não vai renderizar na tela -->
      <p>estou dentro</p> <!-- Não vai renderizar na tela -->
    </app-comp-atributos>
    
    <!-- ngContent é definido no componente pai
    o atributo select indica quais tags que estão
    dentro do component pai devem ser renderizadas -->
    <ng-Content select="h2, p"></ng-Content>
    ```
    

### Diretivas Estruturais

Moldam ou remodelam a DOM

- ngIF → Condiçional utiliza para renderizar ou não um componente ou elemento HTML
    
    ```jsx
    <p *ngIf="true">card works!</p>
    ```
    
    Sendo possível também assossia-lo a um data binding
    
    ```jsx
    @Component({
      selector: 'app-root',
      templateUrl: './app.component.html',
      styleUrls: ['./app.component.css']
    })
    export class AppComponent {
      title = 'diretivas-proj';
      isAliveCard: boolean = true // propriedade isAliveCard criada 
    															//dentro da class app componente
    }
    
    <!-- Propriedade é vinculada ao componente com o ngIF -->
    <!-- Dessa forma o componente será exibido ou não na tela -->
    <!-- De acordo com o valor da propriedade isAlive -->
    <!-- Se true o componente é exibido -->
    <!-- Se false o componente não é exibido -->
    
    <app-card *ngIf="isAliveCard"></app-card>
    ```
    
    Utlizando o ngIF com o NgTemplate
    
    ```jsx
    <!-- else chama o ng-template através o apelido -->
    <app-card *ngIf="isAliveCard; else anotherBlock"></app-card>
    
    <!-- Bloco ng-template é criado -->
    <!-- Deve se passar um apelido para o bloco iniciando com #apelido -->
    <ng-template #anotherBlock >
      <p>Sou um bloco secreto</p>
    </ng-template>
    ```
    
- ngFor → itera sobre um array, desenhando os itens na tela
    
    ```jsx
    export class CardComponent implements OnInit {
    
      produtos : string[] = []
    
      constructor() {
        // array de produtos dentro da classe card component
        this.produtos = [
          'mouse',
          'teclado',
          'cabo',
          'fonte'
        ]
      }
    
    <ul>
      <!-- ngFor sendo chamdo dentro da LI -->
      <!-- irá iterar sobre o array de produtos -->
      <!-- e Exiber os produtos na tela através de interpolção -->
      <li *ngFor="let p of produtos">{{ p }}</li>
    </ul>
    ```
    
    ngFor possui uma variável disponível, que podemos utiliza-la ou não, o Index. Com essa variável é possível rastrear um elemento e aplicar uma lógica nele.
    
    ```jsx
    <!-- let i recebe todos os index do array que está sendo iterado -->
      <!-- E depois é impresso na tela com interporlação -->
      <li *ngFor="let p of produtos; let i =index"
      (click)='remover(i)'>{{ p }} - {{ i }}</li>
      <button (click)="adicionar()">Adicionar</button>
    ```
    
- ngSwitchCase → Criar blocos condicionais, esses blocos podem alternados conforme as interações do usuário
    
    ```jsx
    export class CardComponent implements OnInit {
    
      produtos : string[] = []
      menuType : string = 'user' // propriedade menuType, irá receber o tipo de usuário
           // cada tipo de usuário terá acesso a diferentes opções no menu
    }
    
    <!-- Property biding referenciando a propriedade menuType -->
    <!-- As opções do switchCase são envolvida em elemente pai que 
    recebe esse binding -->
    <div [ngSwitch]="menuType">
      <!-- Aqui vem os switchCases cada um com um tipo de usuário e 
    	suas opçoes de menu -->
      <!-- switchCaseDefault indica que se o tipo de usário não 
    	for encontrado deve ser renderizar o padrão -->
      <div *ngSwitchDefault="'user'">
        <ul>
          <li>Editar Perfil</li>
          <li>Adiconar cartão</li>
        </ul>
      </div>
      <div *ngSwitchCase="'admin'">
        <ul>
          <li>Editar Perfil</li>
          <li>Adiconar cartão</li>
          <li>Genranciar usuários</li>
        </ul>
      </div>
      <div *ngSwitchCase="'superUser'">
        <ul>
          <li>Editar Perfil</li>
          <li>Adiconar cartão</li>
          <li>Genranciar usuários</li>
          <li>Genrenciar Admins</li>
        </ul>
      </div>
    </div>
    ```
    
### Certificado

![](../diretivas-proj/src/assets/ceritifcado.png)

<hr>
#### DiretivasProj

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 14.1.2.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.
