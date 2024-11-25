import { TestBed } from '@angular/core/testing';

import { RelatorioInversor2Service } from './relatorio.service';

describe('RelatorioInversor2Service', () => {
  let service: RelatorioInversor2Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RelatorioInversor2Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
