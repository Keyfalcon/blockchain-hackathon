import { NgModule } from '@angular/core';
import { Routes,
     RouterModule } from '@angular/router';

import { NurserySaplingComponent } from './nursery_sapling.component';

const routes: Routes = [
  {
    path: '',
    component: NurserySaplingComponent,
    data: {
      title: 'Nursery Sapling'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NurserySaplingRoutingModule {}
