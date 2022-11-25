import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlquilerEmpresasComponent } from './alquiler-empresas.component';

describe('AlquilerEmpresasComponent', () => {
  let component: AlquilerEmpresasComponent;
  let fixture: ComponentFixture<AlquilerEmpresasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlquilerEmpresasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AlquilerEmpresasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
