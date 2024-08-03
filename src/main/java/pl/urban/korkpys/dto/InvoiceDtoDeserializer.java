package pl.urban.korkpys.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDtoDeserializer extends StdDeserializer<InvoiceDto> {

    public InvoiceDtoDeserializer() {
        this(null);
    }

    public InvoiceDtoDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public InvoiceDto deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);

        InvoiceDto invoice = new InvoiceDto();
        invoice.setNetTotal(node.get("netTotal").asDouble());
        invoice.setCurrencyNetTotal(node.get("currencyNetTotal").asDouble());
        invoice.setGrossTotal(node.get("grossTotal").asDouble());
        invoice.setCurrencyGrossTotal(node.get("currencyGrossTotal").asDouble());
        invoice.setVatTotal(node.get("vatTotal").asDouble());
        invoice.setCurrencyVatTotal(node.get("currencyVatTotal").asDouble());
        invoice.setCurrencyCode(node.get("currencyCode").asText());
        invoice.setCurrencyRateType(node.get("currencyRateType").asInt());
        invoice.setCurrencyRateDate(OffsetDateTime.parse(node.get("currencyRateDate").asText()));
        invoice.setCurrencyConverter(node.get("currencyConverter").asDouble());
        invoice.setCurrencyRate(node.get("currencyRate").asDouble());
        invoice.setPaymentStatus(node.get("paymentStatus").asInt());
        invoice.setOssProcedureCountryCode(node.get("ossProcedureCountryCode").asText(""));
        invoice.setOssProcedure(node.get("isOssProcedure").asBoolean());
        invoice.setFinal(node.get("isFinal").asBoolean());

        if (node.has("purchasingParty")) {
            JsonNode purchasingPartyNode = node.get("purchasingParty");
            InvoiceDto.PartyDto purchasingParty = new InvoiceDto.PartyDto();
            purchasingParty.setName(purchasingPartyNode.get("name").asText());
            purchasingParty.setNipPrefix(purchasingPartyNode.get("nipPrefix").asText(""));
            purchasingParty.setNip(purchasingPartyNode.get("nip").asText());
            purchasingParty.setCountry(purchasingPartyNode.get("country").asText());
            purchasingParty.setCity(purchasingPartyNode.get("city").asText());
            purchasingParty.setStreet(purchasingPartyNode.get("street").asText());
            purchasingParty.setBuildingNumber(purchasingPartyNode.get("buildingNumber").asText());
            purchasingParty.setFlatNumber(purchasingPartyNode.get("flatNumber").asText(""));
            purchasingParty.setBankName(purchasingPartyNode.get("bankName").asText(""));
            purchasingParty.setBankAccountNumber(purchasingPartyNode.get("bankAccountNumber").asText());
            purchasingParty.setCustomerType(purchasingPartyNode.get("customerType").asInt());
            invoice.setPurchasingParty(purchasingParty);
        }

        invoice.setPaymentTypeId(node.get("paymentTypeId").asInt());
        invoice.setPaymentType(node.get("paymentType").asInt());
        invoice.setPaymentDeadline(OffsetDateTime.parse(node.get("paymentDeadline").asText()));
        invoice.setBankAccountId(node.get("bankAccountId").isNull() ? null : node.get("bankAccountId").asLong());
        invoice.setBankAccountNumber(node.get("bankAccountNumber").isNull() ? null : node.get("bankAccountNumber").asText());
        invoice.setSalesDate(OffsetDateTime.parse(node.get("salesDate").asText()));
        invoice.setInvoiceType(node.get("invoiceType").asInt());

        List<InvoiceDto.InvoiceItemDto> items = new ArrayList<>();
        if (node.has("items")) {
            for (JsonNode itemNode : node.get("items")) {
                InvoiceDto.InvoiceItemDto item = new InvoiceDto.InvoiceItemDto();
                item.setProductId(itemNode.get("productId").asLong());
                item.setQuantity(itemNode.get("quantity").asDouble());
                item.setProductCurrencyPrice(itemNode.get("productCurrencyPrice").asDouble());
                item.setProductPrice(itemNode.get("productPrice").asDouble());
                item.setProductName(itemNode.get("productName").asText());
                item.setProductDescription(itemNode.get("productDescription").asText(""));
                item.setUnitOfMeasurement(itemNode.get("unitOfMeasurement").asText());
                item.setVatRateId(itemNode.get("vatRateId").asInt());
                item.setId(itemNode.get("id").asLong());
                items.add(item);
            }
        }
        invoice.setItems(items);

        invoice.setDescription(node.get("description").isNull() ? null : node.get("description").asText());
        invoice.setIssueDate(OffsetDateTime.parse(node.get("issueDate").asText()));
        invoice.setNumber(node.get("number").asText());
        invoice.setStatus(node.get("status").asInt());
        invoice.setId(node.get("id").asLong());

        return invoice;
    }
}