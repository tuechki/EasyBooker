import { NgModule } from '@angular/core';
import { CommonModule} from '@angular/common';
import { MatButtonModule, MatToolbarModule, MatInputModule, MatSelectModule,
  MatProgressSpinnerModule, MatCardModule} from '@angular/material';
import {MatCheckboxModule} from '@angular/material/checkbox';

@NgModule({
  imports: [MatButtonModule, MatToolbarModule, MatInputModule,
    MatSelectModule,  MatProgressSpinnerModule, MatCardModule, MatCheckboxModule],
  exports: [MatButtonModule, MatToolbarModule, MatInputModule,
    MatSelectModule,  MatProgressSpinnerModule, MatCardModule, MatCheckboxModule],
})
export class MaterialModule { }
