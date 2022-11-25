import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmarInformacionComponent } from './confirmar-informacion.component';

describe('ConfirmarInformacionComponent', () => {
  let component: ConfirmarInformacionComponent;
  let fixture: ComponentFixture<ConfirmarInformacionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConfirmarInformacionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConfirmarInformacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
