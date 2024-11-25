import { TestBed } from '@angular/core/testing';

import { RelatoriAmplificador1Service } from './relatorio.service';

describe('RelatoriAmplificador1Service', () => {
  let service: RelatoriAmplificador1Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RelatoriAmplificador1Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
