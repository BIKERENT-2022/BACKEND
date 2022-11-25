import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistorialAlqEmpresasComponent } from './historial-alq-empresas.component';

describe('HistorialAlqEmpresasComponent', () => {
  let component: HistorialAlqEmpresasComponent;
  let fixture: ComponentFixture<HistorialAlqEmpresasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HistorialAlqEmpresasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HistorialAlqEmpresasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
