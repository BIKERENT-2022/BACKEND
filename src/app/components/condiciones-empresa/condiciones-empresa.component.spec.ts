import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CondicionesEmpresaComponent } from './condiciones-empresa.component';

describe('CondicionesEmpresaComponent', () => {
  let component: CondicionesEmpresaComponent;
  let fixture: ComponentFixture<CondicionesEmpresaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CondicionesEmpresaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CondicionesEmpresaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
