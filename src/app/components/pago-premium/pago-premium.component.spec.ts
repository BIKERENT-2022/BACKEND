import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PagoPremiumComponent } from './pago-premium.component';

describe('PagoPremiumComponent', () => {
  let component: PagoPremiumComponent;
  let fixture: ComponentFixture<PagoPremiumComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PagoPremiumComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PagoPremiumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
