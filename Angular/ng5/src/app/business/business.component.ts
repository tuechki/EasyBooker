import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {CreateBusinessService} from "../services/message.service";

@Component({
  selector: 'app-business',
  templateUrl: './business.component.html',
  styleUrls: ['./business.component.scss']
})
export class BusinessComponent implements OnInit {

  business: object = {
    name: '',
    summary: '',
    email: ''
  };

  selectedFile: File = null;
  url: string = null;
  noImageURL: string  = "../../assets/images/noImageSelected.jpg";
  showSpinner: boolean = false;

  constructor(private httpClient: HttpClient, private router: Router, private createBusinessService: CreateBusinessService) {}


  ngOnInit() {

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

  addBusiness() {
    this.showSpinner = true;

    this.httpClient.post('http://localhost:8080/businesses',
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

      this.router.navigate(['/services']);
    });
    setTimeout(() => {
      // this.answerDisplay = this.name;
      this.showSpinner = false;
    }, 2000);
  }

}
