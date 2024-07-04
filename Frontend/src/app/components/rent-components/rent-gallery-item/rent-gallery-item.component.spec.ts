import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RentGalleryItemComponent } from './rent-gallery-item.component';

describe('RentGalleryItemComponent', () => {
  let component: RentGalleryItemComponent;
  let fixture: ComponentFixture<RentGalleryItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RentGalleryItemComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RentGalleryItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
