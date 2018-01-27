import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';
  showSpinner: boolean = false;

  constructor(private httpClient: HttpClient) {
  }

  ngOnInit() {
  }

  loginUser() {
    this.showSpinner = true;
    console.log(this.username);

    this.httpClient.post('http://localhost:8080/login',
      {
        username: this.username,
        password: this.password
        }, {observe: 'response'}).subscribe(resp => {
        console.log(resp.headers);
        console.log(resp.headers.get('cache-control'));
      console.log(resp.headers.getAll('Authorization').toString());
      localStorage.setItem('token',resp.headers.getAll('Authorization').toString());
    });



    setTimeout(() => {
      this.showSpinner = false;
    }, 2000);
  }



}
