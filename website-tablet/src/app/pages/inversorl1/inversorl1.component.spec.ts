import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Inversorl1Component } from './inversorl1.component';

describe('Inversorl1Component', () => {
  let component: Inversorl1Component;
  let fixture: ComponentFixture<Inversorl1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Inversorl1Component ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Inversorl1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
