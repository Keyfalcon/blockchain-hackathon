import { NgModule } from '@angular/core';
import { Routes,
     RouterModule } from '@angular/router';

import { FormerComponent } from './farmer.component';

const routes: Routes = [
  {
    path: '',
    component: FormerComponent,
    data: {
      title: 'Farmer'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FormerRoutingModule {}
