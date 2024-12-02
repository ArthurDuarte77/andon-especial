import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Client, Message } from '@stomp/stompjs';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class WebsocketService {
  constructor(private http: HttpClient) {}

  changeColor(op: string, status: string) {
    this.http.get(`${environment.secondApiUrl}changeColor/inversor2?op=${op}&status=${status}`)
  }

}
