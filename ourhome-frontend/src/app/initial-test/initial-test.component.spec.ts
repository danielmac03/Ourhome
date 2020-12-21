import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InitialTestComponent } from './initial-test.component';

describe('initial-testComponent', () => {
  let component: InitialTestComponent;
  let fixture: ComponentFixture<InitialTestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InitialTestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InitialTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
