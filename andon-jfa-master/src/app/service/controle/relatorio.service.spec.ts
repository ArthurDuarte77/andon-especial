import { TestBed } from '@angular/core/testing';

import { RelatorioControleService } from './relatorio.service';

describe('RelatorioControleService', () => {
  let service: RelatorioControleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RelatorioControleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
