import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Inversor2Component } from './inversor2.component';

describe('Inversor2Component', () => {
  let component: Inversor2Component;
  let fixture: ComponentFixture<Inversor2Component>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [Inversor2Component]
    });
    fixture = TestBed.createComponent(Inversor2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
