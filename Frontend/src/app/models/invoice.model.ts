export interface InvoiceModel {
  id: number;
  image: String;
  month: number | string;
  year: number;
  customer_id: number| null;
}
