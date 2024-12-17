import { MainAmplificador1Service } from './../../service/amplificador/main.service';
import { Component, inject, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Main } from 'src/app/module/main';
import { Modelo } from 'src/app/module/modelo';
import { ModeloAmplificador1Service } from 'src/app/service/amplificador/modelo.service';
import { MainAmplificador2Service } from 'src/app/service/amplificador2/main.service';
import { ModeloAmplificador2Service } from 'src/app/service/amplificador2/modelo.service';
import { MainControleService } from 'src/app/service/controle/main.service';
import { ModeloControleService } from 'src/app/service/controle/modelo.service';
import { MainInversor1Service } from 'src/app/service/inversor1/main.service';
import { ModeloInversor1Service } from 'src/app/service/inversor1/modelo.service';
import { MainInversor2Service } from 'src/app/service/inversor2/main.service';
import { ModeloInversor2Service } from 'src/app/service/inversor2/modelo.service';

@Component({
  selector: 'app-dialog-meta',
  templateUrl: './dialog-meta.component.html',
  styleUrls: ['./dialog-meta.component.scss'],
})
export class DialogMetaComponent implements OnInit {
  constructor(
    private modeloServiceAmplificador2: ModeloAmplificador2Service,
    private modeloServiceAmplificador: ModeloAmplificador1Service,
    private modeloServiceControle: ModeloControleService,
    private modeloServiceInversor1: ModeloInversor1Service,
    private modeloServiceInversor2: ModeloInversor2Service,
    private mainAmplificador1Service: MainAmplificador1Service,
    private mainAmplificador2Service: MainAmplificador2Service,
    private mainControleService: MainControleService,
    private mainInversor1Service: MainInversor1Service,
    private mainInversor2Service: MainInversor2Service
  ) {}

  modelos: Modelo[] = [];
  modelControl = new FormControl('');
  input = new FormControl(0);
  op = new FormControl(0);
  data = inject(MAT_DIALOG_DATA);
  main!: Main;
  selectedModel: any;

  ngOnInit(): void {
    if (this.data.type == 'amplificador2') {
      this.modeloServiceAmplificador2.getAll().subscribe((res) => {
        this.modelos = res;
        this.selectedModel = this.modelos.find(item => item.is_current == true)?.modelo;
      });
    } else if (this.data.type == 'amplificador') {
      this.modeloServiceAmplificador.getAll().subscribe((res) => {
        this.modelos = res;
        this.selectedModel = this.modelos.find(item => item.is_current == true)?.modelo;
      });
    } else if (this.data.type == 'controle') {
      this.modeloServiceControle.getAll().subscribe((res) => {
        this.modelos = res;
        this.selectedModel = this.modelos.find(item => item.is_current == true)?.modelo;
      });
    } else if (this.data.type == 'inversor') {
      this.modeloServiceInversor1.getAll().subscribe((res) => {
        this.modelos = res;
        this.selectedModel = this.modelos.find(item => item.is_current == true)?.modelo;
      });
    } else if (this.data.type == 'inversor2') {
      this.modeloServiceInversor2.getAll().subscribe((res) => {
        this.modelos = res;
        this.selectedModel = this.modelos.find(item => item.is_current == true)?.modelo;
      });
    }


    if (this.data.type == 'amplificador2') {
      this.mainAmplificador2Service.getAllMain().subscribe((res) => {
        this.main = res[0];
        this.input.setValue(this.main.imposto)
        this.op.setValue(parseInt(this.main.op))
      });
    } else if (this.data.type == 'amplificador') {
      this.mainAmplificador1Service.getAllMain().subscribe((res) => {
        this.main = res[0];
        this.input.setValue(this.main.imposto)
        this.op.setValue(parseInt(this.main.op))
      });
    } else if (this.data.type == 'controle') {
      this.mainControleService.getAllMain().subscribe((res) => {
        this.main = res[0];
        this.input.setValue(this.main.imposto)
        this.op.setValue(parseInt(this.main.op))
      });
    } else if (this.data.type == 'inversor') {
      this.mainInversor1Service.getAllMain().subscribe((res) => {
        this.main = res[0];
        this.input.setValue(this.main.imposto)
        this.op.setValue(parseInt(this.main.op))
      });
    } else if (this.data.type == 'inversor2') {
      this.mainInversor2Service.getAllMain().subscribe((res) => {
        this.main = res[0];
        this.input.setValue(this.main.imposto)
        this.op.setValue(parseInt(this.main.op))
      });
    }
  }

  changeIsCurrent(modelo: Modelo) {
    if (this.data.type == 'amplificador2') {
      this.modelos.forEach((item) => {
        if (item.is_current == true) {
          this.modeloServiceAmplificador2.changeIsCurrent(item.modelo, false);
        }
      });
      this.modeloServiceAmplificador2.changeIsCurrent(modelo.modelo, true);
    } else if (this.data.type == 'amplificador') {
      this.modelos.forEach((item) => {
        if (item.is_current == true) {
          this.modeloServiceAmplificador.changeIsCurrent(item.modelo, false);
        }
      });
      this.modeloServiceAmplificador.changeIsCurrent(modelo.modelo, true);
    } else if (this.data.type == 'controle') {
      this.modelos.forEach((item) => {
        if (item.is_current == true) {
          this.modeloServiceControle.changeIsCurrent(item.modelo, false);
        }
      });
      this.modeloServiceControle.changeIsCurrent(modelo.modelo, true);
    } else if (this.data.type == 'inversor') {
      this.modelos.forEach((item) => {
        if (item.is_current == true) {
          this.modeloServiceInversor1.changeIsCurrent(item.modelo, false);
        }
      });
      this.modeloServiceInversor1.changeIsCurrent(modelo.modelo, true);
    } else if (this.data.type == 'inversor2') {
      this.modelos.forEach((item) => {
        if (item.is_current == true) {
          this.modeloServiceInversor2.changeIsCurrent(item.modelo, false);
        }
      });
      this.modeloServiceInversor2.changeIsCurrent(modelo.modelo, true);
    }
  }
}
