import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {ResponseContentType} from "@angular/http";



@Injectable()
export class ImageService {

  URL = 'http://localhost:8080';

  constructor( private httpClient: HttpClient) {
  }

  public getImage(
    //hero: Hero
    ): Observable<Blob> {
    return this.httpClient
      .get(`${this.URL}/images/businesses/2/lulin.PNG`
      // ${hero._id}`
        , {
        responseType: "blob"
      });
  }

}
