import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ControleGeralComponent } from './pages/controle-geral/controle-geral.component';
import { PainelComponent } from './pages/painel/painel.component';
import { ConfiguracaoComponent } from './pages/configuracao/configuracao.component';
import { RelatorioHistoricoComponent } from './pages/relatorio-historico/relatorio-historico.component';
import { VideoRelatorioComponent } from './pages/video-relatorio/video-relatorio.component';
import { Inversor1Component } from './pages/inversor1/inversor1.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'relatorio', component: ControleGeralComponent},
  {path: 'relatorio-historico', component: RelatorioHistoricoComponent},
  {path: 'configuracao', component: ConfiguracaoComponent},
  {path: 'painel', component: PainelComponent},
  {path: 'video', component: VideoRelatorioComponent},
  {path: '**', redirectTo: ""}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
