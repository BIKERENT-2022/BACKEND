import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MinibmxEComponent } from './minibmx-e.component';

describe('MinibmxEComponent', () => {
  let component: MinibmxEComponent;
  let fixture: ComponentFixture<MinibmxEComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MinibmxEComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MinibmxEComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
