import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeBuildComponent } from './home-build.component';

describe('HomeBuildComponent', () => {
  let component: HomeBuildComponent;
  let fixture: ComponentFixture<HomeBuildComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HomeBuildComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomeBuildComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
