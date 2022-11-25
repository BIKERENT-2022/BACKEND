import { Router, ActivatedRoute } from '@angular/router';
import { BicicletaService } from './../../services/bicicleta.service';
import { Bicicleta } from './../../models/Bicicleta';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-registrar-o-modificar',
  templateUrl: './registrar-o-modificar.component.html',
  styleUrls: ['./registrar-o-modificar.component.css']
})
export class RegistrarOModificarComponent implements OnInit {

  bicicleta!: Bicicleta[];
  dataSource = new MatTableDataSource<Bicicleta>();
  displayColumns: string[] = ["img"];
  idEmpresa!: any;

  constructor(private bicicletaService:BicicletaService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getBicicletas();
    this.idEmpresa = this.route.snapshot.params['idEmpresa'];
  }

  getBicicletas(): void {
    this.bicicletaService.getBicicletas().subscribe(
      (data: Bicicleta[]) => {
        this.dataSource = new MatTableDataSource(data);        
      }
    );
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  bicicletaEscogida(id: any){
    this.router.navigate(["/minibmx-empresa",this.idEmpresa,id]);
  }

  formularioRegistrar(){
    this.router.navigate(["/añadir-modelo",this.idEmpresa]);
  }


  exportExcel() {
    this.bicicletaService.exportCliente().subscribe({
        next: (data: any) => {
          let file = new Blob([data], {
            type:"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
          });
          let fileURL = URL.createObjectURL(file);
          var anchor = document.createElement('a');
          anchor.download="bicicleta_reporte.xlsx";
          anchor.href=fileURL;
          anchor.click();
        },
        error: (error: any) => {
          console.log("No se pudo exportar");
        }
      }
    );
  }
  
}
