import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuildMainComponent } from './build-main.component';

describe('BuildMainComponent', () => {
  let component: BuildMainComponent;
  let fixture: ComponentFixture<BuildMainComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BuildMainComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BuildMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
