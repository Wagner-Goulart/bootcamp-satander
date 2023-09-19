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
