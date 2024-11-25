import { TestBed } from '@angular/core/testing';

import { ModeloAmplificador2Service } from './modelo.service';

describe('ModeloAmplificador2Service', () => {
  let service: ModeloAmplificador2Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ModeloAmplificador2Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
