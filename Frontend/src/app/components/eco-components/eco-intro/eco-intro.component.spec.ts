import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EcoIntroComponent } from './eco-intro.component';

describe('EcoIntroComponent', () => {
  let component: EcoIntroComponent;
  let fixture: ComponentFixture<EcoIntroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EcoIntroComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EcoIntroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
