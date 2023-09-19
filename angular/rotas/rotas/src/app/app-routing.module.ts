import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TitleComponent } from './pages/index/title/title.component';
import { CardComponent } from './pages/portifolio/card/card.component';

const routes: Routes = [
  {
    path: '', // INDICA O CAMINHO DA ROTA
    component: TitleComponent, // INDICA QUAL COMPONENTE DEVE SER RENDERIZADO QUANDO A ROTA É ACESSADA
    pathMatch:'full' // INDICA INDICA SE A ROTA PRECISA SER EXATAMENTA IGUAL OU NÃO AO DECLARADO EM PATH
  },
  {
    // CRIAR A ROTA PORTIFOLIO
    //http://localhost:4200/portifolio
    path:'portifolio',
    component: CardComponent,
    // CRIAR A SUBROTA DE PORTIFOLIO PASSANDO O ID COMO PAMETRO
    children: [
      {
        //http://localhost:4200/portifolio/1
        path:':id',
        component: CardComponent,
      },

    ]
  },
  {// ROTA CORINGA
    path:'**', // AQUI INDICA QUE O CAMINHO PODE SER QUALQUER COISA
    redirectTo:''// AQUI ESTAMOS DIRECIONANDO O USUÁRIO PARA HOJE, MAS PODERIA SER PASSADO QUALQUER OUTRA ROTA
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
