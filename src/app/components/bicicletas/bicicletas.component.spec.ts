import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BicicletasComponent } from './bicicletas.component';

describe('BicicletasComponent', () => {
  let component: BicicletasComponent;
  let fixture: ComponentFixture<BicicletasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BicicletasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BicicletasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
