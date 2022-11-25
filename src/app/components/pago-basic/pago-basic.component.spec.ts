import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PagoBasicComponent } from './pago-basic.component';

describe('PagoBasicComponent', () => {
  let component: PagoBasicComponent;
  let fixture: ComponentFixture<PagoBasicComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PagoBasicComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PagoBasicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
