import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarEmpresaComponent } from './navbar-empresa.component';

describe('NavbarEmpresaComponent', () => {
  let component: NavbarEmpresaComponent;
  let fixture: ComponentFixture<NavbarEmpresaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavbarEmpresaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NavbarEmpresaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
