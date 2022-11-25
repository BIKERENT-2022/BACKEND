import { Repartidor } from './../models/Repartidor';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from './../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RepartidorService {

  basePath: string = environment.serverJson; 

  constructor(private http: HttpClient) { }

  getRepartidor(){
    return this.http.get<Repartidor[]>(`${this.basePath}/api/deliveries`);
  }

  getRepartidorId(id: any) {
    return this.http.get<Repartidor>(`${this.basePath}/${id}`);
  }

  addRepartidor(Repartidor: Repartidor){
    return this.http.post<Repartidor>(this.basePath, Repartidor);
  }

  updateRepartidor(id: any, Repartidor: Repartidor){
    return this.http.put<Repartidor>(`${this.basePath}/${id}`, Repartidor);
  }

  deleteRepartidor(id: any){
    return this.http.delete<Repartidor>(`${this.basePath}/${id}`);
  }

  exportCliente() {
    return this.http.get("http://localhost:8080/api/deliveries/export/excel", {responseType: "blob"});
  }
}
