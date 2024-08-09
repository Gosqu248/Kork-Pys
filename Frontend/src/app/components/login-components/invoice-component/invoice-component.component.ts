import {Component, Input} from '@angular/core';
import {NgStyle} from "@angular/common";
import {jsPDF} from "jspdf";
import {HttpClient} from "@angular/common/http";
import robotoBold from "../../../../../assets/fonts/Roboto-bold"
import robotoRegular from "../../../../../assets/fonts/Roboto-regular";


@Component({
  selector: 'app-invoice-component',
  standalone: true,
  imports: [
    NgStyle,
  ],
  templateUrl: './invoice-component.component.html',
  styleUrl: './invoice-component.component.css'
})
export class InvoiceComponentComponent {
  @Input() invoice?: any;
  isDynamicElementsVisible: boolean = false; // Define the variable here
  @Input() postalCode?: string | undefined;

  constructor(private http: HttpClient) {}

  toggleHeight(): void {
    this.isDynamicElementsVisible = !this.isDynamicElementsVisible;
  }


  generatePDF(): void {
    if (!this.invoice) {
      console.error('No invoice data provided');
      return;
    }

    const doc = new jsPDF();

    const robotoRegular64 = robotoRegular;
    const robotoBold64 = robotoBold;


    doc.addFileToVFS('Roboto-Regular.ttf', robotoRegular64);
    doc.addFont('Roboto-Regular.ttf', 'Roboto', 'normal');
    doc.addFileToVFS('Roboto-Bold.ttf', robotoBold64);
    doc.addFont('Roboto-Bold.ttf', 'RobotoBold', 'normal');
    doc.setCharSpace(0.25);



    // Sprzedawca
    doc.setFontSize(11);
    doc.setFont('RobotoBold', 'normal');
    doc.text('Sprzedawca:', 166.7, 18.5);
    doc.setFont('Roboto', 'normal');
    doc.setFontSize(10);
    doc.setCharSpace(0.0);
    doc.text('Wojciech Nowak Usługi Remontowo-Budowlane', 116.5, 24.6);
    doc.setCharSpace(0.03);
    doc.text('"KORK-PYŚ"', 172.3, 30.6);
    doc.text('Wesołów 247', 169.9, 36.5);

    doc.setCharSpace(0.1);
    doc.text('32-840 Zakliczyn', 163.5, 42.2);
    doc.text('NIP: 8732956587', 163, 48);
    doc.setCharSpace(0.065);
    doc.text('Nr rachunku: 46114020040000310248932332', 116.8, 53.7);

    doc.setDrawColor(211, 211, 211);
    doc.setLineWidth(0.15);
    doc.line(15, 64.9, 193, 64.9);

    // Faktura VAT
    doc.setFontSize(21.2);
    doc.text('FAKTURA VAT', 16.1, 75.9);

    doc.setFontSize(10);
    doc.text(`Numer dokumentu: ${this.invoice.Number}`, 142, 70);

    doc.setFontSize(7.9);
    doc.text(`Data wystawienia:   ${this.formatDate(new Date(this.invoice.IssueDate))}`, 152.5, 74.5);

    doc.setLineWidth(0.04)
    doc.text(`Data dostawy/wykonania usługi:   ${this.formatDate(new Date(this.invoice.SalesDate))}`, 134, 78.7);

    doc.setDrawColor(211, 211, 211);
    doc.setLineWidth(0.15);
    doc.line(15, 80.8, 193, 80.8);

    // Nabywca
    doc.setFont('RobotoBold', 'normal')
    doc.setFontSize(12);
    doc.text('Nabywca:', 15.9, 94);

    doc.setFontSize(10);
    doc.setFont('Roboto', 'normal');
    doc.text(this.invoice.PurchasingParty.Name, 15.9, 99.8);
    doc.text(`${(this.invoice.PurchasingParty.Street)} ${this.invoice.PurchasingParty.BuildingNumber}`, 15.9, 105.5);
    doc.text(`${this.postalCode} ${this.invoice.PurchasingParty.City}`, 15.9, 110);

    doc.setDrawColor(0, 0, 0);
    doc.setLineWidth(0.15);
    doc.line(15, 119.5, 193, 119.5);


    doc.setFont('RobotoBold', 'normal');
    doc.setFontSize(7.7);
    doc.setCharSpace(0.18);
    doc.text('Lp.', 16.2, 123.3);
    doc.text('Nazwa towaru/usługi', 23.3, 123.3);
    doc.text("PKWiU", 99, 123.3);
    doc.text('Ilość', 123, 123.3);
    doc.text('j.m.', 132.5, 123.3);
    doc.text('Cena brutto', 141.5, 123.3);
    doc.text('VAT', 160.8, 123.3);
    doc.text('Wartość brutto', 171.2, 123.3);

    doc.setDrawColor(211, 211, 211);
    doc.setLineWidth(0.15);
    doc.line(15, 125, 193, 125);


    doc.setFont('Roboto', 'normal');
    doc.setFontSize(7);
    doc.text('1.', 18.2, 128.5);

    const maxWidth: number = 75;
    const productName: string = this.invoice.Items[0].ProductName;
    const splitText = doc.splitTextToSize(productName, maxWidth);
    doc.text(splitText, 23.3, 128.5);

    doc.text(`${this.toFour(this.invoice.Items[0].Quantity)}`, 121, 128.5);
    doc.text(`${this.invoice.Items[0].UnitOfMeasurement}`, 132.7, 128.5);

    doc.setFontSize(7.5);
    doc.text(`${this.toDouble(this.invoice.Items[0].ProductPrice)}`, 149, 128.5);
    doc.text(`${this.invoice.Items[0].VatRateId}%`, 161.4, 128.5);
    doc.text(`${this.toDouble(this.invoice.Items[0].ProductCurrencyPrice)}`, 183, 128.5);

    const splitlength = splitText.length;
    const addY = splitlength === 1 ? 0 : splitlength === 2 ? 2.8 : splitlength === 3 ? 5.6 : 8.4;

    doc.setDrawColor(0, 0, 0);
    doc.setLineWidth(0.2);
    doc.line(15, 130.2 + addY, 193, 130.2 + addY);

    doc.setFontSize(7.7);
    doc.setFont('RobotoBold', 'normal');
    doc.text("Forma płatności", 17.2, 138.2 + addY);
    doc.text("Termin płatności", 45.5, 138.2 + addY);
    doc.text("Kwota do zapłaty", 77, 138.2 + addY);
    doc.text("VAT", 118.5, 138.2 + addY);
    doc.text("Wartość netto", 127.5, 138.2 + addY);
    doc.text("Kwota VAT", 150.5, 138.2 + addY);
    doc.text("Wartość brutto", 169.5, 138.2 + addY);

    doc.setDrawColor(0, 0, 0);
    doc.setLineWidth(0.25);
    doc.line(14.5, 139.7 + addY, 101.7, 139.7 + addY);

    doc.setDrawColor(0, 0, 0);
    doc.setLineWidth(0.22);
    doc.line(105.3, 139.7 + addY, 192.5, 139.7 + addY);

    const paymentType: string = this.invoice.PaymentType === 0
      ? 'Gotówka'
      : this.invoice.PaymentType === 1
        ? 'Przelew'
        : 'Karta';

    doc.setFontSize(7.5);
    doc.setFont('Roboto', 'normal')
    doc.setCharSpace(0.13);

    doc.text(paymentType, 23, 143.4 + addY);
    doc.text(this.formatDate(new Date(this.invoice.PaymentDeadline)), 49.8, 143.4 + addY);
    doc.text(this.toDouble(this.invoice.GrossTotal), 91.8, 143.4 + addY);

    doc.text("W tym:", 107, 143.4 + addY);
    doc.text(`${this.invoice.Items[0].VatRateId}%`, 119.3, 143.4 + addY);
    doc.text(`${this.toDouble(this.invoice.CurrencyNetTotal)}`, 139, 143.4 + addY);
    doc.text(`${this.toDouble(this.invoice.CurrencyVatTotal)}`, 159.7, 143.4 + addY);
    doc.text(`${this.toDouble(this.invoice.CurrencyGrossTotal)}`, 182.7, 143.4 + addY);

    doc.setFontSize(7.8);
    doc.setFont('RobotoBold', 'normal');
    doc.text("Suma:", 107.5, 148.5 + addY);
    doc.text(`${this.toDouble(this.invoice.CurrencyNetTotal)}`, 138.2, 148.5 + addY);
    doc.text(`${this.toDouble(this.invoice.CurrencyVatTotal)}`, 159.1, 148.5 + addY);
    doc.text(`${this.toDouble(this.invoice.CurrencyGrossTotal)}`, 182, 148.5 + addY);

    doc.setFontSize(15);
    doc.setCharSpace(0.17);
    doc.setFont('Roboto', 'normal');
    doc.text("Razem do zapłaty:", 114.7, 169.4 + addY);
    doc.text(`${this.toDouble(this.invoice.CurrencyGrossTotal)} PLN`, 163, 169.4 + addY);

    doc.setCharSpace(0.1);
    doc.setFontSize(7.2);
    const text = `Słownie: ${this.convertToWords(this.toDouble(this.invoice.CurrencyGrossTotal))}`;
    const textWidth = doc.getTextWidth(text);
    const endPosition = 189.8; // Adjust this to your desired end position
    const xPosition = endPosition - textWidth;
    doc.text(text, xPosition, 174.2 + addY);

    let payed: string;
    let notpayed: string;

    if(this.invoice.PaymentStatus === 1) {
      payed = `Zapłacono: ${this.toDouble(this.invoice.CurrencyGrossTotal)} PLN`;
      notpayed = `Pozostaje do zapłaty: 0,00 PLN`;
    } else {
      payed = `Zapłacono: 0,00 PLN`;
      notpayed = `Pozostaje do zapłaty: ${this.toDouble(this.invoice.CurrencyGrossTotal)} PLN`;
    }

    const notpayedWidth = doc.getTextWidth(notpayed);
    const notpayedEndPosition = 189.8; // Adjust this to your desired end position
    const notpayedXPosition = notpayedEndPosition - notpayedWidth;

    doc.text(payed, 16.2, 179.2 + addY);
    doc.text(notpayed, notpayedXPosition, 179.2 + addY);

    doc.setDrawColor(0, 0, 0);
    doc.setLineWidth(0.18);
    doc.line(15, 180.2 + addY, 193, 180.2 + addY);

    doc.setFont('RobotoBold', 'normal');
    doc.setFontSize(7.8);
    doc.setCharSpace(0.15);
    doc.text("Wojciech Nowak", 37.5, 188.7 + addY);

    doc.setCharSpace(0.1);
    doc.setFontSize(7.2);
    doc.setFont('Roboto', 'normal');

    doc.setDrawColor(0, 0, 0);
    doc.setLineWidth(0.25);
    doc.line(15, 190.7 + addY, 82.3, 190.7 + addY);

    doc.setDrawColor(0, 0, 0);
    doc.setLineWidth(0.2);
    doc.line(102, 190.7 + addY, 123.5, 190.7 + addY);

    doc.setDrawColor(0, 0, 0);
    doc.setLineWidth(0.25);
    doc.line(130.5, 190.7 + addY, 193, 190.7 + addY);

    doc.text("Podpis osoby upoważnionej do wystawienia faktury", 17.7, 193.4 + addY);
    doc.text("Data odbioru", 104.8, 193.4 + addY);
    doc.text("Podpis osoby upoważnionej do odbioru faktury", 132.8, 193.4 + addY);

    doc.text("Strona 1/1", 179, 284.2);

 



    doc.save(`Faktura_${this.invoice.invoiceMonth}_${this.invoice.invoiceYear}.pdf`);
    };



