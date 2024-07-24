import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeResetPasswordComponent } from './home-reset-password.component';

describe('HomeResetPasswordComponent', () => {
  let component: HomeResetPasswordComponent;
  let fixture: ComponentFixture<HomeResetPasswordComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HomeResetPasswordComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomeResetPasswordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
