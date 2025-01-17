import { TestBed } from '@angular/core/testing';

import { ModeloControleService } from './modelo.service';

describe('ModeloControleService', () => {
  let service: ModeloControleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ModeloControleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
