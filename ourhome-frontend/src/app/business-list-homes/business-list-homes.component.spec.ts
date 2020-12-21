import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusinessListHomesComponent } from './business-list-homes.component';

describe('BusinessListHomesComponent', () => {
  let component: BusinessListHomesComponent;
  let fixture: ComponentFixture<BusinessListHomesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BusinessListHomesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BusinessListHomesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
