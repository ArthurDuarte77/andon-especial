import { TestBed } from '@angular/core/testing';

import { NodemcuInversor2Service } from './nodemcu.service';

describe('NodemcuInversor2Service', () => {
  let service: NodemcuInversor2Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NodemcuInversor2Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
