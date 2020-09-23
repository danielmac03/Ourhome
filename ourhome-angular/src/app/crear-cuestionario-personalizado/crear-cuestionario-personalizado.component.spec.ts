import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearCuestionarioPersonalizadoComponent } from './crear-cuestionario-personalizado.component';

describe('CrearCuestionarioPersonalizadoComponent', () => {
  let component: CrearCuestionarioPersonalizadoComponent;
  let fixture: ComponentFixture<CrearCuestionarioPersonalizadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrearCuestionarioPersonalizadoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearCuestionarioPersonalizadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
