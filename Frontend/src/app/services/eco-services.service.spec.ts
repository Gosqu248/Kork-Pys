import { TestBed } from '@angular/core/testing';

import { EcoServicesService } from './eco-services.service';

describe('EcoServicesService', () => {
  let service: EcoServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EcoServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
