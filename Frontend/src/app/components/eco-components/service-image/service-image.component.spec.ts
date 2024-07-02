import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceImageComponent } from './service-image.component';

describe('ServiceImageComponent', () => {
  let component: ServiceImageComponent;
  let fixture: ComponentFixture<ServiceImageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ServiceImageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ServiceImageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
