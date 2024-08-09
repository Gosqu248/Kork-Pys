import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {InvoiceModel} from "../models/invoice.model";

@Injectable({
  providedIn: 'root'
})
export class InvoiceService {
  private apiUrl = 'http://localhost:8080/api/invoices';

  private invoices: InvoiceModel[] = [];

  constructor(private http: HttpClient) { }

  getInvoicesByCustomerId(street: string, buildingNumber: string, jwt: string): Observable<InvoiceModel[]> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${jwt}`);
    return this.http.get<InvoiceModel[]>(`${this.apiUrl}?street=${street}&buildingNumber=${buildingNumber}`, { headers });
  }



}
