import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Inversor1Component } from './inversor1.component';

describe('Inversor1Component', () => {
  let component: Inversor1Component;
  let fixture: ComponentFixture<Inversor1Component>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [Inversor1Component]
    });
    fixture = TestBed.createComponent(Inversor1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
