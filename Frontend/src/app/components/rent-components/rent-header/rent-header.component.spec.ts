import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RentHeaderComponent } from './rent-header.component';

describe('RentHeaderComponent', () => {
  let component: RentHeaderComponent;
  let fixture: ComponentFixture<RentHeaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RentHeaderComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RentHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
