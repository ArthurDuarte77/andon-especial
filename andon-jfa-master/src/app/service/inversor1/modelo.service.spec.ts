import { TestBed } from '@angular/core/testing';

import { ModeloInversor1Service } from './modelo.service';

describe('ModeloInversor1Service', () => {
  let service: ModeloInversor1Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ModeloInversor1Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
