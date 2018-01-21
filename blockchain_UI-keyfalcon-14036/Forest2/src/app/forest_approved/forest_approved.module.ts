import { NgModule } from '@angular/core';
import { ChartsModule } from 'ng2-charts/ng2-charts';

import { ForestApprovedComponent } from './forest_approved.component';
import { ForestApprovedRoutingModule } from './forest-routing.module';

import { CommonModule } from '@angular/common';
@NgModule({
  imports: [
    ForestApprovedRoutingModule,
    ChartsModule,
    CommonModule
  ],
  declarations: [ ForestApprovedComponent ]
})
export class ForestApprovedModule { }
