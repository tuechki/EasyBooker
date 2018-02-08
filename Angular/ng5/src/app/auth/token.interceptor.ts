import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { AuthService } from './auth.service';
import { Observable } from 'rxjs/Observable';
import {CreateBusinessService} from "../services/message.service";

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor(public auth: AuthService, public createBusinessService: CreateBusinessService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    request = request.clone({

      setHeaders: {
        Authorization: `${this.auth.getToken()}`,
        businessId: `${this.createBusinessService.getBusinessId()}`
      }
    });

    return next.handle(request);
  }
}
