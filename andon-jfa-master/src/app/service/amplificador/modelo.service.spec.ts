import { TestBed } from '@angular/core/testing';

import { ModeloAmplificador1Service } from './modelo.service';

describe('ModeloAmplificador1Service', () => {
  let service: ModeloAmplificador1Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ModeloAmplificador1Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
