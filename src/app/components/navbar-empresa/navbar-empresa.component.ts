import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar-empresa',
  templateUrl: './navbar-empresa.component.html',
  styleUrls: ['./navbar-empresa.component.css']
})
export class NavbarEmpresaComponent implements OnInit {

  idEmpresa!: any;

  constructor(
    private router:Router,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.idEmpresa = this.route.snapshot.params['idEmpresa'];
  }



  home(){
    this.router.navigate(['/Homee',this.idEmpresa]);
  }
  bicicletas(){
    this.router.navigate(['/resmod',this.idEmpresa]);
  }
  clientes(){
    this.router.navigate(['/ClientesPremium',this.idEmpresa]);
  }
  alquileres(){
    this.router.navigate(['/historialEmp',this.idEmpresa]);
  }
  repartidores(){
    this.router.navigate(['/repartidores',this.idEmpresa]);
  }
  perfil(){
    this.router.navigate(['/perfilEmpresas',this.idEmpresa]);
  }
}
