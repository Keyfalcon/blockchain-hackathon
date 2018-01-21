import { NgModule } from '@angular/core';
import { ChartsModule } from 'ng2-charts/ng2-charts';

import {NurseryComponent } from './nursery.component';
import { NurseryRoutingModule } from './nursery-routing.module';

@NgModule({
  imports: [
    NurseryRoutingModule,
    ChartsModule
  ],
  declarations: [ NurseryComponent ]
})
export class NurseryModule { }
