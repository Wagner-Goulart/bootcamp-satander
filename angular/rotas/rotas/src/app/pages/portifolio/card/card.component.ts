import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css'],
})
export class CardComponent implements OnInit {

  // Injetado a dependencia private navegador: Router
  // TIPAGEM ROUTER É IMPORTADODO DO ANGULAR E É OBRIGATORIA
  constructor(private activeRoute: ActivatedRoute, private navegador: Router) {
    // AQUI RECUPERA ISSO =>  http://localhost:4200/portifolio/{1} => [:id]
    this.activeRoute.params.subscribe((res) => console.log(res));

    //RECUPERA OS PAREMETROS DO COMPONENTE FILHO
    // firstChild PARA ACESSAR OS PARAMETROS DAS ROTAS FILHAS
    // firstChild? "?" É UMA VALIDAÇÃO QUE INDICA QUE ESSE PARAMETRO PODE EXISTIR OU NÃO
    this.activeRoute.firstChild?.params.subscribe((res) => console.log(res));

    // AQUI RECUPERA ISSO => http://localhost:4200/portifolio/1?{name=teste&toke=123} => QUERYPARAMS
    this.activeRoute.queryParams.subscribe((res) => console.log(res));
  }

  ngOnInit(): void {
    // setInterval(()=>{
    //   // DENTRO DO ROUTER TEMOS ACESSO AO NAVIGATE
    //   // DENTRO DO NAVIGATE É INFORMADO A ROTA QUE IREMOS ACESSAR
    //   // NESSE TRECHO DE CÓDIGO, APÓS 5 SEGUNDOS É REDIRECIONADO PARA HOME
    //   this.navegador.navigate(['/'])
    // }, 5000)
  }
}
