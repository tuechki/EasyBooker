import { Component, OnInit } from '@angular/core';
import {BusinessInfoService} from "../services/business.info.service";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../auth/auth.service";

@Component({
  selector: 'app-service-info',
  templateUrl: './service-info.component.html',
  styleUrls: ['./service-info.component.scss']
})
export class ServiceInfoComponent implements OnInit {


  service: any;
  locations: any;
  canBook: boolean;

  constructor(private httpClient: HttpClient, private router: Router,
              public authService: AuthService, public businessInfoService: BusinessInfoService) { }

  ngOnInit() {

    this.httpClient.get('http://localhost:8080/services/'
      + this.businessInfoService.getCurrentService()['id'],
      {observe: 'response'}
    ).subscribe(resp => {
      this.service = resp.body;
    });

    this.httpClient.get('http://localhost:8080/services/'
      + this.businessInfoService.getCurrentService()['id'] + "/locations",
      {observe: 'response'}
    ).subscribe(resp => {
      this.locations = resp.body;
    });

    if(this.businessInfoService.getCurrentLocation() != null){
      this.canBook = true;
      console.log(this.canBook);
    }

  }

  goToBusiness(){
    this.httpClient.get('http://localhost:8080/services/'
      + this.businessInfoService.getCurrentService()['id'] + "/business",
      {observe: 'response'}
    ).subscribe(resp => {
      this.businessInfoService.setCurrentBusiness(resp.body);
      this.router.navigate(['business-info']);
    });

  }

  showLocation(location){
    this.businessInfoService.setCurrentLocation(location);
    this.businessInfoService.setBookingService(this.businessInfoService.getBookingService());
    this.router.navigate(['location-info']);
  }

}
