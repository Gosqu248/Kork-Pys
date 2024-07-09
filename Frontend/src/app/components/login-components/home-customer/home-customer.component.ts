import {Component, OnInit} from '@angular/core';
import {CustomerDataComponent} from "../customer-data/customer-data.component";
import {CustomerWelcomeComponent} from "../customer-welcome/customer-welcome.component";
import {CustomerMainComponent} from "../customer-main/customer-main.component";

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
export class HomeCustomerComponent {
  constructor() {}


}
