import { environment } from './../../environments/environment';
import { Usuario } from './../models/Usuario';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UrlSerializer } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  
  resourcePath: string= environment.serverJson; 
  
  constructor(private http: HttpClient) { }

  addUsuario(listaUsuarios: Usuario){
    return this.http.post<Usuario>(`${this.resourcePath}/api/usuarios`, listaUsuarios);
  }

  getUsuarios(){
    return this.http.get<Usuario[]>(`${this.resourcePath}/api/usuarios`);
  }
 
  getID(usuario: String){
    return this.http.get<Usuario>(`${this.resourcePath}/api/usuarios/usuario/${usuario}`);
  }

  updateUsuario(id: any, usuario: Usuario){
    return this.http.put<Usuario>(`${this.resourcePath}/api/usuarios/${id}`, usuario);
  }
}
