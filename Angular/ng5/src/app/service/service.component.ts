import { Component} from '@angular/core';
import {CreateBusinessService} from "../services/message.service";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.scss']
})
export class ServiceComponent{

  constructor(private httpClient: HttpClient, private router: Router, private createBusinessService: CreateBusinessService) {}

  services: object[] = [];

  service: object =  {
    name: '',
    summary: '',
    timeDuration: '',
    price: ''
  };

  // answerDisplay: string = '';
  showSpinner: boolean = false;


  addService() {
    this.showSpinner = true;

    this.httpClient.post('http://localhost:8080/businesses/' +
      this.createBusinessService.getBusinessId() +'/services',
      this.service,
      {observe: 'response'}
    ).subscribe(resp => {
      console.log(resp);
    });
    setTimeout(() => {
      // this.answerDisplay = this.name;
      this.showSpinner = false;
    }, 2000);

    this.service['name'] = '';
    this.service['summary'] = '';
    this.service['timeDuration'] = '';
    this.service['price'] = '';
  }

  goToLocations(){
    this.router.navigate(['/locations']);
  }

}
