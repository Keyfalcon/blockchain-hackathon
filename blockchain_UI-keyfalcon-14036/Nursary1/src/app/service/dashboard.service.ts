import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/Rx';
import { AppConstants } from './constants';
import {Nersary} from '../nursery/nersary'
@Injectable()
export class DashboardService {
  json: string;
constructor(private http: Http) { }


getAllFarmers() {
  const headers = new Headers;
  headers.append('Content-Type', 'application/json');
  headers.append('Access-Control-Allow-Origin', '*');
  return this.http.get(AppConstants.base_url + AppConstants.farmer.base + AppConstants.farmer.getAllFarmers , { headers })
    .map((res: Response) =>  {
      if(res.status != 200) {
        throw new Error('No comments to retrieve! code status ' + res.status);
      } else {
        return res.json();
      }
    });
}

getAllFarmersByStatus(status) {
  const headers = new Headers;
  headers.append('Content-Type', 'application/json');
  headers.append('Access-Control-Allow-Origin', '*');
  const body = JSON.stringify({status: status,
    });

  return this.http.post(AppConstants.base_url + AppConstants.farmer.base + AppConstants.farmer.getAllFarmersByStatus , body, { headers  })
    .map((res: Response) =>  {
      if(res.status != 200) {
        throw new Error('No comments to retrieve! code status ' + res.status);
      } else {
        return res.json();
      }
    });
}

registerFormer(about: 'string' , address: 'string',
availablePlants: 'string',
city: 'string',
email: 'string',
experience: number,
mobile: 'string',
name: 'string',
password: 'string',
pincode: 'string') {
  const headers = new Headers;
  headers.append('Content-Type', 'application/json');
  headers.append('Access-Control-Allow-Origin', '*');
  const body = JSON.stringify({about: about , address: address,
  availablePlants: availablePlants,
  city: city,
  email: email,
  experience: experience,
  mobile: mobile,
  name: name,
  password: password,
  pincode: pincode
    });

  return this.http.post(AppConstants.base_url + AppConstants.nursery.base + AppConstants.nursery.registerNursery , body, { headers  })
    .map((res: Response) =>  {
      if(res.status != 200) {
        throw new Error('No comments to retrieve! code status ' + res.status);
      } else {
        return res.json();
      }
    });
}






}
