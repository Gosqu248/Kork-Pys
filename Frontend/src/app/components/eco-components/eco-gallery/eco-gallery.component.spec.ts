import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EcoGalleryComponent } from './eco-gallery.component';

describe('EcoGalleryComponent', () => {
  let component: EcoGalleryComponent;
  let fixture: ComponentFixture<EcoGalleryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EcoGalleryComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EcoGalleryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
