import { NgModule } from '@angular/core';
import { ChartsModule } from 'ng2-charts/ng2-charts';

import { FormerApprovedComponent } from './former_approved.component';
import { FormerApprovedRoutingModule } from './former-routing.module';

import { CommonModule } from '@angular/common';
@NgModule({
  imports: [
    FormerApprovedRoutingModule,
    ChartsModule,
    CommonModule
  ],
  declarations: [ FormerApprovedComponent ]
})
export class FormerApprovedModule { }
