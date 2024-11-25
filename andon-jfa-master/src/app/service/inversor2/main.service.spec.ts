import { TestBed } from '@angular/core/testing';

import { MainInversor2Service } from './main.service';

describe('MainInversor2Service', () => {
  let service: MainInversor2Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MainInversor2Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
