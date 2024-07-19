import {Component, OnInit} from '@angular/core';
import {CustomerDataComponent} from "../customer-data/customer-data.component";
import {CustomerWelcomeComponent} from "../customer-welcome/customer-welcome.component";
import {CustomerMainComponent} from "../customer-main/customer-main.component";
import {AuthService} from "../../../services/auth.service";
import {CustomersService} from "../../../services/customers.service";
import {Customer} from "../../../models/customer.model";
import {of, switchMap} from "rxjs";
import {catchError} from "rxjs/operators";
import {InvoiceService} from "../../../services/invoice.service";

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
  invoices: any;

  constructor(private authService: AuthService, private customersService: CustomersService, private invoiceService: InvoiceService) {}

  ngOnInit(): void {
    this.fetchCustomerAndAuthenticate();
  }

  fetchCustomerAndAuthenticate(): void {
    this.authService.checkAuthenticationStatus().pipe(
      switchMap(isAuthenticated => {
        if (isAuthenticated) {
          const jwt = this.authService.getJwtToken();
          if (jwt) {
            return this.customersService.getCustomer(jwt).pipe(
              catchError(error => {
                console.error('Error fetching customer data', error);
                return of(undefined);
              }),
              switchMap(customer => {
                this.loggedInCustomer = customer;
                if (customer && customer.id) {
                  console.log(`Customer ID: ${customer.id}`); // Log customer ID
                  this.fetchInvoices(customer.id, jwt);
                }
                return of(undefined);
              })
            );
          }
        }
        return of(undefined);
      })
    ).subscribe();
  }

  fetchInvoices(customerId: number, jwt: string): void {
    this.invoiceService.getInvoicesByCustomerId(customerId, jwt).pipe(
      catchError(error => {
        console.error('Error fetching invoices', error);
        return of([]);
      })
    ).subscribe(invoices => {
      this.invoices = invoices;
      console.log('Fetched invoices:', invoices); // Log fetched invoices
    });
  }

}
