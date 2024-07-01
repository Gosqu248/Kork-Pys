import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuildContactComponent } from './build-contact.component';

describe('BuildContactComponent', () => {
  let component: BuildContactComponent;
  let fixture: ComponentFixture<BuildContactComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BuildContactComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BuildContactComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
