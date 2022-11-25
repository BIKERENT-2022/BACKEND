import { Empresa } from './../../models/Empresa';
import { EmpresaService } from './../../services/empresa.service';
import { UsuarioService } from './../../services/usuario.service';
import { Usuario } from './../../models/Usuario';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ClienteService } from 'src/app/services/cliente.service';
import { Cliente } from 'src/app/models/Cliente';

@Component({
  selector: 'app-pago-plan',
  templateUrl: './pago-plan.component.html',
  styleUrls: ['./pago-plan.component.css']
})
export class PagoPlanComponent implements OnInit {

  myForm!:FormGroup;
  cliente!: Cliente;
  usuario!: string;
  usuarioo!:Usuario;

  constructor(private fb: FormBuilder,
    private empresaService: EmpresaService,
    private usuarioservice: UsuarioService,
    private snackBar: MatSnackBar,
    private router: Router,
    private activatedRouter: ActivatedRoute) 
    
    {this.reactiveForm();}

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
      RUC:['', [Validators.required, Validators.pattern(/^\d{10}$/), Validators.minLength(10), Validators.maxLength(10)]]
    })
  }

  gettttID(): void{
    this.usuarioservice.getID(this.usuario).subscribe((data: Usuario) => {
      this.usuarioo=data;
    });
  }


  UpdateCliente(){
    const cliente: Empresa={
      id: 0,
      ruc: this.myForm.get('RUC')!.value,
      nombre: this.myForm.get('Nombre')!.value,
      correo: this.myForm.get('Correo')!.value,
      direccion: this.myForm.get('Direccion')!.value,
      telefono: this.myForm.get('Telefono')!.value,
      imagen: 'null',
    }
    this.empresaService.updateEmpresa(this.usuarioo.id,cliente).subscribe({
      next:(data)=>{
        this.snackBar.open('agregado','',{duration: 3000});
        this.router.navigate(['/Homee', this.usuarioo.id])
      },
      error: (err)=>{console.log(err)}
    })
  }



}
