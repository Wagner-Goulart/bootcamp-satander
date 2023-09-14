import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  produtos : string[] = []
  menuType : string = 'user' // propriedade menuType, irá receber o tipo de usuário
                            // cada tipo de usuário terá acesso a diferentes opções no menu

  constructor() {
    // array de produtos dentro da classe card component
    this.produtos = [
      'mouse',
      'teclado',
      'cabo',
      'fonte'
    ]
  }

  ngOnInit(): void {
  }

  adicionar(){
    this.produtos.push('Wagner')
  }

  remover(index: number){
    this.produtos.splice(index,1)
  }

}
