import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {ApiService} from "../services/api.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';
  showSpinner: boolean = false;

  constructor(private httpClient: HttpClient, private router: Router, public apiService: ApiService) {
  }

  ngOnInit() {
  }

  loginUser() {
    this.showSpinner =   true;

    this.httpClient.post(this.apiService.getAPI() + '/login',
      {
        username: this.username,
        password: this.password
        }, {observe: 'response'}).subscribe(resp => {
          console.log("RESPONSE  BODY: " + resp.body);
          console.log("RESPONSE  HEADERS: " + resp.headers);
      localStorage.setItem('token',resp.headers.getAll('Authorization').toString());
      this.router.navigate(['']);
    });



    setTimeout(() => {
      this.showSpinner = false;
    }, 2000);


  }



}
