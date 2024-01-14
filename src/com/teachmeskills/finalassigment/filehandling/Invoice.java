package com.teachmeskills.finalassigment.filehandling;

public class Invoice extends Document {
    private String seller;
    private String buyer;
    private double amount;

    public Invoice(String documentNumber, String date, String issuedBy,
                   String seller, String buyer, double amount) {
        super(documentNumber, date, issuedBy);
        this.seller = seller;
        this.buyer = buyer;
        this.amount = amount;
    }

    public String getSeller() {
        return seller;
    }

    public String getBuyer() {
        return buyer;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public void printInfo() {
        System.out.println("Invoice information:");
        System.out.println("Document Number: " + getDocumentNumber());
        System.out.println("Date: " + getDate());
        System.out.println("Issued By: " + getIssuedBy());
        System.out.println("Seller: " + getSeller());
        System.out.println("Buyer: " + getBuyer());
        System.out.println("Amount: " + getAmount());
    }
}