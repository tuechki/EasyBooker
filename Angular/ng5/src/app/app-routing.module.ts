import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginComponent } from './login/login.component';
import {BusinessComponent} from "./business/business.component";
import {AuthGuardService} from "./auth/auth.guard.service";
import {LocationComponent} from "./location/location.component";
import {ServiceComponent} from "./service/service.component";
import {BusinessInfoComponent} from "./business-info/business-info.component";


const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'about',
    component: AboutComponent
  },
  {
    path: 'sign-up',
    component: SignUpComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'businesses',
    component: BusinessComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'locations',
    component: LocationComponent,
    canActivate:[AuthGuardService]
  },
  {
    path: 'services',
    component: ServiceComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'business-info',
    component: BusinessInfoComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
