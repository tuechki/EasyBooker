import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {CreateBusinessService} from "../services/message.service";

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.scss']
})
export class LocationComponent implements OnInit {

  constructor(private httpClient: HttpClient, private router: Router, private createBusinessService: CreateBusinessService) {}

  locations: object[] = [];

  location: object = {
    businessId: this.createBusinessService.getBusinessId(),
    address: '',
    summary: '',
    number: '',
    email: ''
  };

  services: any;

  ngOnInit() {

    this.httpClient.get('http://localhost:8080/services?businessId=34',
      {observe: 'response'}
    ).subscribe(resp => {
      this.services = resp.body;
    });
  }

  // answerDisplay: string = '';
  showSpinner: boolean = false;


  addLocation() {
    this.showSpinner = true;

    this.httpClient.post('http://localhost:8080/locations',
      this.location,
      {observe: 'response'}
    ).subscribe(resp => {
      console.log(resp);
      this.router.navigate(['/locations']);
    });
    setTimeout(() => {
      // this.answerDisplay = this.name;
      this.showSpinner = false;
    }, 2000);

    this.location['address'] = '';
    this.location['summary'] = '';
    this.location['number'] = '';
    this.location['email'] = '';
  }

  finish(){
    this.router.navigate(['']);
  }

}
