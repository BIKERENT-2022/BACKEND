import { Empresa } from './../../models/Empresa';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EmpresaService } from 'src/app/services/empresa.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-perfil-empresas',
  templateUrl: './perfil-empresas.component.html',
  styleUrls: ['./perfil-empresas.component.css']
})
export class PerfilEmpresasComponent implements OnInit {

  myForm!: FormGroup;
  id!: number;
  datosEmpresa!: Empresa;

  constructor(private formBuilder:FormBuilder,
    private empresaService: EmpresaService,
    private router: Router,
    private activatedRouter: ActivatedRoute) { }
    
  ngOnInit(): void {
    this.reactiveForm();

  }

  reactiveForm() {
    this.myForm = this.formBuilder.group({
      id:[""],
      ruc:["", [Validators.required]],
      nombre:["", [Validators.required]],
      correo:["", [Validators.required, Validators.email]],
      direccion:["", [Validators.required]],
      telefono:["", [Validators.required]],
      imagen:["", [Validators.required]]
    })

    this.id = this.activatedRouter.snapshot.params["idEmpresa"];

    if((this.id!=undefined && this.id!=0)) {

      this.empresaService.getOneEmpresa(this.id).subscribe(
        (data: Empresa) => {
          this.datosEmpresa = data;

          this.myForm = this.formBuilder.group({            
            ruc: [this.datosEmpresa.ruc,[Validators.required]],
            nombre: [this.datosEmpresa.nombre,[Validators.required]],
            correo: [this.datosEmpresa.correo,[Validators.required, Validators.email]],
            direccion: [this.datosEmpresa.direccion,[Validators.required]],
            telefono: [this.datosEmpresa.telefono,[Validators.required]],
            imagen: [this.datosEmpresa.imagen,[Validators.required]],
          })
        }
      )

    }
    else {
      this.id = 0;
    }
  }

  saveEmpresa(): void{
    const empresa:Empresa = {
      id:this.id,
      ruc:this.myForm.get("ruc")?.value, 
      nombre:this.myForm.get("nombre")?.value, 
      correo:this.myForm.get("correo")?.value, 
      direccion:this.myForm.get("direccion")?.value, 
      telefono:this.myForm.get("telefono")?.value, 
      imagen:this.myForm.get("imagen")?.value
    }
    this.empresaService.updateEmpresa(this.id, empresa).subscribe({
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
