import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-condiciones-empresa',
  templateUrl: './condiciones-empresa.component.html',
  styleUrls: ['./condiciones-empresa.component.css']
})
export class CondicionesEmpresaComponent implements OnInit {

  usuario!: string;

  constructor(
    private router: Router,
    private activatedRouter: ActivatedRoute
  ) { }

  ngOnInit(): void {
  }

  link(){
    let usuario = this.activatedRouter.snapshot.params['usuario'];
    this.router.navigate(['/pagoPlan', usuario])
  }
}
