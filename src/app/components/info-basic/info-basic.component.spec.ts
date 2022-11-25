import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoBasicComponent } from './info-basic.component';

describe('InfoBasicComponent', () => {
  let component: InfoBasicComponent;
  let fixture: ComponentFixture<InfoBasicComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfoBasicComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfoBasicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
