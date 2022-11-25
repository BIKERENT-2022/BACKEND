import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  idCliente!: any;

  constructor(
    private router:Router,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.idCliente = this.route.snapshot.params['idCliente'];
  }

  home(){
    this.router.navigate(['/home',this.idCliente]);
  }
  notificaciones(){
    this.router.navigate(['/notificaciones',this.idCliente]);
  }
  bicicletas(){
    this.router.navigate(['/Bicicletas',this.idCliente]);
  }
  historial(){
    this.router.navigate(['/historial',this.idCliente]);
  }
  perfil(){
    this.router.navigate(['/verPerfil',this.idCliente]);
  }
}
