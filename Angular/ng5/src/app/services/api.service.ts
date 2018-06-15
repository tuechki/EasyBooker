import { Injectable } from '@angular/core';

@Injectable()
export class ApiService {

  private API: string = "http://localhost:8080";

  public getAPI(){
    return this.API;
  }

  public setAPI(API){
    this.API = API;
  }

}
