import { Component, OnDestroy, OnInit } from '@angular/core';
import { Nodemcu } from 'src/app/model/nodemcu';
import { Operation } from 'src/app/model/operation/operation';
import { OperationService } from 'src/app/service/inversorl1/operation.service';
import { WebsocketService } from 'src/app/service/inversorl1/websocket.service';

@Component({
  selector: 'app-analise',
  templateUrl: './analise.component.html',
  styleUrls: ['./analise.component.scss']
})
export class AnaliseComponent implements OnInit, OnDestroy{

  constructor(private service: OperationService,     private websocketService: WebsocketService) { }



  nodemcu: Operation[] = []
  intervalo: any;

  ngOnDestroy(): void {
    clearInterval(this.intervalo)
  }
  ngOnInit(): void {
    this.service.getAll().subscribe(res => {
      this.nodemcu = res
    })
    this.intervalo = setInterval(() => {
      this.service.getAll().subscribe(res => {
        this.nodemcu = res
      })
    }, 5000)
  }


  changeAnalise(item: Operation){
    this.service.changeAnalise(item.name, !item.analise)
    if(!item.analise){
      this.websocketService.changeColor(item.name, 'azul');
    }else{
      this.websocketService.changeColor(item.name, 'verde');
    }
  }

  enterFullscreen() {
    const element = document.documentElement;

    if (element.requestFullscreen) {
      element.requestFullscreen();
    }
  }
}
