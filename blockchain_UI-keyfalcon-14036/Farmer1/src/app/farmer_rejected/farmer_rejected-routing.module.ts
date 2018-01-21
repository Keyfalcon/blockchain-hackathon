import { NgModule } from '@angular/core';
import { Routes,
     RouterModule } from '@angular/router';

import { FormerRejectedComponent } from './farmer_rejected.component';

const routes: Routes = [
  {
    path: '',
    component: FormerRejectedComponent,
    data: {
      title: 'Former Rejected'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FormerRejectedRoutingModule {}
