import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { DashboardService } from '../service/dashboard.service';

import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

@Component({
  templateUrl: 'former_rejected.component.html',

  providers : [DashboardService]
})
export class FormerRejectedComponent {
closeResult;
  farmer = [{
    name : 'kiran',
    about : 'vgkcyfjhkh',
    survey : '',
    location: '',
    area: '',
    sourceOfWater: 'boarwels',
    soilType: 'red soil',
    adhar: '987654321987',
    image: 'assets/img/hejje.jpg'
  },
  {
    name : 'kiran',
    about : 'vgkcyfjhkh',
    survey : '',
    location: '',
    area: '',
    sourceOfWater: 'boarwels',
    soilType: 'red soil',
    adhar: '987654321987',
    image: 'assets/img/hejje.jpg'
  }]
  constructor(private modalService: NgbModal, private dashboardService: DashboardService) {

    this.getAllFarmersByStatus();
  }

  getAllFarmersByStatus() {


    this.dashboardService.getAllFarmersByStatus('Rejected').subscribe(res => {
      this.farmer = res.responseData;
console.log( this.farmer);
    });
  }


  open(content) {
    this.modalService.open(content).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

}
