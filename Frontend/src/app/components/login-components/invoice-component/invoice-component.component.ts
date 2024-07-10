import {Component, Input} from '@angular/core';
import {NgStyle} from "@angular/common";
import jsPDF from "jspdf";


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
    event.stopPropagation(); // Zapobiega wywołaniu toggleHeight()

    if (this.image != null) {
      const pdf = new jsPDF();

      const img = new Image();
      img.src = this.image;
      img.onload = () => {
        const width = pdf.internal.pageSize.getWidth();
        const height = pdf.internal.pageSize.getHeight();
        console.log("XD")

        // Dodanie obrazu do PDF, skalując go do rozmiarów strony PDF
        pdf.addImage(img, 'JPEG', 0, 0, width, height);

        // Pobranie PDF z wyznaczoną nazwą
        pdf.save(`Faktura/${this.month}/${this.year}.pdf`); // Możesz ustawić pożądaną nazwę pliku tutaj
      };
    }
  }
}
