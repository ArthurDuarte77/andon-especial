import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CounterComponent } from './pages/counter/counter.component';
import { AppComponent } from './app.component';
import { AnaliseComponent } from './pages/analise/analise.component';
import { Inversorl1Component } from './pages/inversorl1/inversorl1.component';
import { Inversorl2Component } from './pages/inversorl2/inversorl2.component';
import { AmplificadorComponent } from './pages/amplificador/amplificador.component';
import { ControleComponent } from './pages/controle/controle.component';
import { Amplificadorl2Component } from './pages/amplificadorl2/amplificadorl2.component';
import { GerenciaveisComponent } from './pages/gerenciaveis/gerenciaveis.component';

const routes: Routes = [
  { path: 'counter/:name', component: CounterComponent },
  {path: 'inversorl1/:name', component: Inversorl1Component},
  {path: 'inversorl2/:name', component: Inversorl2Component},
  {path: 'amplificador/:name', component: AmplificadorComponent},
  {path: 'amplificadorl2/:name', component: Amplificadorl2Component},
  {path: 'controle/:name', component: ControleComponent},
  {path: 'gerenciaveis/:name', component: GerenciaveisComponent},
  { path: 'lider', component: AnaliseComponent },
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
