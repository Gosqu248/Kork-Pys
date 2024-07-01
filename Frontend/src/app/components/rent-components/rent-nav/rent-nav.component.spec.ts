import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RentNavComponent } from './rent-nav.component';

describe('RentNavComponent', () => {
  let component: RentNavComponent;
  let fixture: ComponentFixture<RentNavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RentNavComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RentNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
