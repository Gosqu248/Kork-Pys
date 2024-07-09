import {Component, OnInit} from '@angular/core';
import {CustomersService} from "../../../services/customers.service";

@Component({
  selector: 'app-customer-welcome',
  standalone: true,
  imports: [],
  templateUrl: './customer-welcome.component.html',
  styleUrl: './customer-welcome.component.css'
})
export class CustomerWelcomeComponent implements OnInit{

  name: string = '';

  constructor(private customerService: CustomersService) {
  }

  ngOnInit() {
    this.name = this.customerService.getCustomerName();
  }
}
