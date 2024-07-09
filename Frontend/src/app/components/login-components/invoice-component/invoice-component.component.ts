import {Component, Input} from '@angular/core';
import {NgStyle} from "@angular/common";

@Component({
  selector: 'app-invoice-component',
  standalone: true,
  imports: [
    NgStyle
  ],
  templateUrl: './invoice-component.component.html',
  styleUrl: './invoice-component.component.css'
})
export class InvoiceComponentComponent {
  @Input() image?: string;
  @Input() month?: string;
  @Input() year?: string;
  isDynamicElementsVisible: boolean = false; // Define the variable here

  constructor() {}

  toggleHeight(): void {
    this.isDynamicElementsVisible = !this.isDynamicElementsVisible;
  }

  downloadImage(event: Event) {
    event.stopPropagation(); // Prevent the toggleHeight() method from being called

    const link = document.createElement('a');
    if(this.image != null) {
      link.href = this.image;
      link.download = 'invoice.jpg'; // You can set the desired file name here
      link.click();
    }
  }

}
