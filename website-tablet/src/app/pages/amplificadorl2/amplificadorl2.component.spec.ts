import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Amplificadorl2Component } from './amplificadorl2.component';

describe('Amplificadorl2Component', () => {
  let component: Amplificadorl2Component;
  let fixture: ComponentFixture<Amplificadorl2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Amplificadorl2Component ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Amplificadorl2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
