import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HdsGalleryItemComponent } from './hds-gallery-item.component';

describe('HdsGalleryItemComponent', () => {
  let component: HdsGalleryItemComponent;
  let fixture: ComponentFixture<HdsGalleryItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HdsGalleryItemComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HdsGalleryItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
