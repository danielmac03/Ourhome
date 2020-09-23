import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CuestionarioInicialComponent } from './cuestionario-inicial.component';

describe('CuestionarioInicialComponent', () => {
  let component: CuestionarioInicialComponent;
  let fixture: ComponentFixture<CuestionarioInicialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CuestionarioInicialComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CuestionarioInicialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
