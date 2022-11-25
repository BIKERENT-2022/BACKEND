import { Usuario } from './../../models/Usuario';
import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-condiciones-basic',
  templateUrl: './condiciones-basic.component.html',
  styleUrls: ['./condiciones-basic.component.css']
})
export class CondicionesBasicComponent implements OnInit {

  usuario!: string;

  constructor(private router: Router,
    private activatedRouter: ActivatedRoute) { }

  ngOnInit(): void {
  }

  link(){
    let usuario = this.activatedRouter.snapshot.params['usuario'];
    this.router.navigate(['/pagobasic', usuario])
  }
}
