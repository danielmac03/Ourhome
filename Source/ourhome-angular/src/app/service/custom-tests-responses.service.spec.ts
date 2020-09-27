import { TestBed } from '@angular/core/testing';

import { CustomTestsResponsesService } from './custom-tests-responses.service';

describe('CustomTestsResponsesService', () => {
  let service: CustomTestsResponsesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomTestsResponsesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
