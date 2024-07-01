import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeEcoComponent } from './home-eco.component';

describe('HomeEcoComponent', () => {
  let component: HomeEcoComponent;
  let fixture: ComponentFixture<HomeEcoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HomeEcoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomeEcoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
