import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RentSecondSectionComponent } from './rent-second-section.component';

describe('RentSecondSectionComponent', () => {
  let component: RentSecondSectionComponent;
  let fixture: ComponentFixture<RentSecondSectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RentSecondSectionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RentSecondSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
