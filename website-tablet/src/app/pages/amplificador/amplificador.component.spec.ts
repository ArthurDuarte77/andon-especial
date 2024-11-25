import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AmplificadorComponent } from './amplificador.component';

describe('AmplificadorComponent', () => {
  let component: AmplificadorComponent;
  let fixture: ComponentFixture<AmplificadorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AmplificadorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AmplificadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
