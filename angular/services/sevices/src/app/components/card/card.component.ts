import { Component, OnInit } from '@angular/core';
import { PokemonData } from 'src/app/models/pokemonData';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
  pokemon: PokemonData

  constructor( private service: PokemonService) {
    this.pokemon = {
        id: 0,
        name: '',
        sprites:{
          front_default:''
        },
        types:[]
    }
   }

  ngOnInit(): void {
    // FAZENDO A USO DO SERVICE, E CHAMDO O POKEMON PIKACHO DA API
    // SUBSCRIBE É OBRIGARÓTIO
    this.getPokemon('charmander')
  }

  getPokemon(searchName: string){
    // FAZENDO A USO DO SERVICE, E CHAMDO O POKEMON PIKACHO DA API
    // SUBSCRIBE É OBRIGARÓTIO
    this.service.getPokemon(searchName).subscribe({
      // NEXT RETORNA OS VALORES TRATATOS
      next: (res) => {

        this.pokemon = {
          id: res.id,
          name: res.name,
          sprites: res.sprites,
          types: res.types

        }
        console.log(res)
        console.log(res.types)
        console.log(this.pokemon)
      },
      // ERROR RETORNA O ERRO
      error: (err) => console.log('not found')
    })
  }

}
