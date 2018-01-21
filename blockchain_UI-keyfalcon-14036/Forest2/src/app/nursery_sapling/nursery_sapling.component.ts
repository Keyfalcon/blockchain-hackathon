import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

@Component({
  templateUrl: 'nursery_sapling.component.html'
})
export class NurserySaplingComponent {

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

  closeResult: string;
  constructor(private modalService: NgbModal) {}
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
