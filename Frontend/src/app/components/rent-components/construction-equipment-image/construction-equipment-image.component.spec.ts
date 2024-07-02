import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConstructionEquipmentImageComponent } from './construction-equipment-image.component';

describe('ConstructionEquipmentImageComponent', () => {
  let component: ConstructionEquipmentImageComponent;
  let fixture: ComponentFixture<ConstructionEquipmentImageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConstructionEquipmentImageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConstructionEquipmentImageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
