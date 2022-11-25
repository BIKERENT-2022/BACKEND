import { UsuarioService } from './../../services/usuario.service';
import { Usuario } from './../../models/Usuario';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  myForm!:FormGroup

  constructor(private fb: FormBuilder,
    private usuarioService: UsuarioService,
    private snackBar: MatSnackBar,
    private router: Router,) {this.reactiveForm();}

  ngOnInit(): void {
  }

  reactiveForm(){
    this.myForm= this.fb.group({
      id:[''],
      tipo_usuario: ['',[Validators.required]],
      usuario: ['',[Validators.required, Validators.pattern(/^[a-zA-Z0-9]+$/) , Validators.minLength(5)]],
      contrasenia:['',[Validators.required, Validators.minLength(8)]],
      confcontrasenia:['',[Validators.required, Validators.minLength(8)]],
    })
  }

  saveUsuario(){

    const contrasenia: String = this.myForm.get('contrasenia')!.value;
    const confcontrasenia: String = this.myForm.get('confcontrasenia')!.value;

    if(contrasenia == confcontrasenia){

      const listaUsuarios: Usuario={
        id : 0,
        tipo_usuario : this.myForm.get('tipo_usuario')!.value,
        usuario : this.myForm.get('usuario')!.value,
        contrasenia : this.myForm.get('contrasenia')!.value
      }

      this.usuarioService.addUsuario(listaUsuarios).subscribe({
        next:(data)=>{
          let usuario = this.myForm.get('usuario')!.value;
          this.snackBar.open('registrado correctamente', '',{duration: 2000});
          if(this.myForm.get('tipo_usuario')!.value=='Cliente')
          {
            this.router.navigate(['/Condicionesbasic', usuario])
          }
          else if (this.myForm.get('tipo_usuario')!.value=='Empresa') 
          {this.router.navigate(['/condicionesEmpresa', usuario])} 
        },
        error: (err)=>{console.log(err)}
      })
  
    }
    
    else{
      this.snackBar.open('Las contraseñas ingresadas no coinciden', '',{
        duration: 5000,
      });
    }

  }
  






  /*
  ValidarCampos()
  {
      //Obtendremos los valores de los inputs
      const NombreUsuario = document.getElementById("NombreUsuario") as HTMLInputElement | null;
      const email = document.getElementById("email") as HTMLInputElement | null;
      const contrasenia = document.getElementById('contrasenia') as HTMLInputElement  | null;
      const confcont = document.getElementById('confcont') as HTMLInputElement | null;
  
      // Verificamos que los campos no se encuentren vacíos
      if( NombreUsuario?.value == "" || email?.value == "" || contrasenia?.value == "" || confcont?.value == "")
      {
          // Si alguno de los campos se encuentra vacío, retornamos false
          return false;
      }
      else {
          // Si los campos están completos ocultamos retornamos true
          return true;
      }
  }


  verificarPasswords()
  {
    //Obtendremos los valores de contraseña
    const contrasenia = document.getElementById('contrasenia') as HTMLInputElement;
    const confcont = document.getElementById('confcont') as HTMLInputElement;

    //Asignamos valores a los mensajes de validacion
    const error = document.getElementById("error") as HTMLDivElement;    
    const campos_vacios = document.getElementById("campos_vacios") as HTMLDivElement;
    const ok = document.getElementById("ok") as HTMLDivElement;
    const register = document.getElementById("register") as HTMLButtonElement;

    
    if (this.ValidarCampos() == false) {
        // Ocultamos el mensaje de error
        error.classList.remove("mostrar");
        // Al validar algun campo vacío, mostramos un mensaje validar campos
        campos_vacios.classList.add("mostrar");
        
        return false;
    }
    else {
            // Al validar que los campos estén completos ocultaremos el mensaje de validar campos
            campos_vacios.classList.remove("mostrar");

            //Verificaremos que los valores coincidan
            if (contrasenia.value != confcont.value) {

            // Si las constraseñas no coinciden mostramos un mensaje
            error.classList.add("mostrar");
        
            return false;
        }
        else {
            // Si las contraseñas coinciden ocultamos el mensaje de error
            error.classList.remove("mostrar");
        
            // Mostramos un mensaje mencionando que las Contraseñas coinciden
            ok.classList.remove("ocultar");
                
            // Desabilitamos el botón de register
            register.disabled = true;
        
            // Cargamos la página de destino
            
            if( this.myForm.get('Cuenta')!.value== "") this.snackBar.open('Selecccione Tipo de Cuenta', '',{duration: 2000});
            if(this.myForm.get('Cuenta')!.value=='Cliente'){this.router.navigate(['/Condicionesbasic'])}
            else if (this.myForm.get('Cuenta')!.value=='Empresa') {this.router.navigate(['/condicionesEmpresa'])}
            this.snackBar.open('registrado correctamente', '',{duration: 2000});
            
            return true;
        }
        register.disabled = false;
    }
  }
  */

}
