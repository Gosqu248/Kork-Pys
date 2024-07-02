import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuildHeaderComponent } from './build-header.component';

describe('BuildHeaderComponent', () => {
  let component: BuildHeaderComponent;
  let fixture: ComponentFixture<BuildHeaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BuildHeaderComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BuildHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
