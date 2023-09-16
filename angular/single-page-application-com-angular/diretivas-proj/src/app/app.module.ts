import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CardComponent } from './card/card.component';
import { CompAtributosComponent } from './comp-atributos/comp-atributos.component';

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
export class AppModule { }
