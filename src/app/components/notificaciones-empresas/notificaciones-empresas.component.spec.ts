import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NotificacionesEmpresasComponent } from './notificaciones-empresas.component';

describe('NotificacionesEmpresasComponent', () => {
  let component: NotificacionesEmpresasComponent;
  let fixture: ComponentFixture<NotificacionesEmpresasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NotificacionesEmpresasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NotificacionesEmpresasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
