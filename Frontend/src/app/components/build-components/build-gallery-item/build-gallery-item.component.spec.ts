import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuildGalleryItemComponent } from './build-gallery-item.component';

describe('BuildGalleryItemComponent', () => {
  let component: BuildGalleryItemComponent;
  let fixture: ComponentFixture<BuildGalleryItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BuildGalleryItemComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BuildGalleryItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
