import { TestBed } from '@angular/core/testing';

import { RelatorioInversor1Service } from './relatorio.service';

describe('RelatorioInversor1Service', () => {
  let service: RelatorioInversor1Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RelatorioInversor1Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
