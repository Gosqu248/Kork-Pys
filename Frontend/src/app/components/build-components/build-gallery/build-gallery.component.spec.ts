import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuildGalleryComponent } from './build-gallery.component';

describe('BuildGalleryComponent', () => {
  let component: BuildGalleryComponent;
  let fixture: ComponentFixture<BuildGalleryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BuildGalleryComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BuildGalleryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
