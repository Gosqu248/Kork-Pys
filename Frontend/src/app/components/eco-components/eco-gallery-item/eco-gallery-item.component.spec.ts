import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EcoGalleryItemComponent } from './eco-gallery-item.component';

describe('EcoGalleryItemComponent', () => {
  let component: EcoGalleryItemComponent;
  let fixture: ComponentFixture<EcoGalleryItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EcoGalleryItemComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EcoGalleryItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
