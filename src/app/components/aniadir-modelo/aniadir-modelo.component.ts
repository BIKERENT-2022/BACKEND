import { EmpresaService } from './../../services/empresa.service';
import { Empresa } from './../../models/Empresa';
import { Bicicleta } from './../../models/Bicicleta';
import { BicicletaService } from './../../services/bicicleta.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-aniadir-modelo',
  templateUrl: './aniadir-modelo.component.html',
  styleUrls: ['./aniadir-modelo.component.css']
})
export class AniadirModeloComponent implements OnInit {

  myForm!: FormGroup;
  id!: number;
  empresa!:Empresa;
  idEmpresa!: any;


  constructor(private formBuilder:FormBuilder,
    private bicicletaService: BicicletaService,
    private empresaService: EmpresaService,
    private router: Router,
    private activatedRouter: ActivatedRoute) { }

  ngOnInit(): void {
    this.reactiveForm();
    this.idEmpresa = this.activatedRouter.snapshot.params['idEmpresa'];
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

    this.id = this.activatedRouter.snapshot.params["id"];

    /* 
    if((this.id!=undefined && this.id!=0)) {
      this.bicicletaService.getOneBicicleta(this.id).subscribe(
        (data: Bicicleta) => {
          this.myForm.get("id")!.setValue(data.id);
          this.myForm.get("id_empresa")!.setValue(data.id_empresa);
          this.myForm.get("modelo")!.setValue(data.modelo);
          this.myForm.get("marca")!.setValue(data.marca);
          this.myForm.get("color")!.setValue(data.color);
          this.myForm.get("tipo")!.setValue(data.tipo);
          this.myForm.get("imagen")!.setValue(data.imagen);
        }
      )
    }
    else {
      this.id = 0;
    }
    */
  }


  saveBicicleta():void{

  //let emp = Empresa;
  //emp.id=this.idEmpresa;

  console.log(this.idEmpresa);

  this.empresaService.getEmpresaById(this.idEmpresa).subscribe((data)=>{
    const bicicleta:Bicicleta = {

      id:0,
      modelo:this.myForm.get("modelo")?.value,
      marca:this.myForm.get("marca")?.value,
      color:this.myForm.get("color")?.value,
      tipo:this.myForm.get("tipo")?.value,
      imagen:this.myForm.get("imagen")?.value,
      empresa:data

    }

    this.bicicletaService.addBicicleta(bicicleta).subscribe({
      next:(data)=>{
        this.router.navigate(["/resmod",this.idEmpresa]);
      }
    })    });


  }

  regresar(){
    this.router.navigate(["/resmod",this.idEmpresa]);
  }


}
