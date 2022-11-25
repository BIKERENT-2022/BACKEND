import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RepartidoresAgregarComponent } from './repartidores-agregar.component';

describe('RepartidoresAgregarComponent', () => {
  let component: RepartidoresAgregarComponent;
  let fixture: ComponentFixture<RepartidoresAgregarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RepartidoresAgregarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RepartidoresAgregarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
