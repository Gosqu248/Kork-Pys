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
  invoices: any[] = []; // Initialize as an empty array

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
            console.log('JWT:', jwt); // Log JWT token (sensitive information)
            return this.customersService.getCustomer(jwt).pipe(
              catchError(error => {
                console.error('Error fetching customer data', error);
                return of(undefined);
              }),
              switchMap(customer => {
                this.loggedInCustomer = customer;
                if (customer && customer.street && customer.buildingNumber) {
                  console.log(`Customer ID: ${customer.street} ${customer.buildingNumber}`); // Log customer ID
                  this.fetchInvoices(customer.street, customer.buildingNumber, jwt);
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

 fetchInvoices(street: string, buildingNumber: string, jwt: string): void {
  this.invoiceService.getInvoicesByCustomerId(street, buildingNumber, jwt).pipe(
    catchError(error => {
      console.error('Error fetching invoices', error);
      return of([]);
    })
  ).subscribe(invoices => {
    this.invoices = invoices.map((invoice: any) => {
      if (invoice.Number) {
        const numberParts = invoice.Number.split('/');
        const invoiceYear = `20${numberParts[1]}`;
        const invoiceMonthNumber = parseInt(numberParts[2], 10);
        const invoiceMonth = this.getMonthName(invoiceMonthNumber);
        console.log(`Invoice Number: ${invoice.number}, Year: ${invoiceYear}, Month: ${invoiceMonth}`);
        return {
          ...invoice,
          invoiceYear,
          invoiceMonth
        };
      } else {
        console.error('Invoice number is undefined');
        return {
          ...invoice,
          invoiceYear: 'Unknown',
          invoiceMonth: 'Unknown'
        };
      }
    }).reverse();
    console.log('Fetched invoices:', this.invoices);
  });
}

  getMonthName(monthNumber: number): string {
    const months = [
      'Styczeń',
      'Luty',
      'Marzec',
      'Kwiecień',
      'Maj',
      'Czerwiec',
      'Lipiec',
      'Sierpień',
      'Wrzesień',
      'Październik',
      'Listopad',
      'Grudzień'
    ];

    return months[monthNumber - 1];
  }
}
