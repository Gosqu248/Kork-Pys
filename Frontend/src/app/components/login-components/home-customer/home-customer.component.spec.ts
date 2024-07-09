import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeCustomerComponent } from './home-customer.component';

describe('HomeUserComponent', () => {
  let component: HomeCustomerComponent;
  let fixture: ComponentFixture<HomeCustomerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HomeCustomerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomeCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
