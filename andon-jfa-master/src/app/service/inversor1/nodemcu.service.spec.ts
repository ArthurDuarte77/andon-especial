import { TestBed } from '@angular/core/testing';

import { NodemcuInversor1Service } from './nodemcu.service';

describe('NodemcuInversor1Service', () => {
  let service: NodemcuInversor1Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NodemcuInversor1Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
