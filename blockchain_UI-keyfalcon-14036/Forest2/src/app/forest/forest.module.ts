import { NgModule } from '@angular/core';
import { ChartsModule } from 'ng2-charts/ng2-charts';

import { ForestComponent } from './forest.component';
import { ForestRoutingModule } from './forest-routing.module';

import { CommonModule } from '@angular/common';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
@NgModule({
  imports: [
    ForestRoutingModule,
    ChartsModule,
    NgbModule,
    CommonModule
  ],
  declarations: [ ForestComponent ]
})
export class ForestModule { }
