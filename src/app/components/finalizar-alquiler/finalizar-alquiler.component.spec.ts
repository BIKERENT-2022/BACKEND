import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FinalizarAlquilerComponent } from './finalizar-alquiler.component';

describe('FinalizarAlquilerComponent', () => {
  let component: FinalizarAlquilerComponent;
  let fixture: ComponentFixture<FinalizarAlquilerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FinalizarAlquilerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FinalizarAlquilerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
