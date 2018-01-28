import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../auth/auth.service";

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

  constructor(private httpClient: HttpClient, public authService: AuthService) { }

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
  }

  addItem(){
    this.goals.push(this.goalText);
    this.goalText = "";
    this.itemCount = this.goals.length;
  }
}
