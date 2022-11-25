import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PagoPlanComponent } from './pago-plan.component';

describe('PagoPlanComponent', () => {
  let component: PagoPlanComponent;
  let fixture: ComponentFixture<PagoPlanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PagoPlanComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PagoPlanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
