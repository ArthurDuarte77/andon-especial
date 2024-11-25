import { TestBed } from '@angular/core/testing';

import { MainAmplificador2Service } from './main.service';

describe('MainAmplificador2Service', () => {
  let service: MainAmplificador2Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MainAmplificador2Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
