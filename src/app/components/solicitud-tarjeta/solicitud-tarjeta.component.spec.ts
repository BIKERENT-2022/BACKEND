import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SolicitudTarjetaComponent } from './solicitud-tarjeta.component';

describe('SolicitudTarjetaComponent', () => {
  let component: SolicitudTarjetaComponent;
  let fixture: ComponentFixture<SolicitudTarjetaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SolicitudTarjetaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SolicitudTarjetaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
