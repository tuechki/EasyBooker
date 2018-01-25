import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-business',
  templateUrl: './business.component.html',
  styleUrls: ['./business.component.scss']
})
export class BusinessComponent implements OnInit {

  name: string = '';
  summary: string = '';
  email: string = '';

  // answerDisplay: string = '';
  showSpinner: boolean = false;

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
  }

  addBusiness() {
    this.showSpinner = true;

    this.httpClient.post('http://localhost:8080/businesses',
      {name: this.name,
        summary: this.summary,
        email: this.email}).subscribe(res => console.log(res));

    setTimeout(() => {
      // this.answerDisplay = this.name;
      this.showSpinner = false;
    }, 2000);
  }

}
