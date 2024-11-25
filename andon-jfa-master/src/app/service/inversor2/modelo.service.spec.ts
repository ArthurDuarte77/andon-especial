import { TestBed } from '@angular/core/testing';

import { ModeloInversor2Service } from './modelo.service';

describe('ModeloInversor2Service', () => {
  let service: ModeloInversor2Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ModeloInversor2Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
