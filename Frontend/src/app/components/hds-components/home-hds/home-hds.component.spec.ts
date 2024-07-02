import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeHdsComponent } from './home-hds.component';

describe('HomeHdsComponent', () => {
  let component: HomeHdsComponent;
  let fixture: ComponentFixture<HomeHdsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HomeHdsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomeHdsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
