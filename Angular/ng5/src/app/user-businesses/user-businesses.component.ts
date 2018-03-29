import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {BusinessInfoService} from "../services/business.info.service";

import {AuthService} from "../auth/auth.service";
import {HttpClient} from "@angular/common/http";

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

  image: File = null;

  constructor(
    public authService: AuthService,
    private router: Router,
    private httpClient: HttpClient,
    public businessInfoService: BusinessInfoService
  ) {}


  ngOnInit() {

    this.httpClient.get('http://localhost:8080/businesses/loggedInUser', {observe: 'response'})
      .subscribe(resp => {
          this.businesses = resp.body;

          for(var i = 0; i < this.businesses.length; i++){
            this.httpClient.get('http://localhost:8080/businesses/' + this.businesses[i].id
                                                                          + '/locations', {observe: 'response'})
              .subscribe(resp => {
                    this.locationsPerBusiness.push(resp.body);

                    for(var counter = 0; counter < this.locationsPerBusiness[0].length; counter++){
                      this.locations.push(this.locationsPerBusiness[0][counter]);

                    }
                    this.locationsPerBusiness = [];
                }
              );


            this.httpClient.get('http://localhost:8080/businesses/'  + this.businesses[i].id
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
    console.log(business);
    this.businessInfoService.setCurrentBusiness(business);
    this.router.navigate(['business-info']);
  }

  showLocation(location){
    this.businessInfoService.setCurrentLocation(location);
    this.router.navigate(['location-info']);
  }

  showService(service){
    this.businessInfoService.setCurrentService(service);
    this.businessInfoService.clearCurrentLocation();
    this.router.navigate(['service-info']);

  }
}
