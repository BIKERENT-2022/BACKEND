import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarOModificarComponent } from './registrar-o-modificar.component';

describe('RegistrarOModificarComponent', () => {
  let component: RegistrarOModificarComponent;
  let fixture: ComponentFixture<RegistrarOModificarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistrarOModificarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistrarOModificarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
