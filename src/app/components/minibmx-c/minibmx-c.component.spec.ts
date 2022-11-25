import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MinibmxCComponent } from './minibmx-c.component';

describe('MinibmxCComponent', () => {
  let component: MinibmxCComponent;
  let fixture: ComponentFixture<MinibmxCComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MinibmxCComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MinibmxCComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
