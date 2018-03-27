import { Component, OnInit } from '@angular/core';
import { NgForm, FormGroup,FormBuilder,Validators } from '@angular/forms';
import {HttpClient} from "@angular/common/http";
import {anchorDef} from "@angular/core/src/view";
import {Router} from "@angular/router";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {

  user: object ={
    firstName: '',
    lastName: '',
    username: '',
    password: '',
    email: '',
    gender: ''
  };

  confirmPassword: '';


  answerDisplay: string = '';
  showSpinner: boolean = false;


  constructor(private httpClient: HttpClient, private router: Router) {
  }
  ngOnInit() {

  };



  addUser() {
    this.showSpinner = true;
    console.log(this.user['firstName']);

    this.httpClient.post('http://localhost:8080/users',
      this.user,
      {observe: 'response'}).subscribe(resp => {
              console.log(resp.headers);
              console.log(resp.body);
              this.router.navigate(['/login']);
    });

    setTimeout(() => {
      this.answerDisplay = this.user['firstName'];
      this.showSpinner = false;
    }, 2000);


  }


}
