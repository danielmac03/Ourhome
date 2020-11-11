import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListProcessesComponent } from './list-processes.component';

describe('ProcessesComponent', () => {
  let component: ListProcessesComponent;
  let fixture: ComponentFixture<ListProcessesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListProcessesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListProcessesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
