import {Component, Input, OnInit} from '@angular/core';
import {CustomersService} from "../../../services/customers.service";
import {Customer} from "../../../models/customer.model";

@Component({
  selector: 'app-customer-data',
  standalone: true,
  imports: [],
  templateUrl: './customer-data.component.html',
  styleUrl: './customer-data.component.css'
})
export class CustomerDataComponent {

  @Input() customer: Customer | undefined = undefined;

}
