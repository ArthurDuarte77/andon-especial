import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Main } from 'src/app/model/main';
import { Nodemcu } from 'src/app/model/nodemcu';
import { Modelo } from 'src/app/model/operation/modelo';
import { Operation } from 'src/app/model/operation/operation';
import { Realizado, NameID } from 'src/app/model/realizado';
import { environment } from 'src/environments/environment';

const headers = new HttpHeaders({
  'Authorization': 'Bearer meu-token-de-autenticacao',
  'Content-Type': 'application/json',
});


@Injectable({
  providedIn: 'root'
})

export class OperationService {

  constructor(private http: HttpClient) { }


  get(name: string): Observable<Operation> {
    return this.http.get<Operation>(environment.url + "operation_inversor2/" + name)
  }

  post(body: Nodemcu): Observable<Nodemcu> {
    return this.http.patch<Nodemcu>(environment.url + "nodemcu_inversor2/" + body.nameId.name, body)

  }

  getByName(name: string) {
    return this.http.get<Nodemcu>(environment.url + "nodemcu_inversor2/" + name)
  }

  getTCimposto(): Observable<Main[]> {
    return this.http.get<Main[]>(environment.url + "main_inversor2")
  }

  atualizar(id: number, tempo: boolean) :Observable<any>{
    return this.http.put<any>(environment.url + "contadores_inversor2/" + id + "/" + tempo, {})
  }

  atualizarState(name: string, state: string) {
    this.http.get(environment.url + "nodemcu_inversor2/atualizarState/" + name + "/" + state).subscribe();
  }

  getTempo(id: number){
    return this.http.get<any>(environment.url + "contadores_inversor2/" + id)
  }

  getRealizadoHoraria(name: string): Observable<Realizado> {
    return this.http.get<Realizado>(environment.url + "realizadoHorariaTablet_inversor2/" + name)
  }

  atualizarOcupado(name: string, ocupado: boolean): Observable<Operation> {
    return this.http.get<Operation>(environment.url + `operation_inversor2/${name}/${ocupado}`)
  }

  postQrcode(nome: string, cod: string, aprovado: boolean, op: string, execucao: number) {
    const dataAtual = new Date();
    const dataFormatada = `${dataAtual.getFullYear()}-${(dataAtual.getMonth() + 1).toString().padStart(2, '0')}-${dataAtual.getDate().toString().padStart(2, '0')}`;
    const horaFormatada = dataAtual.toLocaleTimeString();

    return this.http.post(`${environment.url}qrcode_inversor2`, {
      "name": nome,
      "cod": cod,
      "data": dataFormatada,
      "hora": horaFormatada,
      "aprovado": aprovado,
      "op": op,
      "execucao": execucao,
    });
  }

  postIndisponivel(op: string) {
    const dataAtual = new Date();
    const dataFormatada = `${dataAtual.getFullYear()}-${(dataAtual.getMonth() + 1).toString().padStart(2, '0')}-${dataAtual.getDate().toString().padStart(2, '0')}`;
    const horaFormatada = dataAtual.toLocaleTimeString();

    return this.http.post("http://172.16.34.229:3000/indisponivel", {
      "op": op,
      "data": dataFormatada,
      "hora": horaFormatada,
    });
  }

  getFonteAtual(): Promise<Modelo> {
    return new Promise((resolve, reject) => {
      let modeloAtual: Modelo;
      this.http.get<Modelo[]>(environment.url + "fonte_inversor2").subscribe(res => {
        res.forEach((item: Modelo) => {
          if (item.is_current == true) {
            modeloAtual = item;
            resolve(modeloAtual);
          }
        });
        if (modeloAtual == undefined) {
          modeloAtual = {
            modelo: "fonte 40A",
            realizado: 0,
            tempo: 0,
            is_current: true
          };
          resolve(modeloAtual);
        }
      });
    });
  }


  changeIsCurrent(modelo: string, isCurrent: boolean): void {
    this.http.get(environment.url + "fonte_inversor2/" + modelo + "/" + isCurrent).subscribe()
  }

  changeAnalise(nome: string, analise: boolean){
    this.http.get(environment.url + "operation_inversor2/analise/" + nome + "/" + analise).subscribe()
  }

  changeTimeExcess(name: string){
    this.http.get(environment.url + "nodemcu_inversor2/timeExcess/" + name).subscribe()
  }
  changeAjuda(name: string){
    this.http.get(environment.url + "nodemcu_inversor2/ajuda/" + name).subscribe()
  }

  getAll(): Observable<Operation[]>{
    return this.http.get<Operation[]>(environment.url + "operation_inversor2")
  }

  postVideo(name_id: NameID){
    return this.http.post(environment.url + "geral_inversor2/video", {nameId: name_id})
  }

}