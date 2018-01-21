import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AuthGuard } from './gaurds/auth-gaurd';
// Layouts
import { FullLayoutComponent } from './layouts/full-layout.component';

import { SimpleLayoutComponent } from './layouts/simple-layout.component';
export const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full',
  },
  {
    path: '',
    component: FullLayoutComponent,
    data: {
      title: 'Home'
    },
    children: [
      {
        path: 'dashboard',
        loadChildren: './dashboard/dashboard.module#DashboardModule'
      },
      {
        path: 'farmer',
        loadChildren: './farmer/farmer.module#FormerModule'
      },
      {
        path: 'farmer_approved',
        loadChildren: './farmer_approved/farmer_approved.module#FormerApprovedModule'
      },
      {
        path: 'farmer_rejected',
        loadChildren: './farmer_rejected/farmer_rejected.module#FormerRejectedModule'
      },
      {
        path: 'nursery',
        loadChildren: './nursery/nursery.module#NurseryModule'
      },
      {
        path: 'nursery_sapling',
        loadChildren: './nursery_sapling/nursery_sapling.module#NurserySaplingModule'
      },
    ]
  },
  {
    path: '',
    component: SimpleLayoutComponent,
    data: {
      title: 'login'
    },
    children: [
      {
        path: 'login',
        loadChildren: './login/login.module#LoginModule',
      }
    ]
  },
  {
    path: '',
    component: SimpleLayoutComponent,
    data: {
      title: 'nurseryregister'
    },
    children: [
      {
        path: 'nurseryregister',
        loadChildren: './nursery/nursery.module#NurseryModule'
      }
    ]
  },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
