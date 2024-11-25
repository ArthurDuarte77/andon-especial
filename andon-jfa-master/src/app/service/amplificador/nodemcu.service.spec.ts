import { TestBed } from '@angular/core/testing';

import { NodemcuAmplificador1Service } from './nodemcu.service';

describe('NodemcuAmplificador1Service', () => {
  let service: NodemcuAmplificador1Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NodemcuAmplificador1Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
