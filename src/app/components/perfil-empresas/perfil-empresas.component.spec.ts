import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilEmpresasComponent } from './perfil-empresas.component';

describe('PerfilEmpresasComponent', () => {
  let component: PerfilEmpresasComponent;
  let fixture: ComponentFixture<PerfilEmpresasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PerfilEmpresasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PerfilEmpresasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
