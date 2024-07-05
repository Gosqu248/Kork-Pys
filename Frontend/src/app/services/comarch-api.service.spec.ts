import { TestBed } from '@angular/core/testing';

import { ComarchApiService } from './comarch-api.service';

describe('ComarchApiService', () => {
  let service: ComarchApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ComarchApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
