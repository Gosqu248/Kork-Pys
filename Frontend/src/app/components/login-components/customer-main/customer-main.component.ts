import {Component, OnInit} from '@angular/core';
import {InvoiceService} from "../../../services/invoice.service";
import {CustomersService} from "../../../services/customers.service";
import {InvoiceComponentComponent} from "../invoice-component/invoice-component.component";
import { CommonModule } from '@angular/common';

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
export class CustomerMainComponent implements OnInit{

  public customer_id: number | null = null;
  public invoices: any;

  constructor(private customerService: CustomersService, private invoiceService: InvoiceService) {}

  ngOnInit() {
    this.customer_id = this.customerService.getCustomerId();
    if(this.customer_id != null){
      this.invoiceService.getInvoicesByCustomerId(this.customer_id).subscribe(data => {
        this.invoices = data;
      });
    }
  }

}
