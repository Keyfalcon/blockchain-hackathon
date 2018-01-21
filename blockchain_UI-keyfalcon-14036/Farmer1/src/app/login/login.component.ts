import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import 'rxjs/add/operator/map';
// * We import Inject here

import { DashboardService } from '../service/dashboard.service';
import { Observable } from 'rxjs/Observable';
import {
  ToasterModule,
  ToasterService,
  ToasterConfig
} from 'angular2-toaster/angular2-toaster';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: [`input.ng-valid{border-left:5px solid green;}
  input.ng-invalid{border-left:5px solid red;}`],
  providers : [DashboardService]

})
export class LoginComponent implements OnInit {
  user_name: string;
  pass_word: string;
  userForm: FormGroup;
  public data;
  public user;
  public loginObj = {};


  private toasterService: ToasterService;
  public toasterconfig: ToasterConfig =
    new ToasterConfig({
      tapToDismiss: true,
      timeout: 5000
    });



  constructor( private dashboardService: DashboardService, private _formBuilder: FormBuilder, private router: Router, toasterService: ToasterService) {
    this.toasterService = toasterService;

  }
  ngOnInit() {
    this.userForm = this._formBuilder.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]],
    })
  }

  login() {
     this.router.navigateByUrl('/dashboard');
    this.dashboardService.login(this.user,this.pass_word).subscribe(loginRes => {
      if (loginRes.code === 200) {
     //   console.log(loginRes);
        if (loginRes.responseData.roleId == 1) {

        }
        this.router.navigateByUrl('/report');

      } else if (loginRes.code === 207) {
        this.toasterService.pop('Error', 'Error', 'Invalid user name or password ');
      }

    });
  }
}

