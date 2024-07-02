import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EcoHeaderComponent } from './eco-header.component';

describe('EcoHeaderComponent', () => {
  let component: EcoHeaderComponent;
  let fixture: ComponentFixture<EcoHeaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EcoHeaderComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EcoHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
