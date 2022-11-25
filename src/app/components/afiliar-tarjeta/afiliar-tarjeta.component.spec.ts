import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AfiliarTarjetaComponent } from './afiliar-tarjeta.component';

describe('AfiliarTarjetaComponent', () => {
  let component: AfiliarTarjetaComponent;
  let fixture: ComponentFixture<AfiliarTarjetaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AfiliarTarjetaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AfiliarTarjetaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
