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
