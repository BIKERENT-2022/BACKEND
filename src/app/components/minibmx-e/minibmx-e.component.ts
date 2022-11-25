import { EmpresaService } from './../../services/empresa.service';
import { Empresa } from './../../models/Empresa';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Bicicleta } from 'src/app/models/Bicicleta';
import { BicicletaService } from 'src/app/services/bicicleta.service';

@Component({
  selector: 'app-minibmx-e',
  templateUrl: './minibmx-e.component.html',
  styleUrls: ['./minibmx-e.component.css']
})
export class MinibmxEComponent implements OnInit {

  myForm!: FormGroup;
  id!: number;
  datosBicicleta!: Bicicleta;
  empresas!: Empresa[];
  idEmpresa!: any;

  constructor(private formBuilder:FormBuilder,
    private bicicletaService: BicicletaService,
    private empresaService: EmpresaService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.reactiveForm();
    this.idEmpresa = this.route.snapshot.params['idEmpresa'];
  }

  reactiveForm() {
    this.myForm = this.formBuilder.group({
      id:[""],
      modelo:["", [Validators.required]],
      marca:["", [Validators.required]],
      color:["", [Validators.required]],
      tipo:["", [Validators.required]],
      imagen:["", [Validators.required]]
    })

    this.id = this.route.snapshot.params["id"];

    if((this.id!=undefined && this.id!=0)) {

      this.bicicletaService.getOneBicicleta(this.id).subscribe(
        (data: Bicicleta) => {
          this.datosBicicleta = data;

          this.myForm = this.formBuilder.group({            
            color: [this.datosBicicleta.color,[Validators.required]],
            modelo: [this.datosBicicleta.modelo,[Validators.required]],
            marca: [this.datosBicicleta.marca,[Validators.required]],
            tipo: [this.datosBicicleta.tipo,[Validators.required]],
            imagen: [this.datosBicicleta.imagen,[Validators.required]],
          })
        }
      )

    }
    else {
      this.id = 0;
    }

    /*this.myForm.get("imagen")!.setValue(this.datosBicicleta.imagen);
    this.myForm.get("id")!.setValue(data.id_empresa.id);
    this.myForm.get("modelo")!.setValue(data.modelo);
    this.myForm.get("marca")!.setValue(data.marca);
    this.myForm.get("color")!.setValue(data.color);
    this.myForm.get("tipo")!.setValue(data.tipo);*/
  }


  saveBicicleta():void{
    const bicicleta:Bicicleta = {
      id:this.id,
      empresa:this.myForm.get("empresa")?.value,
      modelo:this.myForm.get("modelo")?.value,
      marca:this.myForm.get("marca")?.value,
      color:this.myForm.get("color")?.value,
      tipo:this.myForm.get("tipo")?.value,
      imagen:this.myForm.get("imagen")?.value
    }

    if(this.id == 0) { //se agrega
      this.bicicletaService.addBicicleta(bicicleta).subscribe({
        next: (data) => {
          this.router.navigate(["/resmod",this.idEmpresa]);
        },
        error: (err) => {
          console.log(err);
        }
      })
    } else {
      this.bicicletaService.updateBicicleta(this.id ,bicicleta).subscribe({
        next: (data) => {
          this.router.navigate(["/resmod",this.idEmpresa]);
        },
        error: (err) => {
          //this.router.navigate(["/resmod"]);
          console.log(err);
        }
      })
    }
  }

  deleteBicicleta(){
    this.bicicletaService.deleteBicicleta(this.id).subscribe({
      next: (data) => {
        this.router.navigate(["/resmod",this.idEmpresa]);
      },
      error:(err) => {
        console.log(err);
      }
    })
  }

  getImagen(): string {
    return this.myForm.get("imagen")?.value
  }

  getEmpresas():void {
    this.empresaService.getEmpresas().subscribe((data: Empresa[])=>{
      this.empresas=data;
    })
  }

  cancel(){
    this.router.navigate(["/resmod",this.idEmpresa]);
  }
}
