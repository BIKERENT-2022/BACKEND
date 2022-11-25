import { MatSnackBar } from '@angular/material/snack-bar';
import { Usuario } from './../../models/Usuario';
import { UsuarioService } from './../../services/usuario.service';
import { Cliente } from './../../models/Cliente';
import { ClienteService } from './../../services/cliente.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm, FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public loginForm!: FormGroup
  usuarios!: Usuario[];

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private router:Router,
    private snackBar: MatSnackBar,
    private clienteService: ClienteService,
    private usuarioService: UsuarioService) { this.getUsuarios();}

  ngOnInit(): void {
    this.loginForm=this.formBuilder.group({
      usuario:[''],
      contrasenia:['']
    })
  }

  getUsuarios(){
    this.usuarioService.getUsuarios().subscribe((data: Usuario[]) => {
      this.usuarios=data;
    });
  }

  Confirmar(): void{

    var position:number=0;
    let usu = this.loginForm.get('usuario')!.value;
    let contra = this.loginForm.get('contrasenia')!.value;

    for(const element of this.usuarios){
      if(element.contrasenia == contra  && element.usuario == usu && element.tipo_usuario=="Cliente"){
        
        this.router.navigate(['/home',element.id]);
        break;

      }
      else if(element.contrasenia == contra  && element.usuario == usu && element.tipo_usuario=="Empresa") {
        
        this.router.navigate(['/Homee',element.id]);
        break;
        
      }
      position++
    }

    if(position==this.usuarios.length)
    {
      this.snackBar.open('Datos ingresados incorrectos', '', {
         duration: 5000,
       });       
    }

  }









  login(){
    this.http.get<any>("http://localhost:3000/Cliente")
    .subscribe(res =>{
      const user = res.find((a:any)=>{
        return a.NombreUsuario === this.loginForm.value.NombreUsuario && a.CorreoElectronico === this.loginForm.value.CorreoElectronico
      })
    })
  }

}
