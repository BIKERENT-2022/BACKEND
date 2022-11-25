import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerPerfilComponent } from './ver-perfil.component';

describe('VerPerfilComponent', () => {
  let component: VerPerfilComponent;
  let fixture: ComponentFixture<VerPerfilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VerPerfilComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VerPerfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
