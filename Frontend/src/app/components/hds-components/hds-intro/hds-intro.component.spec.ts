import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HdsIntroComponent } from './hds-intro.component';

describe('HdsIntroComponent', () => {
  let component: HdsIntroComponent;
  let fixture: ComponentFixture<HdsIntroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HdsIntroComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HdsIntroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
