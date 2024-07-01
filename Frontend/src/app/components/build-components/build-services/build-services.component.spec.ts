import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuildServicesComponent } from './build-services.component';

describe('BuildServicesComponent', () => {
  let component: BuildServicesComponent;
  let fixture: ComponentFixture<BuildServicesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BuildServicesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BuildServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
