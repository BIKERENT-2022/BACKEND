import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Bicicleta } from '../models/Bicicleta';

@Injectable({
  providedIn: 'root'
})
export class BicicletaService {

  basePath: string = environment.serverJson; 

  constructor(private http: HttpClient) { }

  getBicicletas() {
    return this.http.get<Bicicleta[]>(`${this.basePath}/api/bicicletas`);
  }


  

  getOneBicicleta(id: any) {
    return this.http.get<Bicicleta>(`${this.basePath}/api/bicicletas/${id}`);
  }



  addBicicleta(bicicleta: Bicicleta){
    return this.http.post<Bicicleta>(`${this.basePath}/api/bicicletas`, bicicleta);
  }



  updateBicicleta(id: any, bicicleta: Bicicleta){
    return this.http.put<Bicicleta>(`${this.basePath}/api/bicicletas/${id}`, bicicleta);
  }

  deleteBicicleta(id: number){
    return this.http.delete<Bicicleta>(`${this.basePath}/api/bicicletas/${id}`)
  }


  getMarcaBicicletas(marca: any) {
    return this.http.get<Bicicleta[]>(`${this.basePath}/api/bicicletas/marca/${marca}`);
  }


  exportCliente() {
    return this.http.get("http://localhost:8080/api/bicicletas/export/excel", {responseType: "blob"});
  }
}
