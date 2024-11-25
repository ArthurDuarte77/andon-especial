import { TestBed } from '@angular/core/testing';

import { NodemcuControleService } from './nodemcu.service';

describe('NodemcuControleService', () => {
  let service: NodemcuControleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NodemcuControleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
