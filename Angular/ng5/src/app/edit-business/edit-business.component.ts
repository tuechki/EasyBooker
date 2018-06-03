import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {CreateBusinessService} from "../services/message.service";
import {BusinessInfoService} from "../services/business.info.service";

@Component({
  selector: 'app-edit-business',
  templateUrl: './edit-business.component.html',
  styleUrls: ['./edit-business.component.scss']
})
export class EditBusinessComponent implements OnInit {

  business: object = {
    name: '',
    description: '',
    email: ''
  };

  selectedFile: File = null;
  url: string = null;
  noImageURL: string  = "../../assets/images/noImageSelected.jpg";
  showSpinner: boolean = false;

  constructor(private httpClient: HttpClient, private router: Router,
              private createBusinessService: CreateBusinessService,
              private businessInfoService: BusinessInfoService) {}


  ngOnInit() {

    this.httpClient.get('http://localhost:8080/businesses/'
      + 2,
      {observe: 'response'}
    ).subscribe(resp => {
      this.business = resp.body;
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

  updateBusiness() {
    this.showSpinner = true;

    this.httpClient.put('http://localhost:8080/businesses',
      this.business,
      {observe: 'response'}
    ).subscribe(resp => {
      this.createBusinessService.setBusinessId(resp.body["id"]);

      if(this.selectedFile) {
        const fd = new FormData();
        fd.append('image', this.selectedFile, this.selectedFile.name);
        this.httpClient.post('http://localhost:8080/businesses/' + resp.body["id"] + '/images',
          fd
        ).subscribe(resp => {
          console.log(fd);
        });
      }

      // this.router.navigate(['/services']);
    });
    setTimeout(() => {
      // this.answerDisplay = this.name;
      this.showSpinner = false;
    }, 2000);
  }
}