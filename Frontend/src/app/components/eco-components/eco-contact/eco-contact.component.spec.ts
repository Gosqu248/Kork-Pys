import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EcoContactComponent } from './eco-contact.component';

describe('EcoContactComponent', () => {
  let component: EcoContactComponent;
  let fixture: ComponentFixture<EcoContactComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EcoContactComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EcoContactComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
