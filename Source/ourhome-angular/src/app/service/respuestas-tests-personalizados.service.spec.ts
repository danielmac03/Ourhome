import { TestBed } from '@angular/core/testing';

import { RespuestasTestsPersonalizadosService } from './respuestas-tests-personalizados.service';

describe('RespuestasTestsPersonalizadosService', () => {
  let service: RespuestasTestsPersonalizadosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RespuestasTestsPersonalizadosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
