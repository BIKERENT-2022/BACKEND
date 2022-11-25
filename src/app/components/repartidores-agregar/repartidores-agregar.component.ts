import { Repartidor } from './../../models/Repartidor';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { RepartidorService } from './../../services/repartidor.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';


//interface HTMLInputEvent extends Event{
  //target: HTMLInputElement & EventTarget;
//}


@Component({
  selector: 'app-repartidores-agregar',
  templateUrl: './repartidores-agregar.component.html',
  styleUrls: ['./repartidores-agregar.component.css']
})
export class RepartidoresAgregarComponent implements OnInit {

  myForm!:FormGroup;
  //file!:File;
  //photoSelected !: String | ArrayBuffer | null;

  constructor(private fb: FormBuilder,
    private RepartidorService: RepartidorService,
    private snackBar: MatSnackBar,
    private router: Router,
    ) {this.reactiveForm();}

  ngOnInit(): void {
  }

  reactiveForm(){
    this.myForm= this.fb.group({
      id:[''],
      nombre: ['',[Validators.required, Validators.maxLength(60)]],
      apellido:['',[Validators.required]],
      dni:['',[Validators.required]],
      celular:['',[Validators.required]],
      correo:['',[Validators.required]]
    })
  }

  saveRepartidor(){
    const Repartidor: Repartidor={
      id : 0,
      nombre : this.myForm.get('nombre')!.value,
      apellido : this.myForm.get('apellido')!.value,
      dni : this.myForm.get('dni')!.value,
      celular : this.myForm.get('celular')!.value,
      correo : this.myForm.get('correo')!.value
    }

    this.RepartidorService.addRepartidor(Repartidor).subscribe({
      next:(data)=>{
        this.snackBar.open('registrado correctamente', '',{duration: 3000});
        this.router.navigate(['/repartidores'])
      },
      error: (err)=>{console.log(err)}
    })
  }

}
