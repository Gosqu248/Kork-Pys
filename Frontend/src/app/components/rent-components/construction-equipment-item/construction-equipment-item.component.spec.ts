import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConstructionEquipmentItemComponent } from './construction-equipment-item.component';

describe('ConstructionEquipmentItemComponent', () => {
  let component: ConstructionEquipmentItemComponent;
  let fixture: ComponentFixture<ConstructionEquipmentItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConstructionEquipmentItemComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConstructionEquipmentItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
