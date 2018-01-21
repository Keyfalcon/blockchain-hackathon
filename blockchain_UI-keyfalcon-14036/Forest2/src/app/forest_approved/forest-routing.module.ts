import { NgModule } from '@angular/core';
import { Routes,
     RouterModule } from '@angular/router';

import { ForestApprovedComponent } from './forest_approved.component';

const routes: Routes = [
  {
    path: '',
    component: ForestApprovedComponent,
    data: {
      title: 'ForestApproved'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ForestApprovedRoutingModule {}
