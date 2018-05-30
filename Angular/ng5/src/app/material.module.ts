import { NgModule } from '@angular/core';
import { CommonModule} from '@angular/common';
import {
  MatButtonModule, MatToolbarModule, MatInputModule, MatSelectModule,
  MatProgressSpinnerModule, MatCardModule, MatNativeDateModule
} from '@angular/material';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatTabsModule} from '@angular/material/tabs';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatGridListModule} from '@angular/material/grid-list';
import { FlexLayoutModule } from '@angular/flex-layout';

@NgModule({
  imports: [MatButtonModule, MatToolbarModule, MatInputModule, MatTabsModule,
    MatSelectModule,  MatProgressSpinnerModule, MatCardModule, MatCheckboxModule,
    MatDatepickerModule, MatNativeDateModule, MatGridListModule, FlexLayoutModule],
  exports: [MatButtonModule, MatToolbarModule, MatInputModule, MatTabsModule,
    MatSelectModule,  MatProgressSpinnerModule, MatCardModule, MatCheckboxModule,
    MatDatepickerModule, MatNativeDateModule, MatGridListModule, FlexLayoutModule],
})
export class MaterialModule { }
