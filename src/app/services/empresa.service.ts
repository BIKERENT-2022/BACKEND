import { Empresa } from './../models/Empresa';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  basePath: string = environment.serverJson; 

  constructor(private http: HttpClient) { }

  getEmpresas() {
    return this.http.get<Empresa[]>(`${this.basePath}/api/empresas`);
  }

  updateEmpresa(usuario: any, cliente: Empresa){
    return this.http.put<Empresa>(`${this.basePath}/api/empresas/${usuario}`, cliente);
  }

  getEmpresaById(id :number){
    return this.http.get<Empresa>(`${this.basePath}/api/empresas/id/${id}`);
  }





  

  getOneEmpresa(id: any) {
    return this.http.get<Empresa>(`${this.basePath}/api/empresas/${id}`);
  }
}
