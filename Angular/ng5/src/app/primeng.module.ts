import { NgModule } from '@angular/core';
import { CommonModule} from '@angular/common';
import {FileUploadModule} from 'primeng/fileupload';

@NgModule({
  imports: [FileUploadModule],
  exports: [FileUploadModule],
})
export class PrimengModule { }
