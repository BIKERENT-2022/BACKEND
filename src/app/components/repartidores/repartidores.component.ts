import { RepartidorService } from './../../services/repartidor.service';
import { Repartidor } from './../../models/Repartidor';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';

@Component({
  selector: 'app-repartidores',
  templateUrl: './repartidores.component.html',
  styleUrls: ['./repartidores.component.css']
})
export class RepartidoresComponent implements OnInit {

  displayedColumns: string[] = ["id", "nombre", "apellido", "dni", "celular", "correo"];
  dataSource = new MatTableDataSource<Repartidor>();
  repartidor!: Repartidor[];

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  
  constructor(private RepartidorService:RepartidorService) { }

  ngOnInit(): void {
    this.getRepartidor();
  }

  getRepartidor(): void{
    this.RepartidorService.getRepartidor().subscribe(
      (data:Repartidor[])=>{
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    })
  }





  deleteRepartidor(id: Number){
    this.RepartidorService.deleteRepartidor(id).subscribe(()=>{
      this.dataSource.data = this.dataSource.data.filter((r:Repartidor)=>{
        return r.id !== id?r:false;
      })
    })
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }


  exportExcel() {
    this.RepartidorService.exportCliente().subscribe({
        next: (data: any) => {
          let file = new Blob([data], {
            type:"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
          });
          let fileURL = URL.createObjectURL(file);
          var anchor = document.createElement('a');
          anchor.download="repartidores_reporte.xlsx";
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
