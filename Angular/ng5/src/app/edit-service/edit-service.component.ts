import { Component, OnInit } from '@angular/core';
import {BusinessInfoService} from "../services/business.info.service";
import {FormControl, Validators} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {CreateBusinessService} from "../services/message.service";
import {Router} from "@angular/router";
import {ApiService} from "../services/api.service";

@Component({
  selector: 'app-edit-service',
  templateUrl: './edit-service.component.html',
  styleUrls: ['./edit-service.component.scss']
})
export class EditServiceComponent implements OnInit {

  nameFormControl = new FormControl('', [
    Validators.required
  ]);

  timeDurationFormControl = new FormControl('', [
    Validators.required
  ]);

  priceFormControl = new FormControl('', [
    Validators.required
  ]);

  services: object[] = [];

  service: object =  {
    name: '',
    summary: '',
    timeDuration: '',
    price: ''
  };

  timeDuration: string;

  selectedFile: File = null;
  url: string = null;
  noImageURL: string  = "../../assets/images/noImageSelected.jpg";
  showSpinner: boolean = false;

  constructor(private httpClient: HttpClient, private router: Router,
              private createBusinessService: CreateBusinessService,
              private businessInfoService: BusinessInfoService,
              public apiService: ApiService) {}


  ngOnInit(){

    this.httpClient.get(this.apiService.getAPI() + '/services/'
      + this.businessInfoService.getCurrentService()['id'],
      {observe: 'response'}
    ).subscribe(resp => {
      this.service = resp.body;
      this.timeDuration = this.service['timeDuration']['hours'].toString() + ":" + this.service['timeDuration']['minutes'].toString();
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


  updateService() {

    if (!this.nameFormControl.hasError('required')
      && !this.timeDurationFormControl.hasError('required')
      && !this.priceFormControl.hasError('required')) {

      this.showSpinner = true;

      let timeDurationList = this.timeDuration.split(':')
      this.service['timeDuration']['minutes'] = timeDurationList.pop();
      this.service['timeDuration']['hours'] = timeDurationList.pop();

      this.httpClient.post(this.apiService.getAPI() + '/businesses/' +
        this.createBusinessService.getBusinessId() + '/services',
        this.service,
        {observe: 'response'}
      ).subscribe(resp => {

        if (this.selectedFile) {
          const fd = new FormData();
          fd.append('image', this.selectedFile, this.selectedFile.name);
          this.httpClient.post(this.apiService.getAPI() + '/services/' + resp.body["id"] + '/images',
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

      this.service['name'] = ' ';
      this.service['description'] = ' ';
      this.service['timeDuration'] = ' ';
      this.service['price'] = ' ';
    }
  }

  goToLocations(){
    this.router.navigate(['/locations']);
  }

}
