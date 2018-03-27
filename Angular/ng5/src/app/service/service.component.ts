import {Component, OnInit} from '@angular/core';
import {CreateBusinessService} from "../services/message.service";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {BusinessInfoService} from "../services/business.info.service";

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.scss']
})
export class ServiceComponent implements OnInit{

  services: object[] = [];

  service: object =  {
    name: '',
    summary: '',
    timeDuration: '',
    price: ''
  };

  selectedFile: File = null;
  url: string = null;
  noImageURL: string  = "../../assets/images/noImageSelected.jpg";
  showSpinner: boolean = false;

  constructor(private httpClient: HttpClient, private router: Router,
              private createBusinessService: CreateBusinessService,
              private businessInfoService: BusinessInfoService) {}


   ngOnInit(){

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


  addService() {
    this.showSpinner = true;

    this.httpClient.post('http://localhost:8080/businesses/' +
      this.createBusinessService.getBusinessId() +'/services',
      this.service,
      {observe: 'response'}
    ).subscribe(resp => {

      if(this.selectedFile) {
        const fd = new FormData();
        fd.append('image', this.selectedFile, this.selectedFile.name);
        this.httpClient.post('http://localhost:8080/services/' + resp.body["id"] + '/images',
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

    this.service['name'] = '';
    this.service['description'] = '';
    this.service['timeDuration'] = '';
    this.service['price'] = '';
  }

  goToLocations(){
    this.router.navigate(['/locations']);
  }

}
