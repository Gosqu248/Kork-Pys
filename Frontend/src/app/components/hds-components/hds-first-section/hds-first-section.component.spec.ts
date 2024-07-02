import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HdsFirstSectionComponent } from './hds-first-section.component';

describe('HdsFirstSectionComponent', () => {
  let component: HdsFirstSectionComponent;
  let fixture: ComponentFixture<HdsFirstSectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HdsFirstSectionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HdsFirstSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
