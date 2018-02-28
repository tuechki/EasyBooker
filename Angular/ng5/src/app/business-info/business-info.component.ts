import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BusinessInfoService} from "../services/business.info.service";
import {AuthService} from "../auth/auth.service";
import {Router} from "@angular/router";

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
              public authService: AuthService, public businessInfoService: BusinessInfoService) { }

  ngOnInit() {
    this.business = this.businessInfoService.getCurrentBusiness();

    this.httpClient.get('http://localhost:8080/services?businessId='
      + this.businessInfoService.getCurrentBusiness()['id'],
      {observe: 'response'}
    ).subscribe(resp => {
      this.services = resp.body;
      console.log(resp.body.toString());
      console.log(resp.body);
    });

    this.httpClient.get('http://localhost:8080/locations?businessId='
      + this.businessInfoService.getCurrentBusiness()['id'],
      {observe: 'response'}
    ).subscribe(resp => {
      this.locations = resp.body;
    });
  }



}
