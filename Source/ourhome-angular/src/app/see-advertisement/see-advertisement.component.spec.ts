import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeeAdvertisementComponent } from './see-advertisement.component';

describe('see-advertisementComponent', () => {
  let component: SeeAdvertisementComponent;
  let fixture: ComponentFixture<SeeAdvertisementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeeAdvertisementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SeeAdvertisementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
