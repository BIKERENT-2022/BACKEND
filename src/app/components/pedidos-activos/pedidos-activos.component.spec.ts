import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PedidosActivosComponent } from './pedidos-activos.component';

describe('PedidosActivosComponent', () => {
  let component: PedidosActivosComponent;
  let fixture: ComponentFixture<PedidosActivosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PedidosActivosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PedidosActivosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
