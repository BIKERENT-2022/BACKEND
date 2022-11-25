import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RepartidoresEditarComponent } from './repartidores-editar.component';

describe('RepartidoresEditarComponent', () => {
  let component: RepartidoresEditarComponent;
  let fixture: ComponentFixture<RepartidoresEditarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RepartidoresEditarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RepartidoresEditarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
