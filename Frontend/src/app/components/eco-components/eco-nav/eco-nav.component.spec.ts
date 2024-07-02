import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EcoNavComponent } from './eco-nav.component';

describe('EcoNavComponent', () => {
  let component: EcoNavComponent;
  let fixture: ComponentFixture<EcoNavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EcoNavComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EcoNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
