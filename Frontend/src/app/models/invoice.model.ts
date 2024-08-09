export interface InvoiceModel {
  id: number;
  netTotal: number;
  currencyNetTotal: number;
  grossTotal: number;
  currencyGrossTotal: number;
  vatTotal: number;
  currencyVatTotal: number;
  currencyCode: string;
  currencyRateType: number;
  currencyRateDate: string;
  currencyConverter: number;
  currencyRate: number;
  paymentStatus: number;
  ossProcedureCountryCode: string;
  isOSSProcedure: boolean;
  isFinal: boolean;
  purchasingParty: PurchasingParty;
  paymentTypeId: number;
  paymentType: number;
  paymentDeadline: string;
  bankAccountId: number | null;
  bankAccountNumber: string | null;
  salesDate: string;
  invoiceType: number;
  items: Item[];
  description: string | null;
  issueDate: string;
  number: string;
  status: number;
}

export interface PurchasingParty {
  name: string;
  nipPrefix: string;
  nip: string;
  country: string;
  city: string;
  street: string;
  buildingNumber: string;
  flatNumber: string;
  bankName: string;
  bankAccountNumber: string;
  customerType: number;
}

export interface Item {
  id: number;
  productId: number;
  quantity: number;
  productCurrencyPrice: number;
  productPrice: number;
  productName: string;
  productDescription: string;
  unitOfMeasurement: string;
  vatRateId: number;
}
