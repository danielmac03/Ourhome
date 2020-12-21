import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomTestComponent } from './custom-test.component';

describe('custom-testComponent', () => {
  let component: CustomTestComponent;
  let fixture: ComponentFixture<CustomTestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomTestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
