import { Component, OnInit } from '@angular/core';
import {BusinessInfoService} from "../services/business.info.service";
import {AuthService} from "../auth/auth.service";
import {HttpClient} from "@angular/common/http";
import {ApiService} from "../services/api.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-location-bookings',
  templateUrl: './location-bookings.component.html',
  styleUrls: ['./location-bookings.component.scss']
})
export class LocationBookingsComponent implements OnInit {

  bookings: any;
  user: object =  {
    id: '',
    firstName: '',
    lastName: ''
  };
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

    this.httpClient.get(this.apiService.getAPI() + '/locations/' +
      this.businessInfoService.getCurrentLocation()['id'] + '/bookings',
      {observe: 'response'}
    ).subscribe(resp => {
      this.bookings = resp.body;
    });
  }

  // showUser(booking){
  //   this.user['id'] = booking.businessId;
  //   this.user['name'] = booking.businessName;
  //
  //   this.businessInfoService.setCurrentBusiness(this.business);
  //   this.router.navigate(['business-info']);
  // }

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
