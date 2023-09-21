# SERVICES

![Angular](https://img.shields.io/badge/angular-%23DD0031.svg?style=for-the-badge&logo=angular&logoColor=white)

Services cuidam das regras de negócio;

Componentes cuidam do visual;

Crie Services especialistas em cada coisa, evite Services que fazem muita coisa.

### Anatomia de um Service:

```jsx
// Importação do Angular Core, Indica que ele é um conteúdo injetável
import { Injectable } from '@angular/core';

@Injectable({
// indica onde ele estará disponível
// nesse caso indica 'root', ou seja está disponnível para toda aplicação
  providedIn: 'root'
})

// No restantes, é um classe TS normal.
export class PokemonService {

  constructor() { }
}
```

### Como injetar os Service nos componentes:

O Service é injetado no construtor do componente que fará uso do serviço.

```jsx
@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
  name: string = 'CHARIZARD'
  atributes: string[] = ['FIRE', 'ROCK']
	
	// SERVICE É INJETADO NO CONSTRUTOR DO COMPONENTE.
// PRIVATE {NOME-VARIACAL} : {CLASSE DO SERVICE} => ANATOMIA INJEÇÃO SERVICE
  constructor( private service: PokemonService) { }

  ngOnInit(): void {
// AQUI É CHAMADO O MÉTODO getPokemon, que foi criado dentro do service.
    this.service.getPokemon('Picachu')
  }

}
```

### Fazendo requisições HTTP no Angular.

Para realizar requisições no Angular é necessário realizar duas importações *HttpClientModule* e *HttpClient*

*HttpClientModule → é um módulo e deve ser chamado dentro de arquivo de módulos;*

```jsx
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
//----------- IMPORTAÇÃO------------------------
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CardComponent } from './components/card/card.component';

@NgModule({
  declarations: [
    AppComponent,
    CardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
		//--------------------------------------------------------------------
    HttpClientModule // DEVE SER DECLARADO DENTRO DO IMPORTS PARA FUNCIONAR
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```

*HttpClient → é uma classe do módulo e é chamado no service que fará a requisição*

```jsx
// IMPORTAÇÃO
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment'

@Injectable({
  providedIn: 'root'
})
export class PokemonService {
  private baseUrl: string = ''
  private pokeData: any

  constructor(
    // INJETADO DENTRO DO CONTRUTOR
    private Http : HttpClient
  ) {
    this.baseUrl = environment.pokeApi
  }

  getPokemon(pokemonName: string){
    // CHAMADA PARA API
    this.pokeData = this.Http.get(`${this.baseUrl}${pokemonName}`)
    console.log(this.pokeData)
  }
}
```

### Observables

Semelhante a uma promise, se a chamada da API não for tratada irá retornar uma Obervable pura.

A observable precisa ser importarda para funcionar, e ele também precisa ser tipada.

- Criando um modelo para os dados do pokemom
    
    ```jsx
    export type PokemonData = {
      name: string,
      id:number
    }
    ```
    
- Importando e tipando a Observable
    
    ```jsx
    // IMPORTAÇÃO
    import { HttpClient } from '@angular/common/http';
    import { Injectable } from '@angular/core';
    import { environment } from 'src/environments/environment';
    //-----IMPORTANDO A OBSERVABLE
    import { Observable } from 'rxjs';
    import { PokemonData } from '../../app/models/pokemonData';
    
    @Injectable({
      providedIn: 'root',
    })
    export class PokemonService {
      private baseUrl: string = '';
      // TIPANDO COM O MODELO DE POKEMON CRIADO
      private pokeData: PokemonData | any;
    
      constructor(
    
        private Http: HttpClient
      ) {
        this.baseUrl = environment.pokeApi;
      }
      // TIPANDO A OBSERVABLE COM O MODELO DE POKEMON
      getPokemon(pokemonName: string): Observable<PokemonData> {
        // CHAMADA PARA API TIPANDO O GET COM O MODELOS DE POKEMON
        this.pokeData = this.Http.get<PokemonData>(`${this.baseUrl}${pokemonName}`);
        return this.pokeData;
      }
    }
    ```
    
- Usando no componente
    
    ```jsx
    import { Component, OnInit } from '@angular/core';
    import { PokemonService } from 'src/app/services/pokemon.service';
    
    @Component({
      selector: 'app-card',
      templateUrl: './card.component.html',
      styleUrls: ['./card.component.css']
    })
    export class CardComponent implements OnInit {
      name: string = 'CHARIZARD'
      atributes: string[] = ['FIRE', 'ROCK']
    
      constructor( private service: PokemonService) { }
    
      ngOnInit(): void {
        // FAZENDO A USO DO SERVICE, E CHAMDO O POKEMON PIKACHO DA API
        // SUBSCRIBE É OBRIGARÓTIO
        this.service.getPokemon('pikachu').subscribe({
          // NEXT RETORNA OS VALORES TRATATOS
          next: (res) => console.log(res),
          // ERROR RETORNA O ERRO
          error: (err) => console.log(err)
        })
      }
    
    }
    ```