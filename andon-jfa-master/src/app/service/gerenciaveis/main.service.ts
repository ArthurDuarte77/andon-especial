import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Main } from '../../module/main';
import { environment } from 'src/environments/environment.development';
import { RealizadoGeral } from '../../module/realizadoGeral';
import { Realizado } from '../../module/realizado';

@Injectable({
  providedIn: 'root'
})
export class MainGerenciaveisService {

  constructor(private http: HttpClient) { }


  put(imposto: number, tcimposto: number, shiftTime: number, op: string) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.put<any>(
       environment.url + 'main_gerenciaveis/1',{imposto, tcimposto, shiftTime, op}, {headers});
  }

  getAllMain(): Observable<Main[]> {
    return this.http.get<Main[]>( environment.url + 'main_gerenciaveis');
  }

  getAllRealizado(): Observable<Realizado[]>{
    return this.http.get<Realizado[]>(environment.url + "realizadoHorariaTablet_gerenciaveis")
  }

  postGerenciaveisRealizado(imposto: number, realizado: number, realizadoHora: number, justificativa: string): Observable<RealizadoGeral>{
    return this.http.post<RealizadoGeral>(environment.url + "realizado_gerenciaveis", {
      "imposto": imposto,
      "realizado": realizado,
      "realizadoHora": realizadoHora,
      "justificativa": justificativa
  })
  }

  getGerenciaveisRealizadoByDate(): Observable<RealizadoGeral[]>{
    // return this.http.get<RealizadoGeral[]>(environment.url + "realizado")
    const realizadoGeral: RealizadoGeral[] = []
    return of(realizadoGeral);
  }
}
