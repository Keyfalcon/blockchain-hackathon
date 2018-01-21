import { NgModule } from '@angular/core';
import { Routes,
     RouterModule } from '@angular/router';

import { FormerApprovedComponent } from './former_approved.component';

const routes: Routes = [
  {
    path: '',
    component: FormerApprovedComponent,
    data: {
      title: 'Former Approved'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FormerApprovedRoutingModule {}
