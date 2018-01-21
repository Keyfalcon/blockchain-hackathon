import { NgModule } from '@angular/core';
import { ChartsModule } from 'ng2-charts/ng2-charts';

import {NurserySaplingComponent } from './nursery_sapling.component';
import { NurserySaplingRoutingModule } from './nursery_sapling-routing.module';

import { CommonModule } from '@angular/common';
@NgModule({
  imports: [
    NurserySaplingRoutingModule,
    ChartsModule,
    CommonModule
  ],
  declarations: [ NurserySaplingComponent ]
})
export class NurserySaplingModule { }
