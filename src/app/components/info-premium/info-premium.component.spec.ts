import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoPremiumComponent } from './info-premium.component';

describe('InfoPremiumComponent', () => {
  let component: InfoPremiumComponent;
  let fixture: ComponentFixture<InfoPremiumComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfoPremiumComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfoPremiumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
