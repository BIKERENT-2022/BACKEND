import { MatTableDataSource } from '@angular/material/table';
import { Usuario } from './../../models/Usuario';
import { UsuarioService } from './../../services/usuario.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ClienteService } from 'src/app/services/cliente.service';
import { Cliente } from 'src/app/models/Cliente';

@Component({
  selector: 'app-pago-basic',
  templateUrl: './pago-basic.component.html',
  styleUrls: ['./pago-basic.component.css']
})
export class PagoBasicComponent implements OnInit {

  myForm!:FormGroup;
  cliente!: Cliente;
  usuario!: string;
  usuarioo!: Usuario;

  constructor(private fb: FormBuilder,
    private clienteService: ClienteService,
    private usuarioservice: UsuarioService,
    private snackBar: MatSnackBar,
    private router: Router,
    private activatedRouter: ActivatedRoute){}

  ngOnInit(): void {
    this.usuario = this.activatedRouter.snapshot.params["usuario"];
    this.reactiveForm();
    this.gettttID();
  }

  reactiveForm(){
    this.myForm= this.fb.group({
      id:[''],
      Cuenta: ['',[Validators.required]],
      Nombre: ['',[Validators.required, Validators.pattern(/^[a-zA-Z]+$/)]],
      Correo:['',[Validators.required, Validators.email]],
      Telefono:['',[Validators.required, Validators.pattern(/^\d{9}$/)], Validators.minLength(9), Validators.maxLength(9)],
      Direccion:['',[Validators.required]],
      DNI:['', [Validators.required, Validators.pattern(/^\d{10}$/), Validators.minLength(10), Validators.maxLength(10)]]
    })    
  }

  gettttID(): void{
    this.usuarioservice.getID(this.usuario).subscribe((data: Usuario) => {
      this.usuarioo=data;
    });
  }

  UpdateCliente(){
    const cliente: Cliente={
      id: 0,
      dni: this.myForm.get('DNI')!.value,
      nombre: this.myForm.get('Nombre')!.value,
      correo: this.myForm.get('Correo')!.value,
      direccion: this.myForm.get('Direccion')!.value,
      telefono: this.myForm.get('Telefono')!.value,
      imagen: 'null',
    }
    this.clienteService.updateCliente(this.usuarioo.id,cliente).subscribe({
      next:(data)=>{
        this.snackBar.open('agregado','',{duration: 3000});
        this.router.navigate(['/home', this.usuarioo.id])
      },
      error: (err)=>{console.log(err)}
    })
  }


  
}