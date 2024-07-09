import {Component, OnInit} from '@angular/core';
import {CustomersService} from "../../../services/customers.service";
import {Customer} from "../../../models/customer.model";

@Component({
  selector: 'app-customer-data',
  standalone: true,
  imports: [],
  templateUrl: './customer-data.component.html',
  styleUrl: './customer-data.component.css'
})
export class CustomerDataComponent implements OnInit{

  customer: Customer | null=null;

  constructor(private customerService: CustomersService) { }

  ngOnInit(): void {
    this.customer = this.customerService.getCustomer();
  }
}
