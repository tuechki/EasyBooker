import { Component, OnInit } from '@angular/core';
import {NgForm, FormGroup, FormBuilder, Validators, FormControl, AbstractControl, ValidatorFn} from '@angular/forms';
import {HttpClient} from "@angular/common/http";
import {anchorDef} from "@angular/core/src/view";
import {Router} from "@angular/router";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {

  user: object = {
    firstName: '',
    lastName: '',
    username: '',
    password: '',
    email: '',
    gender: ''
  };


  firstNameFormControl = new FormControl('', [
    Validators.required
  ]);

  lastNameFormControl = new FormControl('', [
    Validators.required
  ]);

  usernameFormControl = new FormControl('', [
    Validators.required
  ]);

  passwordFormControl = new FormControl('', [
    Validators.required
  ]);

  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);


  selectedFile: File = null;
  url: string = null;
  noImageURL: string = "../../assets/images/noImageSelected.jpg";


  answerDisplay: string = '';
  showSpinner: boolean = false;

  constructor(private httpClient: HttpClient, private router: Router) {

  }

  ngOnInit() {

  }


  addUser() {

    if (!this.firstNameFormControl.hasError('required')
      && !this.lastNameFormControl.hasError('required')
      && !this.usernameFormControl.hasError('required')
      && !this.passwordFormControl.hasError('required')
      && !this.emailFormControl.hasError('required')
      && !this.emailFormControl.hasError('email')) {
      this.showSpinner = true;
      console.log(this.user['firstName']);

      this.httpClient.post('http://localhost:8080/users',
        this.user,
        {observe: 'response'}).subscribe(resp => {

        if (this.selectedFile) {
          const fd = new FormData();
          fd.append('image', this.selectedFile, this.selectedFile.name);
          this.httpClient.post('http://localhost:8080/users/' + resp.body["id"] + '/images',
            fd
          ).subscribe(resp => {
            console.log(fd);
          });
        }
        this.router.navigate(['/login']);
      });

      setTimeout(() => {
        this.answerDisplay = this.user['firstName'];
        this.showSpinner = false;
      }, 2000);

    }
  }

  onFileSelected(event: any) {
    this.selectedFile = <File>event.target.files[0];

    var reader = new FileReader();
    reader.onload = (event: any) => {
      this.url = event.target.result;
    }

    reader.readAsDataURL(this.selectedFile);
  }

  removeFile() {
    this.selectedFile = null;
  }

}


