import {Component, Input, OnInit} from '@angular/core';
import { InvoiceService } from "../../../services/invoice.service";
import { CustomersService } from "../../../services/customers.service";
import { InvoiceComponentComponent } from "../invoice-component/invoice-component.component";
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import {Customer} from "../../../models/customer.model";

@Component({
  selector: 'app-customer-main',
  standalone: true,
  imports: [
    InvoiceComponentComponent,
    CommonModule
  ],
  templateUrl: './customer-main.component.html',
  styleUrl: './customer-main.component.css'
})
export class CustomerMainComponent {

  @Input() customerId: number | undefined = undefined;

  public invoices: any;

  // ngOnInit() {
  //   const customerId = +this.route.snapshot.params['customerId']; // Convert to number with +
  //   this.customerService.getCustomerById(customerId).subscribe(customer => {
  //     this.customer_id = customer.id;
  //   });
  //   if (this.customer_id != null) {
  //     this.invoiceService.getInvoicesByCustomerId(this.customer_id).subscribe(data => {
  //       this.invoices = data;
  //     });
  //   }
  // }
}
