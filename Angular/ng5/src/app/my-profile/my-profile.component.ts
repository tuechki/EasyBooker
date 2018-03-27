import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {BusinessInfoService} from "../services/business.info.service";

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.scss']
})
export class MyProfileComponent implements OnInit {

  user: object ={
    id: '',
    firstName: '',
    lastName: '',
    username: '',
    password: '',
    email: '',
    number: '',
    gender: ''
  };


  newPassword: string = '';
  answerDisplay: string = '';
  showSpinner: boolean = false;


  constructor(private httpClient: HttpClient, private router: Router, private businessInfoService: BusinessInfoService) {
  }

  ngOnInit() {

    this.httpClient.get('http://localhost:8080/users/loggedInUser',
      {observe: 'response'}).subscribe(resp => {
      this.user = resp.body;
      console.log(resp.body);
      console.log(this.user);
    });

    this.businessInfoService.clearBookingLocation();
    this.businessInfoService.clearBookingService();
  };

  updateUser() {
    this.showSpinner = true;

    if(this.newPassword != ''){
      this.user['password'] = this.newPassword;
    }

    this.httpClient.put('http://localhost:8080/users/loggedInUser',
      this.user,
      {observe: 'response'}).subscribe(resp => {
          this.httpClient.get('http://localhost:8080/users/loggedInUser',
            {observe: 'response'}).subscribe(resp => {
            this.user = resp.body;
          });
    });

    setTimeout(() => {
      this.answerDisplay = this.user['firstName'];
      this.showSpinner = false;
    }, 2000);


  }
}
