import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {EcoServicesModel} from "../models/eco-services.model";

@Injectable({
  providedIn: 'root'
})
export class EcoServicesService {
  private apiUrl = 'http://localhost:8080/api/eco-services'; // Replace with the actual URL of your API

  constructor(private http: HttpClient) { }

  getEcoServices(): Observable<EcoServicesModel[]> {
    return this.http.get<EcoServicesModel[]>(this.apiUrl);
  }
}
