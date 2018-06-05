import { Component, OnInit } from '@angular/core';
import {BusinessInfoService} from "../services/business.info.service";
import {FormControl, Validators} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {CreateBusinessService} from "../services/message.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-edit-location',
  templateUrl: './edit-location.component.html',
  styleUrls: ['./edit-location.component.scss']
})
export class EditLocationComponent implements OnInit {


  addressFormControl = new FormControl('', [
    Validators.required
  ]);

  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  selectedServices = [];

  addServiceToLocation(e, service){
    if(e.checked){
      this.selectedServices.push(service['id']);
    }
    else{
      let updateItem = this.selectedServices.find(this.findIndexToUpdate, service['name']);
      let index = this.selectedServices.indexOf(updateItem);
      this.selectedServices.splice(index, 1);
    }

  }

  findIndexToUpdate(service) {
    return service['name'] === this;
  }

  selectedFile: File = null;
  url: string = null;
  noImageURL: string  = "../../assets/images/noImageSelected.jpg";


  constructor(private httpClient: HttpClient, private router: Router,
              private createBusinessService: CreateBusinessService,
              private businessInfoService: BusinessInfoService) {}

  locations: object[] = [];

  dayScheduleMonday: object = {
    weekDay:'MONDAY',
    openTime: null,
    closeTime: null
  };

  dayScheduleTuesday: object = {
    weekDay:'TUESDAY',
    openTime: null,
    closeTime: null
  };

  dayScheduleWednesday: object = {
    weekDay:'WEDNESDAY',
    openTime: null,
    closeTime: null
  };

  dayScheduleThursday: object = {
    weekDay:'THURSDAY',
    openTime: null,
    closeTime: null
  };

  dayScheduleFriday: object = {
    weekDay:'FRIDAY',
    openTime: null,
    closeTime: null
  };

  dayScheduleSaturday: object = {
    weekDay:'SATURDAY',
    openTime: null,
    closeTime: null
  };

  dayScheduleSunday: object = {
    weekDay:'SUNDAY',
    openTime: null,
    closeTime: null
  };


  location: object = {
    address: '',
    summary: '',
    number: '',
    email: '',
    dayScheduleList: [] = []
  };

  services: any;

  ngOnInit() {

    this.httpClient.get('http://localhost:8080/locations/'
      + this.businessInfoService.getCurrentLocation()['id'],
      {observe: 'response'}
    ).subscribe(resp => {
      this.location = resp.body;
    });

    this.httpClient.get('http://localhost:8080/locations/'
      + this.businessInfoService.getCurrentLocation()['id'] + "/business",
      {observe: 'response'}
    ).subscribe(resp => {
      this.httpClient.get('http://localhost:8080/businesses/'
        + resp.body['id'] + "/services",
        {observe: 'response'}
      ).subscribe(resp => {
        this.services = resp.body;
      });
    });



    this.businessInfoService.clearBookingLocation();
    this.businessInfoService.clearBookingService();
  }

  onFileSelected(event:any){
    this.selectedFile = <File>event.target.files[0];

    var reader = new FileReader();
    reader.onload = (event:any) => {
      this.url = event.target.result;
    }

    reader.readAsDataURL(this.selectedFile);
  }

  removeFile(){
    this.selectedFile = null;
  }

  showSpinner: boolean = false;

  updateLocation() {

    if (!this.addressFormControl.hasError('required')
      && !this.emailFormControl.hasError('required')
      && !this.emailFormControl.hasError('email')) {

      this.location['dayScheduleList'].push(this.dayScheduleMonday);
      this.location['dayScheduleList'].push(this.dayScheduleTuesday);
      this.location['dayScheduleList'].push(this.dayScheduleWednesday);
      this.location['dayScheduleList'].push(this.dayScheduleThursday);
      this.location['dayScheduleList'].push(this.dayScheduleFriday);
      this.location['dayScheduleList'].push(this.dayScheduleSaturday);
      this.location['dayScheduleList'].push(this.dayScheduleSunday);
      console.log(this.location['dayScheduleList']);

      this.showSpinner = true;

      this.httpClient.post('http://localhost:8080/businesses/'
        + this.createBusinessService.getBusinessId() + '/locations',
        this.location,
        {observe: 'response'}
      ).subscribe(resp => {


        this.httpClient.post('http://localhost:8080/locations/' + resp.body["id"] + "/services",
          this.selectedServices,
          {observe: 'response'}
        ).subscribe(resp => {
          console.log(resp);
        });


        if (this.selectedFile) {
          const fd = new FormData();
          fd.append('image', this.selectedFile, this.selectedFile.name);
          this.httpClient.post('http://localhost:8080/locations/' + resp.body["id"] + '/images',
            fd
          ).subscribe(resp => {
            this.selectedFile = null;
          });
        }

      });


      setTimeout(() => {
        // this.answerDisplay = this.name;
        this.showSpinner = false;
      }, 2000);

      this.location['address'] = ' ';
      this.location['description'] = '';
      this.location['number'] = '';
      // this.location['email'] = ' ';
      // this.location['dayScheduleList'] = [];
    }
  }

  finish(){
    this.router.navigate(['']);
    this.createBusinessService.clearBusinessId();
  }


}
