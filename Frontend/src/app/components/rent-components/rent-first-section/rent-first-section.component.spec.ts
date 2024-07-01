import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RentFirstSectionComponent } from './rent-first-section.component';

describe('RentFirstSectionComponent', () => {
  let component: RentFirstSectionComponent;
  let fixture: ComponentFixture<RentFirstSectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RentFirstSectionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RentFirstSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
