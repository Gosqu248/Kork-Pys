import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HdsFooterComponent } from './hds-footer.component';

describe('HdsFooterComponent', () => {
  let component: HdsFooterComponent;
  let fixture: ComponentFixture<HdsFooterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HdsFooterComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HdsFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
