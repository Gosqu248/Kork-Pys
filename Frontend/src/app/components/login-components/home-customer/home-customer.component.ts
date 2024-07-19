import {Component, OnInit} from '@angular/core';
import {CustomerDataComponent} from "../customer-data/customer-data.component";
import {CustomerWelcomeComponent} from "../customer-welcome/customer-welcome.component";
import {CustomerMainComponent} from "../customer-main/customer-main.component";
import {AuthService} from "../../../services/auth.service";
import {CustomersService} from "../../../services/customers.service";
import {Customer} from "../../../models/customer.model";
import {of, switchMap} from "rxjs";
import {catchError} from "rxjs/operators";

@Component({
  selector: 'app-home-user',
  standalone: true,
  imports: [
    CustomerDataComponent,
    CustomerWelcomeComponent,
    CustomerMainComponent
  ],
  templateUrl: './home-customer.component.html',
  styleUrl: './home-customer.component.css'
})
export class HomeCustomerComponent implements OnInit{
  loggedInCustomer: Customer | undefined = undefined;

  constructor(private authService: AuthService, private customersService: CustomersService, ) {}

  ngOnInit(): void {
    this.authService.checkAuthenticationStatus().pipe(
      switchMap(isAuthenticated => {
        if (isAuthenticated) {
          const jwt = this.authService.getJwtToken();
          if (jwt) {
            console.log(jwt)
            return this.customersService.getLoggedInCustomer(jwt).pipe(
              catchError(error => {
                console.error('Error fetching customer data', error);
                return of(undefined);
              })
            );
          }
        }
        return of(undefined);
      })
    ).subscribe(customer => {
      this.loggedInCustomer = customer;
    });
  }
}
