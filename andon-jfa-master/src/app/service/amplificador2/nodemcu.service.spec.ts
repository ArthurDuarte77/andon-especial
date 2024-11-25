import { TestBed } from '@angular/core/testing';

import { NodemcuAmplificador2Service } from './nodemcu.service';

describe('NodemcuAmplificador2Service', () => {
  let service: NodemcuAmplificador2Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NodemcuAmplificador2Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
