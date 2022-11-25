import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilPremiumComponent } from './perfil-premium.component';

describe('PerfilPremiumComponent', () => {
  let component: PerfilPremiumComponent;
  let fixture: ComponentFixture<PerfilPremiumComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PerfilPremiumComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PerfilPremiumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
