import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BusinessInfoService} from "../services/business.info.service";
import {AuthService} from "../auth/auth.service";
import {Router} from "@angular/router";
import {ApiService} from "../services/api.service";

@Component({
  selector: 'app-business-info',
  templateUrl: './business-info.component.html',
  styleUrls: ['./business-info.component.scss']
})
export class BusinessInfoComponent implements OnInit {

  business: any;
  locations: any;
  services: any;

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

    this.httpClient.get(this.apiService.getAPI() + '/businesses/'
      + this.businessInfoService.getCurrentBusiness()['id'] + "/services",
      {observe: 'response'}
    ).subscribe(resp => {
      this.services = resp.body;
      console.log(resp.body.toString());
      console.log(resp.body);
    });

    this.httpClient.get(this.apiService.getAPI() + '/businesses/'
      + this.businessInfoService.getCurrentBusiness()['id'] + "/locations",
      {observe: 'response'}
    ).subscribe(resp => {
      this.locations = resp.body;
    });

    this.businessInfoService.clearBookingLocation();
    this.businessInfoService.clearBookingService();
  }

  showLocation(location){
    this.businessInfoService.setCurrentLocation(location);
    this.router.navigate(['location-info']);
  }

  showService(service){
    this.businessInfoService.setCurrentService(service);
    this.router.navigate(['service-info']);
  }

}
