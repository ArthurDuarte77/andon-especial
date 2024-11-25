import { TestBed } from '@angular/core/testing';

import { RelatorioAmplificador2Service } from './relatorio.service';

describe('RelatorioAmplificador2Service', () => {
  let service: RelatorioAmplificador2Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RelatorioAmplificador2Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
