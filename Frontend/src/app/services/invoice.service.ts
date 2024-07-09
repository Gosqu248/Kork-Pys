import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {InvoiceModel} from "../models/invoice.model";

@Injectable({
  providedIn: 'root'
})
export class InvoiceService {
  private apiUrl = 'http://localhost:8080/api/invoices';

  private invoices: InvoiceModel[] = [];

  constructor(private http: HttpClient) { }

  getInvoicesByCustomerId(customerId: number): Observable<InvoiceModel[]> {
    return this.http.get<InvoiceModel[]>(`${this.apiUrl}?customerId=${customerId}`);
  }

  getInvoices() {
    return this.invoices;
  }


}
