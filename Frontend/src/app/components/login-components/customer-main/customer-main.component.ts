import {Component, Input, OnInit} from '@angular/core';
import { InvoiceService } from "../../../services/invoice.service";
import { CustomersService } from "../../../services/customers.service";
import { InvoiceComponentComponent } from "../invoice-component/invoice-component.component";
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import {Customer} from "../../../models/customer.model";
import {AuthService} from "../../../services/auth.service";

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

  @Input() invoices: any;

}
