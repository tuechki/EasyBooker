import {Component, ElementRef, NgZone, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../auth/auth.service";
import {BusinessInfoService} from "../services/business.info.service";
import {Router} from "@angular/router";
import {FormControl} from "@angular/forms";
import {MapsAPILoader} from "@agm/core";
import {} from '@types/googlemaps'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  businesses: any;
  locations: any;
  services: any;
  loadedBusinesses: boolean;

  businessAddedToFavourites: boolean;
  locationAddedToFavourites: boolean;
  serviceAddedToFavourites: boolean;

  image: File = null;

  public latitude: number;
  public longitude: number;
  public searchControl: FormControl;
  public zoom: number;

  @ViewChild("search")
  public searchElementRef: ElementRef;

  constructor(
    private mapsAPILoader: MapsAPILoader,
    private ngZone: NgZone,
    public authService: AuthService,
    private router: Router,
    private httpClient: HttpClient,
    public businessInfoService: BusinessInfoService
  ) {}


  ngOnInit() {

    this.businessAddedToFavourites = false;
    this.locationAddedToFavourites = false;
    this.serviceAddedToFavourites = false;

    this.loadedBusinesses = false;
    //set google maps defaults
    this.zoom = 4;
    this.latitude = 42.698334;
    this.longitude = 23.319941;

    //create search FormControl
    this.searchControl = new FormControl();

    //set current position
    this.setCurrentPosition();

    //load Places Autocomplete
    this.mapsAPILoader.load().then(() => {
      let autocomplete = new google.maps.places.Autocomplete(this.searchElementRef.nativeElement, {
        types: ["address"]
      });
      autocomplete.addListener("place_changed", () => {
        this.ngZone.run(() => {
          //get the place result
          let place: google.maps.places.PlaceResult = autocomplete.getPlace();

          //verify result
          if (place.geometry === undefined || place.geometry === null) {
            return;
          }

          //set latitude, longitude and zoom
          this.latitude = place.geometry.location.lat();
          this.longitude = place.geometry.location.lng();
          this.zoom = 12;
        });
      });
    });

    this.httpClient.get('http://localhost:8080/businesses', {observe: 'response'})
      .subscribe(resp => {
          console.log(resp.headers);
          console.log(resp.body);
          this.businesses = resp.body;
          this.loadedBusinesses = true;
        }
      );

    this.httpClient.get('http://localhost:8080/locations', {observe: 'response'})
      .subscribe(resp => {
          console.log(resp.headers);
          console.log(resp.body);
          this.locations = resp.body;
        }
      );

    this.httpClient.get('http://localhost:8080/services', {observe: 'response'})
      .subscribe(resp => {
          console.log(resp.headers);
          console.log(resp.body);
          this.services = resp.body;
        }
      );

    this.businessInfoService.clearBookingLocation();
    this.businessInfoService.clearBookingService();
  }

  private setCurrentPosition() {
    if ("geolocation" in navigator) {
      navigator.geolocation.getCurrentPosition((position) => {
        this.latitude = position.coords.latitude;
        this.longitude = position.coords.longitude;
        this.zoom = 12;
      });
    }
  }


  showBusiness(business){
    if(!this.businessAddedToFavourites){
      console.log(business);
      this.businessInfoService.setCurrentBusiness(business);
      this.router.navigate(['business-info']);
    }else{
      console.log("BUSINESS TO FAVOURITES");
    }
  }

  showLocation(location){
    if(!this.locationAddedToFavourites){
      this.businessInfoService.setCurrentLocation(location);
      this.router.navigate(['location-info']);
    }else{
      console.log("LOCATION TO FAVOURITES");
    }
  }

  showService(service){
    if(!this.serviceAddedToFavourites){
      this.businessInfoService.setCurrentService(service);
      this.businessInfoService.clearCurrentLocation();
      this.router.navigate(['service-info']);
    }else{
      console.log("SERVICE TO FAVOURITES");
    }
  }

  addBusinessToFavourites(){
    this.businessAddedToFavourites = true;
  }

  addLocationToFavourites(){
    this.locationAddedToFavourites = true;
  }

  addServiceToFavourites(){
    this.serviceAddedToFavourites = true;
  }

}
