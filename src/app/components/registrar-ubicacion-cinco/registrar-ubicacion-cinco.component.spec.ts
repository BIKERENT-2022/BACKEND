import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarUbicacionCincoComponent } from './registrar-ubicacion-cinco.component';

describe('RegistrarUbicacionCincoComponent', () => {
  let component: RegistrarUbicacionCincoComponent;
  let fixture: ComponentFixture<RegistrarUbicacionCincoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistrarUbicacionCincoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistrarUbicacionCincoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
