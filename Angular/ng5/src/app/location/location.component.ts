import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {CreateBusinessService} from "../services/message.service";
import {BusinessInfoService} from "../services/business.info.service";
import {FormControl, Validators} from "@angular/forms";
import {ApiService} from "../services/api.service";
import { AmazingTimePickerService } from 'amazing-time-picker';

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.scss']
})
export class LocationComponent implements OnInit {

  addressFormControl = new FormControl('', [
    Validators.required
  ]);

  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  numberFormControl = new FormControl('', [
    Validators.pattern("[0-9]*")
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
              private businessInfoService: BusinessInfoService,
              public apiService: ApiService,
              public atp: AmazingTimePickerService) {}


  public selectedOpenTime: string;
  public selectedCloseTime: string;


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

  open(whichTime: string) {
    const amazingTimePicker = this.atp.open();
    amazingTimePicker.afterClose().subscribe(time => {
      if(whichTime === "mondayOpen"){
        this.selectedOpenTime = time;
        this.dayScheduleMonday['openTime'] = this.selectedOpenTime + ':00';
      } else if(whichTime === "mondayClose"){
        this.selectedCloseTime = time;
        this.dayScheduleMonday['closeTime'] = this.selectedCloseTime + ':00';
      } else

        if(whichTime === "tuesdayOpen"){
        this.selectedOpenTime = time;
        this.dayScheduleTuesday['openTime'] = this.selectedOpenTime + ':00';
      } else if(whichTime === "tuesdayClose"){
        this.selectedCloseTime = time;
        this.dayScheduleTuesday['closeTime'] = this.selectedCloseTime + ':00';
      } else

        if(whichTime === "wednesdayOpen"){
        this.selectedOpenTime = time;
        this.dayScheduleWednesday['openTime'] = this.selectedOpenTime + ':00';
      } else if(whichTime === "wednesdayClose"){
        this.selectedCloseTime = time;
        this.dayScheduleWednesday['closeTime'] = this.selectedCloseTime + ':00';
      }else

        if(whichTime === "thursdayOpen"){
          this.selectedOpenTime = time;
          this.dayScheduleThursday['openTime'] = this.selectedOpenTime + ':00';
        } else if(whichTime === "thursdayClose"){
          this.selectedCloseTime = time;
          this.dayScheduleThursday['closeTime'] = this.selectedCloseTime + ':00';
        }else

        if(whichTime === "fridayOpen"){
          this.selectedOpenTime = time;
          this.dayScheduleFriday['openTime'] = this.selectedOpenTime + ':00';
        } else if(whichTime === "fridayClose"){
          this.selectedCloseTime = time;
          this.dayScheduleFriday['closeTime'] = this.selectedCloseTime + ':00';
        }else

        if(whichTime === "saturdayOpen"){
          this.selectedOpenTime = time;
          this.dayScheduleSaturday['openTime'] = this.selectedOpenTime + ':00';
        } else if(whichTime === "saturdayClose"){
          this.selectedCloseTime = time;
          this.dayScheduleSaturday['closeTime'] = this.selectedCloseTime + ':00';
        }else

        if(whichTime === "sundayOpen"){
          this.selectedOpenTime = time;
          this.dayScheduleSunday['openTime'] = this.selectedOpenTime + ':00';
        } else if(whichTime === "sundayClose"){
          this.selectedCloseTime = time;
          this.dayScheduleSunday['closeTime'] = this.selectedCloseTime + ':00';
        }


    });
  }

  ngOnInit() {

    this.httpClient.get(this.apiService.getAPI() + '/businesses/'
      + this.createBusinessService.getBusinessId() + "/services",
      {observe: 'response'}
    ).subscribe(resp => {
      this.services = resp.body;
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

   addLocation() {

     if (!this.addressFormControl.hasError('required')
       && !this.emailFormControl.hasError('required')
       && !this.emailFormControl.hasError('email')
       && !this.numberFormControl.hasError('pattern')) {

       this.location['dayScheduleList'].push(this.dayScheduleMonday);
       this.location['dayScheduleList'].push(this.dayScheduleTuesday);
       this.location['dayScheduleList'].push(this.dayScheduleWednesday);
       this.location['dayScheduleList'].push(this.dayScheduleThursday);
       this.location['dayScheduleList'].push(this.dayScheduleFriday);
       this.location['dayScheduleList'].push(this.dayScheduleSaturday);
       this.location['dayScheduleList'].push(this.dayScheduleSunday);
       console.log(this.location['dayScheduleList']);

       this.showSpinner = true;

       this.httpClient.post(this.apiService.getAPI() + '/businesses/'
         + this.createBusinessService.getBusinessId() + '/locations',
         this.location,
         {observe: 'response'}
       ).subscribe(resp => {


         this.httpClient.post(this.apiService.getAPI() + '/locations/' + resp.body["id"] + "/services",
           this.selectedServices,
           {observe: 'response'}
         ).subscribe(resp => {
           console.log(resp);
         });


         if (this.selectedFile) {
           const fd = new FormData();
           fd.append('image', this.selectedFile, this.selectedFile.name);
           this.httpClient.post(this.apiService.getAPI() + '/locations/' + resp.body["id"] + '/images',
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
