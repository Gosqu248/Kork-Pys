import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HdsItemImageComponent } from './hds-item-image.component';

describe('HdsItemImageComponent', () => {
  let component: HdsItemImageComponent;
  let fixture: ComponentFixture<HdsItemImageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HdsItemImageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HdsItemImageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
