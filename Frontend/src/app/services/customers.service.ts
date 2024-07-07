import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, map, Observable, of, tap } from 'rxjs';
import { Customer } from '../models/customer.model';

@Injectable({
  providedIn: 'root'
})
export class CustomersService {

  private apiUrl = 'http://localhost:8080/api/customers';
  private isAuthenticated = false; // Store the authentication status

  constructor(private http: HttpClient) {}

  authenticateUser(street: string, buildingNumber: string): Observable<boolean> {
    return this.http.get<Customer[]>(`${this.apiUrl}`).pipe(
      tap(customers => console.log('Customers data:', customers)),
      map(customers => customers.some(customer => {
        const customerStreet = customer.street.toLowerCase();
        const inputStreet = street.toLowerCase();
        const customerBuildingNumber = customer.buildingNumber;

        const authenticated = customerStreet === inputStreet && customerBuildingNumber === buildingNumber;
        if (authenticated) {
          this.isAuthenticated = true; // Set the authentication status
          localStorage.setItem('isAuthenticated', 'true'); // Optional: Store in local storage
        }
        return authenticated;
      })),
      catchError(error => {
        console.error('Authentication error:', error);
        return of(false);
      })
    );
  }

  checkAuthenticationStatus(): boolean {
    // Optional: Check authentication status from local storage
    const storedStatus = localStorage.getItem('isAuthenticated');
    return this.isAuthenticated || storedStatus === 'true';
  }
}
