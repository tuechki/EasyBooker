import { Component, OnInit } from '@angular/core';
import {BusinessInfoService} from "../services/business.info.service";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../auth/auth.service";

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.scss']
})
export class BookingComponent implements OnInit {

  business: any;
  location: any;
  service: any;

  constructor(private httpClient: HttpClient, private router: Router,
              public authService: AuthService, public businessInfoService: BusinessInfoService) { }

  ngOnInit() {

    this.httpClient.get('http://localhost:8080/businesses/'
      + this.businessInfoService.getCurrentBusiness()['id'],
      {observe: 'response'}
    ).subscribe(resp => {
      this.business = resp.body;
    });

    this.httpClient.get('http://localhost:8080/locations/'
      + this.businessInfoService.getCurrentLocation()['id'],
      {observe: 'response'}
    ).subscribe(resp => {
      this.location = resp.body;
    });


    this.httpClient.get('http://localhost:8080/services/'
      + this.businessInfoService.getCurrentService()['id'],
      {observe: 'response'}
    ).subscribe(resp => {
      this.service = resp.body;
    });



  }

  confirmBooking(){
    this.router.navigate(['my-bookings']);
  }

}
