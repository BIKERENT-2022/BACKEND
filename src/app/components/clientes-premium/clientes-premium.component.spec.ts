import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientesPremiumComponent } from './clientes-premium.component';

describe('ClientesPremiumComponent', () => {
  let component: ClientesPremiumComponent;
  let fixture: ComponentFixture<ClientesPremiumComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientesPremiumComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClientesPremiumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
