import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Bicicleta } from 'src/app/models/Bicicleta';
import { BicicletaService } from 'src/app/services/bicicleta.service';

@Component({
  selector: 'app-bicicletas',
  templateUrl: './bicicletas.component.html',
  styleUrls: ['./bicicletas.component.css']
})
export class BicicletasComponent implements OnInit {

  bicicleta: Bicicleta[] = [];
  dataSource = new MatTableDataSource<Bicicleta>();
  displayColumns: string[] = ["img"];
  public MyForm!: FormGroup
  idCliente!: any;

  constructor(private bicicletaService:BicicletaService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getBicicletas();
    this.idCliente = this.route.snapshot.params['idCliente'];
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
    this.router.navigate(["/minibmxx",this.idCliente,id]);
  }
}
