import {Component, Inject, LOCALE_ID, OnInit} from '@angular/core';
import {tokenNotExpired} from "angular2-jwt";
import {AuthService} from "./auth/auth.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{

  // Configuration of the time picker (format 12H with a default date and time)
  private config = { hour: 7, minute: 15, meriden: 'PM', format: 12 };

  languages = [
    { code: 'en', label: 'English'},
    { code: 'bg', label: 'Български'}
  ];

  constructor(@Inject(LOCALE_ID) protected localeId: string, public authService: AuthService, private router: Router){}


  ngOnInit() {
  }

  removeToken(){
    console.log(this.authService.isAuthenticated());
    localStorage.removeItem('token');
    console.log(this.authService.isAuthenticated());
    this.router.navigate(['']);
  }
}
