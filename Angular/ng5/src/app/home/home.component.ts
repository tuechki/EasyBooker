import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../auth/auth.service";
import {BusinessInfoService} from "../services/business.info.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  itemCount: number = 4;
  btnText: string = "Add an item";
  goalText: string = "My first goal...";
  goals = ['asdasd', 'anotherThing'];
  businesses: any;

  constructor(private httpClient: HttpClient, private router: Router,
              public authService: AuthService, public businessInfoService: BusinessInfoService) { }

  ngOnInit() {

    this.itemCount = this.goals.length;

    this.httpClient.get('http://localhost:8080/businesses', {observe: 'response'})
      .subscribe(resp => {
          console.log(resp.headers);
          console.log(resp.body);
          this.businesses = resp.body;
        }
      )
  }

  showBusiness(business){
    console.log(business);
    this.businessInfoService.setCurrentBusiness(business);
    this.router.navigate(['business-info']);
  }

  addItem(){
    this.goals.push(this.goalText);
    this.goalText = "";
    this.itemCount = this.goals.length;
  }
}
