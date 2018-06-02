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
import {MatIconModule} from '@angular/material/icon';


@NgModule({
  imports: [MatButtonModule, MatToolbarModule, MatInputModule, MatTabsModule,
    MatSelectModule,  MatProgressSpinnerModule, MatCardModule, MatCheckboxModule,
    MatDatepickerModule, MatNativeDateModule, MatGridListModule, FlexLayoutModule, MatIconModule],
  exports: [MatButtonModule, MatToolbarModule, MatInputModule, MatTabsModule,
    MatSelectModule,  MatProgressSpinnerModule, MatCardModule, MatCheckboxModule,
    MatDatepickerModule, MatNativeDateModule, MatGridListModule, FlexLayoutModule, MatIconModule],
})
export class MaterialModule { }
