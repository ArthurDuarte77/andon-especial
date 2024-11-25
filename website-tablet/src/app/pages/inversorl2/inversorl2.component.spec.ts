import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Inversorl2Component } from './inversorl2.component';

describe('Inversorl2Component', () => {
  let component: Inversorl2Component;
  let fixture: ComponentFixture<Inversorl2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Inversorl2Component ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Inversorl2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
