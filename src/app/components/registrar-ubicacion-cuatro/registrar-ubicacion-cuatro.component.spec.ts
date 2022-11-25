import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarUbicacionCuatroComponent } from './registrar-ubicacion-cuatro.component';

describe('RegistrarUbicacionCuatroComponent', () => {
  let component: RegistrarUbicacionCuatroComponent;
  let fixture: ComponentFixture<RegistrarUbicacionCuatroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistrarUbicacionCuatroComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistrarUbicacionCuatroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
