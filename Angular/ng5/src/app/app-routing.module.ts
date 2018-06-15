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
import {LocationInfoComponent} from "./location-info/location-info.component";
import {ServiceInfoComponent} from "./service-info/service-info.component";
import {UserBusinessesComponent} from "./user-businesses/user-businesses.component";
import {MyProfileComponent} from "./my-profile/my-profile.component";
import {BookingComponent} from "./booking/booking.component";
import {MyBookingsComponent} from "./my-bookings/my-bookings.component";
import {EditBusinessComponent} from "./edit-business/edit-business.component";
import {EditLocationComponent} from "./edit-location/edit-location.component";
import {EditServiceComponent} from "./edit-service/edit-service.component";
import {BusinessBookingsComponent} from "./business-bookings/business-bookings.component";
import {LocationBookingsComponent} from "./location-bookings/location-bookings.component";
import {ServiceBookingsComponent} from "./service-bookings/service-bookings.component";


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
  },
  {
    path: 'location-info',
    component: LocationInfoComponent
  },
  {
    path: 'service-info',
    component: ServiceInfoComponent
  },
  {
    path: 'my-businesses',
    component: UserBusinessesComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'my-profile',
    component: MyProfileComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'booking',
    component: BookingComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'my-bookings',
    component: MyBookingsComponent,
    canActivate: [AuthGuardService]
  },

  {
    path: 'business-bookings',
    component: BusinessBookingsComponent,
    canActivate: [AuthGuardService]
  },

  {
    path: 'location-bookings',
    component: LocationBookingsComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'service-bookings',
    component: ServiceBookingsComponent,
    canActivate: [AuthGuardService]
  },

  {
    path: 'edit-business',
    component: EditBusinessComponent,
    canActivate: [AuthGuardService]
  },

  {
    path: 'edit-location',
    component: EditLocationComponent,
    canActivate: [AuthGuardService]
  },

  {
    path: 'edit-service',
    component: EditServiceComponent,
    canActivate: [AuthGuardService]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
