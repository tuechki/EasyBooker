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

  genders = [
    {value: 'male', viewValue: 'Male'},
    {value: 'female', viewValue: 'Female'},
    {value: 'other', viewValue: 'Other'}
  ];


  firstName: string = '';
  lastName: string = '';
  username: string = '';
  password: string = '';
  confirmPassword: string = '';
  email: string = '';
  number: string = '';

  answerDisplay: string = '';
  showSpinner: boolean = false;


  constructor(private httpClient: HttpClient, private router: Router) {
  }
  ngOnInit() {

  };

  addUser() {
    this.showSpinner = true;
    console.log(this.firstName);

    this.httpClient.post('http://localhost:8080/users/sign-up',
      {firstName: this.firstName,
              lastName: this.lastName,
              username: this.username,
              password: this.password,
              email: this.email,
              number: this.number}, {observe: 'response'}).subscribe(resp => {
              console.log(resp.headers);
              console.log(resp.body);
              this.router.navigate(['/login']);
    });

    setTimeout(() => {
      this.answerDisplay = this.firstName;
      this.showSpinner = false;
    }, 2000);


  }


}
