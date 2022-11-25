import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpresasPerfilComponent } from './empresas-perfil.component';

describe('EmpresasPerfilComponent', () => {
  let component: EmpresasPerfilComponent;
  let fixture: ComponentFixture<EmpresasPerfilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmpresasPerfilComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmpresasPerfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
