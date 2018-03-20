import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';
  showSpinner: boolean = false;

  constructor(private httpClient: HttpClient, private router: Router) {
  }

  ngOnInit() {
  }

  loginUser() {
    this.showSpinner =   true;

    this.httpClient.post('http://localhost:8080/login',
      {
        username: this.username,
        password: this.password
        }, {observe: 'response'}).subscribe(resp => {
      localStorage.setItem('token',resp.headers.getAll('Authorization').toString());
      this.router.navigate(['']);
    });



    setTimeout(() => {
      this.showSpinner = false;
    }, 2000);


  }



}
