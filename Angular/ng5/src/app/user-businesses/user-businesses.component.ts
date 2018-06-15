import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {BusinessInfoService} from "../services/business.info.service";

import {AuthService} from "../auth/auth.service";
import {HttpClient} from "@angular/common/http";
import {ApiService} from "../services/api.service";

@Component({
  selector: 'app-user-businesses',
  templateUrl: './user-businesses.component.html',
  styleUrls: ['./user-businesses.component.scss']
})
export class UserBusinessesComponent implements OnInit {

  businesses: any;
  locations: any[] = [];
  services: any[] = [];

  locationsPerBusiness: any[] = [];
  servicesPerBusiness: any[] = [];

  businessToBeEdited: boolean;
  locationToBeEdited: boolean;
  serviceToBeEdited: boolean;
  businessBookings: boolean;
  locationBookings: boolean;
  serviceBookings: boolean;
  businessToBeDeleted: boolean;

  image: File = null;

  constructor(
    public authService: AuthService,
    private router: Router,
    private httpClient: HttpClient,
    public businessInfoService: BusinessInfoService,
    public apiService: ApiService
  ) {}


  ngOnInit() {

    this.businessToBeEdited = false;
    this.locationToBeEdited = false;
    this.serviceToBeEdited = false;
    this.businessBookings = false;
    this.locationBookings = false;
    this.serviceBookings = false;
    this.businessToBeDeleted = false;

    this.httpClient.get(this.apiService.getAPI() + '/businesses/loggedInUser', {observe: 'response'})
      .subscribe(resp => {
          this.businesses = resp.body;

          for(var i = 0; i < this.businesses.length; i++){
            this.httpClient.get(this.apiService.getAPI() + '/businesses/' + this.businesses[i].id
                                                                          + '/locations', {observe: 'response'})
              .subscribe(resp => {
                    this.locationsPerBusiness.push(resp.body);

                    for(var counter = 0; counter < this.locationsPerBusiness[0].length; counter++){
                      this.locations.push(this.locationsPerBusiness[0][counter]);

                    }
                    this.locationsPerBusiness = [];
                }
              );


            this.httpClient.get(this.apiService.getAPI() + '/businesses/'  + this.businesses[i].id
              + '/services', {observe: 'response'})
              .subscribe(resp => {
                  this.servicesPerBusiness.push(resp.body);
                  for(var counter = 0; counter < this.servicesPerBusiness[0].length; counter++){
                    this.services.push(this.servicesPerBusiness[0][counter]);
                  }
                  this.servicesPerBusiness = [];
                }
              );

          }



        }
      );

    this.businessInfoService.clearBookingLocation();
    this.businessInfoService.clearBookingService();

  }

  showBusiness(business){
    this.businessInfoService.clearCurrentService();
    this.businessInfoService.clearCurrentLocation();

    this.businessInfoService.setCurrentBusiness(business);
    if(!this.businessToBeEdited && !this.businessBookings){
      this.router.navigate(['business-info']);
    }else if(this.businessBookings) {
      this.router.navigate(['business-bookings']);
    }else if(this.businessToBeDeleted) {
      this.httpClient.delete(this.apiService.getAPI() + '/businesses/'
        + this.businessInfoService.getCurrentBusiness()['id'], {observe: 'response'})
        .subscribe(resp => {
          }
        );
      this.httpClient.delete(this.apiService.getAPI() + '/businesses/'
        + this.businessInfoService.getCurrentBusiness()['id'] + '/services', {observe: 'response'})
        .subscribe(resp => {
          }
        );
      this.httpClient.delete(this.apiService.getAPI() + '/businesses/'
        + this.businessInfoService.getCurrentBusiness()['id'] + '/locations', {observe: 'response'})
        .subscribe(resp => {
          }
        );
    }else {
      this.router.navigate(['edit-business']);
    }
  }

  showLocation(location){
    this.businessInfoService.clearCurrentService();

    this.businessInfoService.setCurrentLocation(location);
    if(!this.locationToBeEdited && !this.locationBookings){
      this.router.navigate(['location-info']);
    }else if(this.locationBookings) {
      this.router.navigate(['location-bookings']);
    }else{
      this.router.navigate(['edit-location']);
    }
  }

  showService(service){
    this.businessInfoService.clearCurrentLocation();

    this.businessInfoService.setCurrentService(service);
    if(!this.serviceToBeEdited && !this.serviceBookings){
      this.router.navigate(['service-info']);
    }else if(this.serviceBookings) {
      this.router.navigate(['service-bookings']);
    }else {
      this.router.navigate(['edit-service']);
    }
  }

  deleteBusiness(){
    this.businessToBeDeleted = true;
  }

  showBusinessBookings(){
    this.businessBookings = true;
  }

  showLocationBookings(){
    this.locationBookings = true;
  }

  showServiceBookings(){
    this.serviceBookings = true;
  }

  editBusiness(){
    this.businessToBeEdited = true;
  }

  editLocation(){
    this.locationToBeEdited = true;
  }

  editService(){
    this.serviceToBeEdited = true;
  }
}
