import { Component, OnInit } from '@angular/core';
import {BusinessInfoService} from "../services/business.info.service";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../auth/auth.service";
import {ApiService} from "../services/api.service";

@Component({
  selector: 'app-my-bookings',
  templateUrl: './my-bookings.component.html',
  styleUrls: ['./my-bookings.component.scss']
})
export class MyBookingsComponent implements OnInit {

  bookings: any;
  business: object =  {
    id: '',
    name: ''
  };
  location: object =  {
    id: '',
    address: ''
  };
  service: object =  {
    id: '',
    name: ''
  };

  constructor(private httpClient: HttpClient, private router: Router,
              public authService: AuthService, public businessInfoService: BusinessInfoService,
              public apiService: ApiService) { }

  ngOnInit() {

    this.httpClient.get(this.apiService.getAPI() + '/bookings/',
      {observe: 'response'}
    ).subscribe(resp => {
      this.bookings = resp.body;
    });
  }

  showBusiness(booking){
    this.business['id'] = booking.businessId;
    this.business['name'] = booking.businessName;

    this.businessInfoService.setCurrentBusiness(this.business);
    this.router.navigate(['business-info']);
  }

  showLocation(booking){
    this.location['id'] = booking.locationId;
    this.location['address'] = booking.locationAddress;

    this.businessInfoService.setCurrentLocation(this.location);
    this.router.navigate(['location-info']);
  }

  showService(booking){
    this.service['id'] = booking.serviceId;
    this.service['name'] = booking.serviceName;

    this.businessInfoService.setCurrentService(this.service);
    this.router.navigate(['service-info']);
  }

}
