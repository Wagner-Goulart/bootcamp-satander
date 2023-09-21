import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
// IMPORTAÇÃO
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CardComponent } from './components/card/card.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    CardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule, // DEVE SER DECLARADO DENTRO DO IMPORTS PARA FUNCIONAR
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
