import { Component, inject, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Modelo } from 'src/app/module/modelo';
import { ModeloAmplificador1Service } from 'src/app/service/amplificador/modelo.service';
import { ModeloAmplificador2Service } from 'src/app/service/amplificador2/modelo.service';
import { ModeloControleService } from 'src/app/service/controle/modelo.service';
import { ModeloInversor1Service } from 'src/app/service/inversor1/modelo.service';
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
    private modeloServiceInversor2: ModeloInversor2Service
  ) {}

  modelos: Modelo[] = [];
  modelControl = new FormControl('');
  input = new FormControl(0);
  op = new FormControl(0);
  data = inject(MAT_DIALOG_DATA);

  ngOnInit(): void {
    if (this.data.type == 'amplificador2') {
      this.modeloServiceAmplificador2.getAll().subscribe((res) => {
        this.modelos = res;
      });
    } else if (this.data.type == 'amplificador') {
      this.modeloServiceAmplificador.getAll().subscribe((res) => {
        this.modelos = res;
      });
    } else if (this.data.type == 'controle') {
      this.modeloServiceControle.getAll().subscribe((res) => {
        this.modelos = res;
      });
    } else if (this.data.type == 'inversor') {
      this.modeloServiceInversor1.getAll().subscribe((res) => {
        this.modelos = res;
      });
    } else if (this.data.type == 'inversor2') {
      this.modeloServiceInversor2.getAll().subscribe((res) => {
        this.modelos = res;
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
