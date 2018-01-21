import { NgModule } from '@angular/core';
import { ChartsModule } from 'ng2-charts/ng2-charts';

import { FormerComponent } from './farmer.component';
import { FormerRoutingModule } from './farmer-routing.module';

import { CommonModule } from '@angular/common';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
@NgModule({
  imports: [
    FormerRoutingModule,
    ChartsModule,
    NgbModule,
    CommonModule
  ],
  declarations: [ FormerComponent ]
})
export class FormerModule { }
