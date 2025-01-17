import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GerenciaveisComponent } from './gerenciaveis.component';

describe('GerenciaveisComponent', () => {
  let component: GerenciaveisComponent;
  let fixture: ComponentFixture<GerenciaveisComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GerenciaveisComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GerenciaveisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
