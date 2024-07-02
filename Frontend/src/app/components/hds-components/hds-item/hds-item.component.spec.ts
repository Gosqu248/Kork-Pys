import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HdsItemComponent } from './hds-item.component';

describe('HdsItemComponent', () => {
  let component: HdsItemComponent;
  let fixture: ComponentFixture<HdsItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HdsItemComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HdsItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
