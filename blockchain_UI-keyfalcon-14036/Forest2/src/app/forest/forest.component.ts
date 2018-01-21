import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

import { DashboardService } from '../service/dashboard.service';
@Component({
  templateUrl: 'forest.component.html',
  providers : [DashboardService]
})
export class ForestComponent {
  closeResult: string;
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

    this.getAllFarmers();
  }

  getAllFarmers() {


    this.dashboardService.getAllFarmers().subscribe(res => {
      this.farmer = res.responseData;
console.log( this.farmer);
this.farmer = [{
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
