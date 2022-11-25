import { ClienteService } from './../../services/cliente.service';
import { Cliente } from './../../models/Cliente';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-ver-perfil',
  templateUrl: './ver-perfil.component.html',
  styleUrls: ['./ver-perfil.component.css']
})
export class VerPerfilComponent implements OnInit {

  myForm!: FormGroup;
  id!: number;
  datosCliente!: Cliente;
  
  constructor(private formBuilder:FormBuilder,
    private clienteService: ClienteService,
    private router: Router,
    private activatedRouter: ActivatedRoute) { }

  ngOnInit(): void {
    this.reactiveForm();
  }

  reactiveForm() {
    this.myForm = this.formBuilder.group({
      id:[""],
      dni:["", [Validators.required]],
      nombre:["", [Validators.required]],
      correo:["", [Validators.required, Validators.email]],
      direccion:["", [Validators.required]],
      telefono:["", [Validators.required]],
      imagen:["", [Validators.required]]
    })

    this.id = this.activatedRouter.snapshot.params["idCliente"];

    if((this.id!=undefined && this.id!=0)) {

      this.clienteService.getOneCliente(this.id).subscribe(
        (data: Cliente) => {
          this.datosCliente = data;

          this.myForm = this.formBuilder.group({            
            dni: [this.datosCliente.dni,[Validators.required]],
            nombre: [this.datosCliente.nombre,[Validators.required]],
            correo: [this.datosCliente.correo,[Validators.required, Validators.email]],
            direccion: [this.datosCliente.direccion,[Validators.required]],
            telefono: [this.datosCliente.telefono,[Validators.required]],
            imagen: [this.datosCliente.imagen,[Validators.required]],
          })
        }
      )

    }
    else {
      this.id = 0;
    }
  }

  saveCliente(): void{
    const cliente:Cliente = {
      id:this.id,
      dni:this.myForm.get("dni")?.value, 
      nombre:this.myForm.get("nombre")?.value, 
      correo:this.myForm.get("correo")?.value, 
      direccion:this.myForm.get("direccion")?.value, 
      telefono:this.myForm.get("telefono")?.value, 
      imagen:this.myForm.get("imagen")?.value
    }
    this.clienteService.updateCliente(this.id, cliente).subscribe({
      next: (data) => {
      },
      error: (err) => {}


    })
  }
  getImagen():string {
    return this.myForm.get("imagen")?.value;
  }
  ContraseniaId(){
    this.router.navigate(['/cambiarContrasenia',this.id]);
  }

}
