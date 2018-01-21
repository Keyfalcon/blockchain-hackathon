import { Injectable } from '@angular/core';
import { CanActivate, CanActivateChild } from '@angular/router';
import { Router, ActivatedRouteSnapshot } from '@angular/router';

@Injectable()
export class AuthGuard implements CanActivate, CanActivateChild {

  constructor(private router: Router) { }
  canActivate(route: ActivatedRouteSnapshot): boolean {
    // console.log('i am checking to see if you are logged in');



    if (localStorage.getItem('user') != null) {

    //   const roles = route.data['roles'] as Array<string>;

    //   if (roles[0] === localStorage.getItem('userstatus')) {
    //     return true;
    //   } else if (roles[1] === localStorage.getItem('userstatus')) {
    //     return true;
    //   }

      return true;
    } else {
      // console.log('i am checking to see if you are logged in');
      // this.router.navigateByUrl('/login');
      return false;
    }

  }

  canActivateChild() {
    console.log('checking child route access');
    return true;
  }

}