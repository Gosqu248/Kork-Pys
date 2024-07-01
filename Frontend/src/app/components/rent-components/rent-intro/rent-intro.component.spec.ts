import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RentIntroComponent } from './rent-intro.component';

describe('RentIntroComponent', () => {
  let component: RentIntroComponent;
  let fixture: ComponentFixture<RentIntroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RentIntroComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RentIntroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
