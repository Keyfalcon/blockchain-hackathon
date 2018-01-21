import { NgModule } from '@angular/core';
import { Routes,
     RouterModule } from '@angular/router';

import { ForestRejectedComponent } from './forest_rejected.component';

const routes: Routes = [
  {
    path: '',
    component: ForestRejectedComponent,
    data: {
      title: 'Former Rejected'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ForestRejectedRoutingModule {}
