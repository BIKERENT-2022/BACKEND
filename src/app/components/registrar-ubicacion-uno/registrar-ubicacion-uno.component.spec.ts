import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarUbicacionUnoComponent } from './registrar-ubicacion-uno.component';

describe('RegistrarUbicacionUnoComponent', () => {
  let component: RegistrarUbicacionUnoComponent;
  let fixture: ComponentFixture<RegistrarUbicacionUnoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistrarUbicacionUnoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistrarUbicacionUnoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
