import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from '../models/customer.model';
import {ChangePasswordResponse} from '../interfaces/change-password-response';

@Injectable({
  providedIn: 'root'
})
export class CustomersService {
  private apiUrl = 'http://localhost:8080/api/customer';

  constructor(private http: HttpClient) {}
  getCustomer(jwt: string): Observable<Customer> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${jwt}`);
    return this.http.get<Customer>(`${this.apiUrl}`, { headers });
  }

  changePassword(email: string, currentPassword: string, newPassword: string): Observable<ChangePasswordResponse> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${sessionStorage.getItem('jwt')}`);
    return this.http.post<ChangePasswordResponse>(`${this.apiUrl}/change-password`, { email, currentPassword, newPassword }, { headers});
  }


}
