import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuildAboutComponent } from './build-about.component';

describe('BuildAboutComponent', () => {
  let component: BuildAboutComponent;
  let fixture: ComponentFixture<BuildAboutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BuildAboutComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BuildAboutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
