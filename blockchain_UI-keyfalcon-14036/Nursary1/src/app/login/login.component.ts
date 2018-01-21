import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import 'rxjs/add/operator/map';
// * We import Inject here

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
  input.ng-invalid{border-left:5px solid red;}`]
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



  constructor( private _formBuilder: FormBuilder, private router: Router, toasterService: ToasterService) {
    this.toasterService = toasterService;

  }
  ngOnInit() {
    this.userForm = this._formBuilder.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]],
    })
  }
  register() {
    // console.log(this.userForm.controls.username.value);
    this.router.navigateByUrl('/nurseryregister');
  }
  login() {
    // console.log(this.userForm.controls.username.value);
    this.router.navigateByUrl('/dashboard');
    // this.userService.login(this.user).subscribe(loginRes => {
    //   if (loginRes.code === 200) {
    //  //   console.log(loginRes);
    //     if (loginRes.responseData.roleId == 1) {

    //     } else if (loginRes.responseData.roleId == 2) {
    //       localStorage.setItem('divisionId', loginRes.responseData.divisionId);
    //       localStorage.setItem('CrlId', loginRes.responseData.circleName);

    //     } else if (loginRes.responseData.roleId == 3) {
    //       localStorage.setItem('rangeId', loginRes.responseData.rangeId);
    //       localStorage.setItem('subDivId', loginRes.responseData.subDivId);

    //     }
    //     this.router.navigateByUrl('/report');

    //   } else if (loginRes.code === 207) {
    //     this.toasterService.pop('Error', 'Error', 'Invalid user name or password ');
    //   }

    // });
  }
}

