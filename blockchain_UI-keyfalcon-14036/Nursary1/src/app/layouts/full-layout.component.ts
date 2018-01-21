import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-dashboard',
  templateUrl: './full-layout.component.html',
  styles: [`header.navbar .navbar-brand{
    background-color:#22232b}
    .dropdown-menu .sub-menu {
    left: -100%;
    position: absolute;
    top: 0;
    visibility: hidden;
    margin-top: -1px;
    }
    .dropdown-menu li:hover .sub-menu {
    visibility: visible;
    }
    .dropdown:hover .dropdown-menu {
    display: block;
    }
    .dropdown-toggle::after {
    display: none;
    }
    `]

})
export class FullLayoutComponent implements OnInit {

  public disabled = false;
  public status: {isopen: boolean} = {isopen: false};

  constructor( private route: ActivatedRoute, private router: Router) { }



  public toggled(open: boolean): void {
    console.log('Dropdown is now: ', open);
  }

  public toggleDropdown($event: MouseEvent): void {
    $event.preventDefault();
    $event.stopPropagation();
    this.status.isopen = !this.status.isopen;
  }

  ngOnInit(): void {}

  logoutFun() {
    localStorage.clear();
    this.router.navigate(['/login']);
  }

}
