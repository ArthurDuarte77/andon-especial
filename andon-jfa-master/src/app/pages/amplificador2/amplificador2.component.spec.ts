import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Amplificador2Component } from './amplificador2.component';

describe('Amplificador2Component', () => {
  let component: Amplificador2Component;
  let fixture: ComponentFixture<Amplificador2Component>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [Amplificador2Component]
    });
    fixture = TestBed.createComponent(Amplificador2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
