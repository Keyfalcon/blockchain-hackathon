import { NgModule } from '@angular/core';
import { ChartsModule } from 'ng2-charts/ng2-charts';

import { ForestRejectedComponent } from './forest_rejected.component';
import { ForestRejectedRoutingModule } from './forest_rejected-routing.module';

import { CommonModule } from '@angular/common';
@NgModule({
  imports: [
    ForestRejectedRoutingModule,
    ChartsModule,
    CommonModule
  ],
  declarations: [ ForestRejectedComponent ]
})
export class ForestRejectedModule { }
