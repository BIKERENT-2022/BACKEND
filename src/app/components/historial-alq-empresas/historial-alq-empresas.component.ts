import { MatTableDataSource } from '@angular/material/table';
import { RepartidorService } from './../../services/repartidor.service';
import { Repartidor } from './../../models/Repartidor';
import { MatPaginator } from '@angular/material/paginator';
import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-historial-alq-empresas',
  templateUrl: './historial-alq-empresas.component.html',
  styleUrls: ['./historial-alq-empresas.component.css']
})
export class HistorialAlqEmpresasComponent implements OnInit {

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

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
