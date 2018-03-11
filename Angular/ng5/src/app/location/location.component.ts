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





  selectedServices = [];

  change(e, service){
    if(e.checked){
      this.selectedServices.push(service['id']);
    }
    else{
      let updateItem = this.selectedServices.find(this.findIndexToUpdate, service['name']);
      let index = this.selectedServices.indexOf(updateItem);
      this.selectedServices.splice(index, 1);
  }

}

findIndexToUpdate(service) {
  return service['name'] === this;
}

























  constructor(private httpClient: HttpClient, private router: Router, private createBusinessService: CreateBusinessService) {}

  locations: object[] = [];

  location: object = {
    address: '',
    summary: '',
    number: '',
    email: ''
  };

  services: any;

  ngOnInit() {

    this.httpClient.get('http://localhost:8080/businesses/'
      + this.createBusinessService.getBusinessId() + "/services",
      {observe: 'response'}
    ).subscribe(resp => {
      this.services = resp.body;
    });
  }

  showSpinner: boolean = false;

  addLocation() {
    this.showSpinner = true;

    this.httpClient.post('http://localhost:8080/businesses/'
      + this.createBusinessService.getBusinessId() + '/locations',
      this.location,
      {observe: 'response'}
    ).subscribe(resp => {

      this.httpClient.post('http://localhost:8080/locations/' + resp.body["id"] + "/services",
        this.selectedServices,
        {observe: 'response'}
      ).subscribe(resp => {
        console.log(resp);
      });
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
    this.createBusinessService.clearBusinessId();
  }

}
