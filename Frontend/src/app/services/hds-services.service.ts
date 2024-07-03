import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {HdsServicesModel} from "../models/hds-services.model";

@Injectable({
  providedIn: 'root'
})
export class HdsServicesService {
  private apiUrl = 'http://localhost:8080/api/hds-services'; // Replace with the actual URL of your API

  constructor(private http: HttpClient) { }

  getHdsServices(): Observable<HdsServicesModel[]> {
    return this.http.get<HdsServicesModel[]>(this.apiUrl);
  }
}
