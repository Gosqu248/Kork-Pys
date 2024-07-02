import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EcoServicesComponent } from './eco-services.component';

describe('EcoServicesComponent', () => {
  let component: EcoServicesComponent;
  let fixture: ComponentFixture<EcoServicesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EcoServicesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EcoServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
