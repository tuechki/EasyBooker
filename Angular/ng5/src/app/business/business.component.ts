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

  constructor(private httpClient: HttpClient, private router: Router, private createBusinessService: CreateBusinessService) {}

  // answerDisplay: string = '';
  showSpinner: boolean = false;

  ngOnInit() {

  }

  onFileSelected(event){
    this.selectedFile = <File>event.target.files[0];

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
