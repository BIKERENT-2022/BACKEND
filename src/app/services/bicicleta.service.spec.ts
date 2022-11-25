import { TestBed } from '@angular/core/testing';

import { BicicletaService } from './bicicleta.service';

describe('BicicletaService', () => {
  let service: BicicletaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BicicletaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
