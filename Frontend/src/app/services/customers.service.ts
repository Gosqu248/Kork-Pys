import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, map, Observable, of, tap } from 'rxjs';
import { Customer } from '../models/customer.model';
import { Router } from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class CustomersService {

  private apiUrl = 'http://localhost:8080/api/customers';
  private isAuthenticated = false; // Store the authentication status

  private currentUser: Customer | null = null;

  constructor(private http: HttpClient, private router: Router) {
    this.checkAuthenticationStatus(); // Check authentication status on service initialization
  }

  setCustomer(customer: Customer) {
    this.currentUser = customer;
    localStorage.setItem('currentUser', JSON.stringify(customer)); // Store user data in localStorage
  }

  getCustomer(): Customer | null {
    return this.currentUser;
  }

  getCustomerName(): string {
    return this.currentUser ? this.currentUser.name : '';
  }

  getCustomerId(): number | null {
    return this.currentUser ? this.currentUser.id : null;
  }

  authenticateUser(street: string, buildingNumber: string): Observable<boolean> {
    return this.http.get<Customer[]>(`${this.apiUrl}`).pipe(
      tap(customers => console.log('Customers data:', customers)),
      map(customers => customers.some(customer => {
        const customerStreet = customer.street.toLowerCase();
        const inputStreet = street.toLowerCase();
        const customerBuildingNumber = customer.buildingNumber;

        const authenticated = customerStreet === inputStreet && customerBuildingNumber === buildingNumber;
        if (authenticated) {
          this.isAuthenticated = true;
          localStorage.setItem('isAuthenticated', 'true'); // Store authentication state in localStorage
          this.setCustomer(customer);
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
    if (typeof window !== 'undefined') {
      const isAuthenticated = localStorage.getItem('isAuthenticated');
      this.isAuthenticated = isAuthenticated === 'true';
      if (this.isAuthenticated) {
        const storedUser = localStorage.getItem('currentUser');
        this.currentUser = storedUser ? JSON.parse(storedUser) : null;
      }
      return this.isAuthenticated;
    } else {
      this.router.navigate(['/logowanie']);
      console.log('localStorage is not available in this environment.');
      return false;
    }
  }

  logoutUser(): void {
    this.isAuthenticated = false;
    this.currentUser = null;
    localStorage.removeItem('isAuthenticated');
    localStorage.removeItem('currentUser'); // Clear user data from localStorage
    this.router.navigate(['/logowanie']);
  }
}
