import { Component, OnInit } from '@angular/core';
import {BusinessInfoService} from "../services/business.info.service";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../auth/auth.service";
import {MatDatepickerInputEvent} from "@angular/material";
import {ApiService} from "../services/api.service";
import {MatTimepickerInputEvent} from "angular5-time-picker/src/timepicker.directive";

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.scss']
})
export class BookingComponent implements OnInit {


  business: any;
  location: any;
  service: any;
  freeHours: any;

  booking: object =  {
    businessId: '',
    locationId: '',
    serviceId: '',
    beginTime: '',
    date:''
  };

  constructor(private httpClient: HttpClient, private router: Router,
              public authService: AuthService, public businessInfoService: BusinessInfoService,
              public apiService: ApiService) { }

  ngOnInit() {

    this.httpClient.get(this.apiService.getAPI() + '/businesses/'
      + this.businessInfoService.getCurrentBusiness()['id'],
      {observe: 'response'}
    ).subscribe(resp => {
      this.business = resp.body;
    });

    this.httpClient.get(this.apiService.getAPI() + '/locations/'
      + this.businessInfoService.getCurrentLocation()['id'],
      {observe: 'response'}
    ).subscribe(resp => {
      this.location = resp.body;
    });


    this.httpClient.get(this.apiService.getAPI() + '/services/'
      + this.businessInfoService.getCurrentService()['id'],
      {observe: 'response'}
    ).subscribe(resp => {
      this.service = resp.body;
    });



  }

  events: string[] = [];

  chooseDate(type: string, event: MatDatepickerInputEvent<Date>) {
    this.events.push(`${type}: ${event.value}`);

    let month = (event.value.getMonth() + 1).toString();
    if(month.length < 2){
      month = '0' + month;
    }

    let day = (event.value.getDate()).toString();
    if(day.length < 2){
      day = '0' + day;
    }

    this.booking['date'] = event.value.getFullYear() + '-'
      +  month + '-'
      + day;

    this.httpClient.get(this.apiService.getAPI() + '/locations/'
      + this.location.id + '/services/' + this.service.id + '/'
      + event.value.getFullYear() + '/'
      + (event.value.getMonth() + 1) + '/'
      + event.value.getDate(),
      {observe: 'response'}
    ).subscribe(resp => {
      this.freeHours = resp.body;
    });
  }

  confirmBooking(freeHour){

    this.booking['businessId'] = this.businessInfoService.getCurrentBusiness()['id'];
    this.booking['locationId'] = this.businessInfoService.getCurrentLocation()['id'];
    this.booking['serviceId'] = this.businessInfoService.getCurrentService()['id'];
    this.booking['beginTime'] = freeHour[0] + ":" + freeHour[1];

    console.log(this.booking);

    this.httpClient.post(this.apiService.getAPI() + '/bookings',
      this.booking,
      {observe: 'response'}
    ).subscribe(resp => {
      this.router.navigate(['my-bookings']);
    });


  }

}
