import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HdsNavComponent } from './hds-nav.component';

describe('HdsNavComponent', () => {
  let component: HdsNavComponent;
  let fixture: ComponentFixture<HdsNavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HdsNavComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HdsNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
