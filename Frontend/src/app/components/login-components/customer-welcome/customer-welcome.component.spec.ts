import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerWelcomeComponent } from './customer-welcome.component';

describe('CustomerWelcomeComponent', () => {
  let component: CustomerWelcomeComponent;
  let fixture: ComponentFixture<CustomerWelcomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CustomerWelcomeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerWelcomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
