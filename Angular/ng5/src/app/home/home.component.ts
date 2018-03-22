import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../auth/auth.service";
import {BusinessInfoService} from "../services/business.info.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  itemCount: number = 4;
  btnText: string = "Add an item";
  goalText: string = "My first goal...";
  goals = ['asdasd', 'anotherThing'];
  businesses: any;
  locations: any;
  services: any;

  image: File = null;

  constructor(private httpClient: HttpClient, private router: Router,
              public authService: AuthService, public businessInfoService: BusinessInfoService) { }

  ngOnInit() {

    // this.httpClient.get('http://localhost:8080/images/businesses/12/image.PNG', )
    //   .subscribe(resp => {
    //       console.log("RESPONSE: " + resp);
    //     }
    //   );


    this.itemCount = this.goals.length;

    this.httpClient.get('http://localhost:8080/businesses', {observe: 'response'})
      .subscribe(resp => {
          console.log(resp.headers);
          console.log(resp.body);
          this.businesses = resp.body;
        }
      );

    this.httpClient.get('http://localhost:8080/locations', {observe: 'response'})
      .subscribe(resp => {
          console.log(resp.headers);
          console.log(resp.body);
          this.locations = resp.body;
        }
      );

    this.httpClient.get('http://localhost:8080/services', {observe: 'response'})
      .subscribe(resp => {
          console.log(resp.headers);
          console.log(resp.body);
          this.services = resp.body;
        }
      )
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

  addItem(){
    this.goals.push(this.goalText);
    this.goalText = "";
    this.itemCount = this.goals.length;
  }
}
