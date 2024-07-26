import {Component, Input, OnInit} from '@angular/core';
import {CustomersService} from "../../../services/customers.service";
import {Customer} from "../../../models/customer.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customer-data',
  standalone: true,
  imports: [],
  templateUrl: './customer-data.component.html',
  styleUrl: './customer-data.component.css'
})
export class CustomerDataComponent {

  @Input() customer: Customer | undefined = undefined;

  constructor(private router: Router) {
  }

  goToChangePassword(): void {
    this.router.navigate(['/zmiana-hasła'])
  }
}
