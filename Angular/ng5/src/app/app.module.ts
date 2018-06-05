import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginComponent } from './login/login.component';

import { HttpClientModule } from '@angular/common/http';
import { BusinessComponent } from './business/business.component';
import { LocationComponent } from './location/location.component';
import { AuthComponent } from './auth/auth.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptor } from './auth/token.interceptor';
import {AuthService} from "./auth/auth.service";
import {AuthGuardService} from "./auth/auth.guard.service";
import { ServiceComponent } from './service/service.component';
import { CreateBusinessService } from './services/message.service';
import { BusinessInfoComponent } from './business-info/business-info.component';
import { BusinessInfoService } from './services/business.info.service';
import {UploadService} from "./services/upload.service";
import { LocationInfoComponent } from './location-info/location-info.component';
import { ServiceInfoComponent } from './service-info/service-info.component';

import { MaterialModule } from './material.module';
import { PrimengModule } from './primeng.module';
import { AgmCoreModule } from '@agm/core';
import { UserBusinessesComponent } from './user-businesses/user-businesses.component';
import { MyProfileComponent } from './my-profile/my-profile.component';
import { BookingComponent } from './booking/booking.component';
import { MyBookingsComponent } from './my-bookings/my-bookings.component';
import { EditBusinessComponent } from './edit-business/edit-business.component';
import { EditServiceComponent } from './edit-service/edit-service.component';
import { EditLocationComponent } from './edit-location/edit-location.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    SignUpComponent,
    LoginComponent,
    BusinessComponent,
    LocationComponent,
    AuthComponent,
    ServiceComponent,
    BusinessInfoComponent,
    LocationInfoComponent,
    ServiceInfoComponent,
    UserBusinessesComponent,
    MyProfileComponent,
    BookingComponent,
    MyBookingsComponent,
    EditBusinessComponent,
    EditServiceComponent,
    EditLocationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MaterialModule,
    ReactiveFormsModule,
    HttpClientModule,
    PrimengModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyCuxNJz1x-vTL9ggD0ELJ9p357RyzKHUZg',
      libraries: ["places"]
    })

],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }, AuthService,
      AuthGuardService,
      CreateBusinessService,
      BusinessInfoService,
      UploadService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
