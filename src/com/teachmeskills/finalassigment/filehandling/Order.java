package com.teachmeskills.finalassigment.filehandling;

public class Order extends Document {
    private String customer;
    private String product;
    private int quantity;

    public Order(String documentNumber, String date, String issuedBy,
                 String customer, String product, int quantity) {
        super(documentNumber, date, issuedBy);
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    public String getCustomer() {
        return customer;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public void printInfo() {
        System.out.println("Order information:");
        System.out.println("Document Number: " + getDocumentNumber());
        System.out.println("Date: " + getDate());
        System.out.println("Issued By: " + getIssuedBy());
        System.out.println("Customer: " + getCustomer());
        System.out.println("Product: " + getProduct());
        System.out.println("Quantity: " + getQuantity());
    }
}