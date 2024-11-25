import { TestBed } from '@angular/core/testing';

import { MainControleService } from './main.service';

describe('MainControleService', () => {
  let service: MainControleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MainControleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
