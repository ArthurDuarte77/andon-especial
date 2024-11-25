import { TestBed } from '@angular/core/testing';

import { MainAmplificador1Service } from './main.service';

describe('MainAmplificador1Service', () => {
  let service: MainAmplificador1Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MainAmplificador1Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
