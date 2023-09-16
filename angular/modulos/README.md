# Módulos Angular

Os módulos do Angular são como caixas, onde são guardados os componentes e suas partes inteligentes, todos com os componentes do Angular devem estar registrado em um módulo para que o compornente pode ser utilizado.

Ao iniciarmos um novo projeto, o Angular já cria por padrão um arquivo de módulos, e irá registrar nesse arquivo todos os componentes que são criados, que forem criados através do CLI do Angular.

Mas, para facilitar a organização do código, podemos criar outros arquivos de módulo e até mesmo separar esse arquivos de acordo com o contexto dos componentes que irá receber e depois importar esses componente para o módulo principal. Já que os módulos além de registrarem nosso componentes, também servem para importar e exportar componentes e outros módulos.

### Anatomia de um módulo:

```
@NgModule({
  declarations: [ // componente são declarados aqui
    AppComponent,
    CardComponent,
    CompAtributosComponent
  ],
  imports: [ // aqui são importados os módulo, sejam nativos do Angular, ou criados por nós mesmo
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  exports:[], // aqui são declarados tudo aquilo que queremos fornecer para outros módulos.
  providers: [], // aqui ficam as injeções de dependencias, tudo que recupera algum dado
  bootstrap: [AppComponent] // define quais são os componentes de inicialização.
})
```

### Certificado:

![](./certificado.png)