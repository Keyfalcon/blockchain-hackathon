import { NgModule } from '@angular/core';
import { ChartsModule } from 'ng2-charts/ng2-charts';

import { FormerRejectedComponent } from './former_rejected.component';
import { FormerRejectedRoutingModule } from './former_rejected-routing.module';

import { CommonModule } from '@angular/common';
@NgModule({
  imports: [
    FormerRejectedRoutingModule,
    ChartsModule,
    CommonModule
  ],
  declarations: [ FormerRejectedComponent ]
})
export class FormerRejectedModule { }
