import { RepartidorService } from './../../services/repartidor.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Repartidor } from './../../models/Repartidor';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-repartidores-editar',
  templateUrl: './repartidores-editar.component.html',
  styleUrls: ['./repartidores-editar.component.css']
})
export class RepartidoresEditarComponent implements OnInit {

  myForm!: FormGroup;
  Repartidor!: Repartidor;
  idRepartidor!: any;

  constructor(private fb: FormBuilder,
    private RepartidorService: RepartidorService,
    private snackBar: MatSnackBar,
    private router: Router,
    private route: ActivatedRoute,){}

  ngOnInit(): void {
    this.idRepartidor = this.route.snapshot.paramMap.get('id');
    this.RepartidorService.getRepartidorId(this.idRepartidor).subscribe((data)=>{
      this.Repartidor=data;
      this.myForm = this.fb.group({
        nombre: [this.Repartidor.nombre,[Validators.required, Validators.maxLength(60)]],
        apellido:[this.Repartidor.apellido,[Validators.required]],
        dni:[this.Repartidor.dni,[Validators.required]],
        celular:[this.Repartidor.celular,[Validators.required]],
        v:[this.Repartidor.correo,[Validators.required]],
      })
    })
  }
  
  updateRepartidor(){
    const Repartidor: Repartidor = {
      id : 0,
      nombre : this.myForm.get('nombre')!.value,
      apellido : this.myForm.get('apellido')!.value,
      dni : this.myForm.get('dni')!.value,
      celular : this.myForm.get('celular')!.value,
      correo : this.myForm.get('correo')!.value,
    }
    this.RepartidorService.updateRepartidor(this.idRepartidor,Repartidor).subscribe({
      next:(data)=>{
        this.snackBar.open('actualizado correctamente', '',{duration: 3000});
        this.router.navigate(['/repartidores'])
      },
      error: (err)=>{console.log(err)}
    })
  }

}
