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
    this.router.navigate(['service-info']);
  }

}
