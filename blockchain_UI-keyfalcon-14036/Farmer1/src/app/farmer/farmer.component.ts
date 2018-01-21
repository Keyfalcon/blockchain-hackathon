import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

import { DashboardService } from '../service/dashboard.service';
@Component({
  templateUrl: 'farmer.component.html',
  providers : [DashboardService]
})
export class FormerComponent {
  closeResult: string;
  farmer ;
  status;
  constructor(private modalService: NgbModal, private dashboardService: DashboardService) {

    this.getAllFarmersByStatus();
  }

  approve(id) {
    console.log(id + 'approve');
    this.dashboardService.
    setStatus(id, 'Approved').subscribe(res => {
      this.status = res.responseData;
      console.log(this.status);
    });
  }
  reject(id){
    this.dashboardService.
    setStatus(id, 'Rejected').subscribe(res => {
      this.status = res.responseData;
    });
  }
  clarify(id){
    this.dashboardService.
    setStatus(id, 'Clarify').subscribe(res => {
      this.status = res.responseData;
    });
  }
getAllFarmersByStatus() {


    this.dashboardService.
    getAllFarmersByStatus('Request').subscribe(res => {
      this.farmer = res.responseData;
console.log( this.farmer);
    });
  }

  getAllFarmers() {


    this.dashboardService.getAllFarmers().subscribe(res => {
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
