import { TestBed } from '@angular/core/testing';

import { MainInversor1Service } from './main.service';

describe('MainInversor1Service', () => {
  let service: MainInversor1Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MainInversor1Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
