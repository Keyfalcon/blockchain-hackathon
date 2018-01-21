import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { DashboardService } from '../service/dashboard.service';
@Component({
  templateUrl: 'nursery.component.html',
  providers: [DashboardService]
})
export class NurseryComponent {
  nersary;
  constructor( private dashboardService: DashboardService) {}

  registerFormer(about, address, availablePlants, city, email, experience, mobile, name, password, pincode, repassword) {


    // tslint:disable-next-line:max-line-length
    if ( password == repassword) {
    this.dashboardService.registerFormer(about, address, availablePlants, city, email, experience, mobile, name, password, pincode).subscribe(res => {
      this.nersary = res.responseData;
console.log( this.nersary);
    });
  }
}
}
