import { Injectable } from '@angular/core';

@Injectable()
export class BusinessInfoService {

  private currentBusiness: any = null;
  private currentLocation: any = null;
  private currentService: any = null;

  public getCurrentBusiness(){
    return this.currentBusiness;
  }

  public setCurrentBusiness(business){
    this.currentBusiness = business;
  }

  public clearCurrentBusiness() {
    this.currentBusiness = null;
  }

  public getCurrentLocation(){
    return this.currentLocation;
  }

  public setCurrentLocation(location){
    this.currentLocation = location;
  }

  public clearCurrentLocation() {
    this.currentLocation = null;
  }

  public getCurrentService(){
    return this.currentService;
  }

  public setCurrentService(service){
    this.currentService = service;
  }

  public clearCurrentService() {
    this.currentLocation = null;
  }

  public getBookingLocation(){
    return this.currentLocation;
  }

  public setBookingLocation(location){
    this.currentLocation = location;
  }

  public clearBookingLocation() {
    this.currentLocation = null;
  }

  public getBookingService(){
    return this.currentService;
  }

  public setBookingService(service){
    this.currentService = service;
  }

  public clearBookingService() {
    this.currentLocation = null;
  }




}
