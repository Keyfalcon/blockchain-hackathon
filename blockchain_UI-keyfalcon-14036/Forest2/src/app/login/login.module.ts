import { NgModule } from '@angular/core';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {FormControl,FormGroup} from '@angular/forms';
import { LoginComponent } from './login.component';
import { LoginRoutingModule } from './login-routing.module';
import {
  ToasterModule,
  ToasterService,
  ToasterConfig
} from 'angular2-toaster/angular2-toaster';

@NgModule({
  imports: [
    LoginRoutingModule,FormsModule,ReactiveFormsModule,ToasterModule
  ],
  declarations: [ LoginComponent ],
  providers:[ToasterService]
})
export class LoginModule { }
