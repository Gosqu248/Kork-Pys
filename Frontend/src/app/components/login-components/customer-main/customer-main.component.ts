import {Component, Input, OnInit} from '@angular/core';
import { InvoiceComponentComponent } from "../invoice-component/invoice-component.component";
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
export class CustomerMainComponent {

  @Input() invoices: any;

}
