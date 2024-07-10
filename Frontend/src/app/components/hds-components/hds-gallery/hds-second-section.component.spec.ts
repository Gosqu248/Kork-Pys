import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HdsSecondSectionComponent } from './hds-second-section.component';

describe('HdsSecondSectionComponent', () => {
  let component: HdsSecondSectionComponent;
  let fixture: ComponentFixture<HdsSecondSectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HdsSecondSectionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HdsSecondSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
