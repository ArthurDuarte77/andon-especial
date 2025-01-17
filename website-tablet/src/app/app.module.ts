import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from "@angular/common/http"
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CounterComponent } from './pages/counter/counter.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatIconModule} from '@angular/material/icon';
import { DialogHelpComponent } from './shared/dialog-help/dialog-help.component'
import {MatDialogModule} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatRadioModule} from '@angular/material/radio';
import {MatChipsModule} from '@angular/material/chips';
import { DialogFonteComponent } from './shared/dialog-fonte/dialog-fonte.component';
import { DialogAvisoComponent } from './shared/dialog-aviso/dialog-aviso.component';
import { AnaliseComponent } from './pages/analise/analise.component';
import { DialogNameComponent } from './shared/dialog-name/dialog-name.component';
import {MatInputModule} from '@angular/material/input';
import { Inversorl1Component } from './pages/inversorl1/inversorl1.component';
import { Inversorl2Component } from './pages/inversorl2/inversorl2.component';
import { AmplificadorComponent } from './pages/amplificador/amplificador.component';
import { ControleComponent } from './pages/controle/controle.component';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { Amplificadorl2Component } from './pages/amplificadorl2/amplificadorl2.component';
import { GerenciaveisComponent } from './pages/gerenciaveis/gerenciaveis.component';


@NgModule({
  declarations: [
    AppComponent,
    CounterComponent,
    DialogHelpComponent,
    DialogFonteComponent,
    DialogAvisoComponent,
    AnaliseComponent,
    DialogNameComponent,
    Inversorl1Component,
    Inversorl2Component,
    AmplificadorComponent,
    ControleComponent,
    Amplificadorl2Component,
    GerenciaveisComponent,

  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatSnackBarModule,
    ReactiveFormsModule,
    MatIconModule,
    MatDialogModule,
    MatButtonModule,
    MatExpansionModule,
    MatCheckboxModule,
    MatRadioModule,
    FormsModule,
    MatChipsModule,
    MatInputModule,
    MatProgressSpinnerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