    formatDate = (date: Date) => date.toLocaleDateString('pl-PL', {
      day: '2-digit',
      month: '2-digit',
      year: 'numeric'
    }).replace(/\./g, '-').split('-').reverse().join('-');


    toFour(value: number): string {
      return value.toFixed(4).replace('.', ',');
    }

    toDouble(value: number): string {
      return value.toFixed(2).replace('.', ',');
    }

   units: string[] = ["", "jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć"];
   teens: string[] = ["dziesięć", "jedenaście", "dwanaście", "trzynaście", "czternaście", "piętnaście", "szesnaście", "siedemnaście", "osiemnaście", "dziewiętnaście"];
   tens: string[] = ["", "", "dwadzieścia", "trzydzieści", "czterdzieści", "pięćdziesiąt", "sześćdziesiąt", "siedemdziesiąt", "osiemdziesiąt", "dziewięćdziesiąt"];
   hundreds: string[] = ["", "sto", "dwieście", "trzysta", "czterysta", "pięćset", "sześćset", "siedemset", "osiemset", "dziewięćset"];

   numberToWords(num: number): string {
    if (num === 0) return "zero";

    let words = "";

    if (num >= 100) {
      words += this.hundreds[Math.floor(num / 100)] + " ";
      num %= 100;
    }

    if (num >= 20) {
      words += this.tens[Math.floor(num / 10)] + " ";
      num %= 10;
    } else if (num >= 10) {
      words += this.teens[num - 10] + " ";
      num = 0;
    }

    if (num > 0) {
      words += this.units[num] + " ";
    }

    return words.trim();
  }

   convertToWords(value: string): string {
    const [integerPart, fractionalPart] = value.split(",");
    const integerNumber = parseInt(integerPart, 10);
    const fractionalNumber = parseInt(fractionalPart, 10);

    const integerWords = this.numberToWords(integerNumber);
    const fractionalWords = fractionalNumber > 0 ? `${fractionalNumber}/100` : "0/100";

    return `${integerWords} PLN ${fractionalWords}`;
  }

}
