import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAccountBusinessComponent } from './create-account-business.component';

describe('RegisterBusinessComponent', () => {
  let component: CreateAccountBusinessComponent;
  let fixture: ComponentFixture<CreateAccountBusinessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateAccountBusinessComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateAccountBusinessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
