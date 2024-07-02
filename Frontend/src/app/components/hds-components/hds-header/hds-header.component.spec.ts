import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HdsHeaderComponent } from './hds-header.component';

describe('HdsHeaderComponent', () => {
  let component: HdsHeaderComponent;
  let fixture: ComponentFixture<HdsHeaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HdsHeaderComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HdsHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
