import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeEmpresaComponent } from './home-empresa.component';

describe('HomeEmpresaComponent', () => {
  let component: HomeEmpresaComponent;
  let fixture: ComponentFixture<HomeEmpresaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeEmpresaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomeEmpresaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
