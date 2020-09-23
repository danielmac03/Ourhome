import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CuestionarioPersonalizadoComponent } from './cuestionario-personalizado.component';

describe('CuestionarioPersonalizadoComponent', () => {
  let component: CuestionarioPersonalizadoComponent;
  let fixture: ComponentFixture<CuestionarioPersonalizadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CuestionarioPersonalizadoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CuestionarioPersonalizadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
