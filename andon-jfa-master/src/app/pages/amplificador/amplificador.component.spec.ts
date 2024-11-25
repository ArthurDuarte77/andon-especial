import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AmplificadorComponent } from './amplificador.component';

describe('AmplificadorComponent', () => {
  let component: AmplificadorComponent;
  let fixture: ComponentFixture<AmplificadorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AmplificadorComponent]
    });
    fixture = TestBed.createComponent(AmplificadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
