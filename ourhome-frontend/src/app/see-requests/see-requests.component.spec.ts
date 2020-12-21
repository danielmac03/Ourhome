import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeeRequestsComponent } from './see-requests.component';

describe('see-requestsComponent', () => {
  let component: SeeRequestsComponent;
  let fixture: ComponentFixture<SeeRequestsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeeRequestsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SeeRequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
