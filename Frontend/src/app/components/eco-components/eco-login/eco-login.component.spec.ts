import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EcoLoginComponent } from './eco-login.component';

describe('EcoLoginComponent', () => {
  let component: EcoLoginComponent;
  let fixture: ComponentFixture<EcoLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EcoLoginComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EcoLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
