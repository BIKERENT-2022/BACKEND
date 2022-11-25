import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AceptarSolicitudComponent } from './aceptar-solicitud.component';

describe('AceptarSolicitudComponent', () => {
  let component: AceptarSolicitudComponent;
  let fixture: ComponentFixture<AceptarSolicitudComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AceptarSolicitudComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AceptarSolicitudComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
