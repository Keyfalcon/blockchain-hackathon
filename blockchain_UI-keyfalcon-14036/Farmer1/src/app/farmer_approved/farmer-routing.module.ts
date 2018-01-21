import { NgModule } from '@angular/core';
import { Routes,
     RouterModule } from '@angular/router';

import { FormerApprovedComponent } from './farmer_approved.component';

const routes: Routes = [
  {
    path: '',
    component: FormerApprovedComponent,
    data: {
      title: 'FormerApproved'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FormerApprovedRoutingModule {}
