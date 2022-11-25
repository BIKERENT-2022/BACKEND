import { MatPaginator } from '@angular/material/paginator';
import { ClienteService } from './../../services/cliente.service';
import { MatTableDataSource } from '@angular/material/table';
import { Cliente } from './../../models/Cliente';
import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-clientes-premium',
  templateUrl: './clientes-premium.component.html',
  styleUrls: ['./clientes-premium.component.css']
})
export class ClientesPremiumComponent implements OnInit {

  displayedColumns: string[] = ["id","nombre","dni","correo","direccion","telefono"];
  dataSource = new MatTableDataSource<Cliente>();
  cliente: Cliente[] = [];

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  
  constructor(private ClienteService:ClienteService) { }

  ngOnInit(): void {
    this.getListCliente();
  }

  getListCliente(){
    this.ClienteService.getCliente().subscribe(
      (data:Cliente[])=>{
        console.log(data);
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    })
  }




  exportExcel() {
    this.ClienteService.exportCliente().subscribe({
        next: (data: any) => {
          let file = new Blob([data], {
            type:"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
          });
          let fileURL = URL.createObjectURL(file);
          var anchor = document.createElement('a');
          anchor.download="cliente_reporte.xlsx";
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
