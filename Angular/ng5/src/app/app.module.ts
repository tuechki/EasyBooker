import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MaterialModule } from './material.module';
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
import {FileUploadModule} from 'primeng/fileupload';
import { DataTableModule } from 'primeng/primeng';

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
    BusinessInfoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MaterialModule,
    ReactiveFormsModule,
    HttpClientModule,
    FileUploadModule,
    DataTableModule

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