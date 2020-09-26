import { TestBed } from '@angular/core/testing';

import { TestPersonalizadosService } from './test-personalizados.service';

describe('TestPersonalizadosService', () => {
  let service: TestPersonalizadosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TestPersonalizadosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
