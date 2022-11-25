import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlquilerRealizadoComponent } from './alquiler-realizado.component';

describe('AlquilerRealizadoComponent', () => {
  let component: AlquilerRealizadoComponent;
  let fixture: ComponentFixture<AlquilerRealizadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlquilerRealizadoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AlquilerRealizadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
