import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AniadirModeloComponent } from './aniadir-modelo.component';

describe('AniadirModeloComponent', () => {
  let component: AniadirModeloComponent;
  let fixture: ComponentFixture<AniadirModeloComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AniadirModeloComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AniadirModeloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
