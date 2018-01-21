import { NgModule } from '@angular/core';
import { ChartsModule } from 'ng2-charts/ng2-charts';

import { FormerComponent } from './former.component';
import { FormerRoutingModule } from './former-routing.module';

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
