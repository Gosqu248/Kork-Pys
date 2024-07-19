import {Component, Input, OnInit} from '@angular/core';
import {CustomersService} from "../../../services/customers.service";
import {ActivatedRoute} from "@angular/router";
import {Customer} from "../../../models/customer.model";

@Component({
  selector: 'app-customer-welcome',
  standalone: true,
  imports: [],
  templateUrl: './customer-welcome.component.html',
  styleUrl: './customer-welcome.component.css'
})
export class CustomerWelcomeComponent {


  @Input() customerName: string | undefined = undefined;

}
