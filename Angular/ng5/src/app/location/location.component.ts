import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {CreateBusinessService} from "../services/message.service";
import {BusinessInfoService} from "../services/business.info.service";

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.scss']
})
export class LocationComponent implements OnInit {





  selectedServices = [];

  change(e, service){
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

  location: object = {
    address: '',
    summary: '',
    number: '',
    email: ''
  };

  services: any;

  ngOnInit() {

    this.httpClient.get('http://localhost:8080/businesses/'
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


      if(this.selectedFile) {
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

    this.location['address'] = '';
    this.location['description'] = '';
    this.location['number'] = '';
    this.location['email'] = '';
  }

  finish(){
    this.router.navigate(['']);
    this.createBusinessService.clearBusinessId();
  }

}
