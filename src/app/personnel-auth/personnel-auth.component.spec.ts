import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonnelAuthComponent } from './personnel-auth.component';

describe('PersonnelAuthComponent', () => {
  let component: PersonnelAuthComponent;
  let fixture: ComponentFixture<PersonnelAuthComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PersonnelAuthComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonnelAuthComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
