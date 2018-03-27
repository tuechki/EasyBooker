import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BusinessInfoService} from "../services/business.info.service";
import {AuthService} from "../auth/auth.service";
import {Router} from "@angular/router";
import {error} from "util";

@Component({
  selector: 'app-location-info',
  templateUrl: './location-info.component.html',
  styleUrls: ['./location-info.component.scss']
})
export class LocationInfoComponent implements OnInit {

  location: any;
  services: any;
  canBook: boolean;

  constructor(private httpClient: HttpClient, private router: Router,
              public authService: AuthService, public businessInfoService: BusinessInfoService) { }

  ngOnInit() {

    this.httpClient.get('http://localhost:8080/locations/'
      + this.businessInfoService.getCurrentLocation()['id'],
      {observe: 'response'}
    ).subscribe(resp => {
      this.location = resp.body;
    });


    this.httpClient.get('http://localhost:8080/locations/'
      + this.businessInfoService.getCurrentLocation()['id'] + "/services",
      {observe: 'response'}
    ).subscribe(resp => {
      this.services = resp.body;
      console.log(resp.body.toString());
      console.log(resp.body);
    });

    if(this.businessInfoService.getCurrentService() != null){
      this.canBook = true;
      console.log(this.canBook);
    }

  }

  goToBusiness(){
    this.httpClient.get('http://localhost:8080/locations/'
      + this.businessInfoService.getCurrentLocation()['id'] + "/business",
      {observe: 'response'}
    ).subscribe(resp => {
      this.businessInfoService.setCurrentBusiness(resp.body);
      this.router.navigate(['business-info']);
    });

  }

  showService(service){
    this.businessInfoService.setCurrentService(service);
    this.businessInfoService.setBookingLocation(this.businessInfoService.getCurrentLocation());
    this.router.navigate(['service-info']);

  }

}
