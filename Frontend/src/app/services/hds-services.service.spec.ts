import { TestBed } from '@angular/core/testing';

import { HdsServicesService } from './hds-services.service';

describe('HdsServicesService', () => {
  let service: HdsServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HdsServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
