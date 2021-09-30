import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeServComponent } from './liste-serv.component';

describe('ListeServComponent', () => {
  let component: ListeServComponent;
  let fixture: ComponentFixture<ListeServComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeServComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeServComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
