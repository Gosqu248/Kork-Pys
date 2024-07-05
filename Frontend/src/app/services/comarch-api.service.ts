import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, map, Observable, of, tap} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class ComarchApiService {

  private apiUrl = 'http://localhost:8080/comarch-api';


  constructor(private http: HttpClient) { }

  authenticateUser(street: string, buildingNumber: string): Observable<boolean> {
    return this.http.get<any[]>(`${this.apiUrl}/customers`).pipe(
      tap(customers => console.log('Customers data:', customers)), // Log the customers data
      map(customers => customers.some(customer => {

        const customerStreet = customer?.Address.Street.toLowerCase(); // Convert to lower case
        const inputStreet = street.toLowerCase(); // Convert input street to lower case

        const customerBuildingNumber = customer?.Address.BuildingNumber;

        return customerStreet === inputStreet && customerBuildingNumber === buildingNumber;
      })),
      catchError(error => {
        console.error('Authentication error:', error);
        return of(false); // Return false in case of any error
      })
    );
  }
}
