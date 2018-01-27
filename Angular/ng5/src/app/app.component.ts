import { Component } from '@angular/core';
import {tokenNotExpired} from "angular2-jwt";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {


  authenticated: boolean = true;

  constructor(){}

  ngOnInit() {
  }

  public isAuthenticated(): boolean {

      const token = localStorage.getItem('token');
      return tokenNotExpired(token);

  }


  removeToken(){
    console.log(localStorage.getItem('token'));
    console.log(this.isAuthenticated());

    localStorage.removeItem('token');
    this.authenticated = false;
    console.log(localStorage.getItem('token'));
    console.log(this.isAuthenticated());

  }

  title = 'app';
}
