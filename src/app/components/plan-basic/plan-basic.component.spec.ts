import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanBasicComponent } from './plan-basic.component';

describe('PlanBasicComponent', () => {
  let component: PlanBasicComponent;
  let fixture: ComponentFixture<PlanBasicComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlanBasicComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PlanBasicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
