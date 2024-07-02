import { TestBed } from '@angular/core/testing';

import { ConstructionEquipmentService } from './construction-equipment.service';

describe('ConstructionEquipmentService', () => {
  let service: ConstructionEquipmentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConstructionEquipmentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
