import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-comp-atributos',
  templateUrl: './comp-atributos.component.html',
  styleUrls: ['./comp-atributos.component.css']
})
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
