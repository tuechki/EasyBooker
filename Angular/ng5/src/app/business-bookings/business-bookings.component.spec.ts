import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BusinessBookingsComponent } from './business-bookings.component';

describe('BusinessBookingsComponent', () => {
  let component: BusinessBookingsComponent;
  let fixture: ComponentFixture<BusinessBookingsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BusinessBookingsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BusinessBookingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
