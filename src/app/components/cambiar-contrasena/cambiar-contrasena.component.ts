import { Usuario } from './../../models/Usuario';
import { UsuarioService } from './../../services/usuario.service';
import { Component, OnInit } from '@angular/core';
import { Cliente } from './../../models/Cliente';
import { ClienteService } from './../../services/cliente.service';
import { FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-cambiar-contrasena',
  templateUrl: './cambiar-contrasena.component.html',
  styleUrls: ['./cambiar-contrasena.component.css']
})
export class CambiarContrasenaComponent implements OnInit {
  
  myForm!: FormGroup;
  usuario!: string;
  usuarioo!: Usuario;

  constructor(private fb: FormBuilder,
    private clienteService: ClienteService,
    private snackBar: MatSnackBar,
    private usuarioservice: UsuarioService,
    private router: Router)
    
    {this.reactiveForm();}

  ngOnInit(): void {

  }

  reactiveForm() {
    this.myForm = this.fb.group({
      usuario:  ['', [Validators.required]],
      newpwd: ['', [Validators.required, Validators.minLength(8)]],
      conpwd: ['', [Validators.required, Validators.minLength(8)]]
    })
  }
  
  
  gettttID(): void{

  }

  
  UpdatePassword()
  {    

    let nuevaContra = this.myForm.get('newpwd')!.value;
    let confirmarContra = this.myForm.get('conpwd')!.value;

    if(nuevaContra == confirmarContra){

      let a = this.myForm.get('usuario')!.value;
    
      this.usuarioservice.getID(a).subscribe((data: Usuario) => {
        this.usuarioo=data;
      });
      
      
      const usuario: Usuario={      
        id : 0,
        usuario : this.usuarioo.usuario,
        contrasenia : this.myForm.get('newpwd')!.value,
        tipo_usuario : this.usuarioo.tipo_usuario,
      }
      this.usuarioservice.updateUsuario(this.usuarioo.id,usuario).subscribe({
        next:(data)=>{
          this.snackBar.open('la contraseña fue actualizada','',{duration: 3000});
          this.router.navigate([''])
        },
        error: (err)=>{console.log(err)}
      })

    }
    else{
      this.snackBar.open('las contraseñas no coinciden','',{duration: 3000});
    }
    
  }
  



  

}
