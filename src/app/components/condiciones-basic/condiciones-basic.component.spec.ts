import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CondicionesBasicComponent } from './condiciones-basic.component';

describe('CondicionesBasicComponent', () => {
  let component: CondicionesBasicComponent;
  let fixture: ComponentFixture<CondicionesBasicComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CondicionesBasicComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CondicionesBasicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
