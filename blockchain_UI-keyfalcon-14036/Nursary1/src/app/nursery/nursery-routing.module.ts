import { NgModule } from '@angular/core';
import { Routes,
     RouterModule } from '@angular/router';

import { NurseryComponent } from './nursery.component';

const routes: Routes = [
  {
    path: '',
    component: NurseryComponent,
    data: {
      title: 'Nursery'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NurseryRoutingModule {}
