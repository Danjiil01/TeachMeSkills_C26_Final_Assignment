package com.teachmeskills.finalassigment.filehandling;

public class Receipt extends Document {
    private String payer;
    private String recipient;
    private double amount;

    public Receipt(String documentNumber, String date, String issuedBy,
                   String payer, String recipient, double amount) {
        super(documentNumber, date, issuedBy);
        this.payer = payer;
        this.recipient = recipient;
        this.amount = amount;
    }

    public String getPayer() {
        return payer;
    }

    public String getRecipient() {
        return recipient;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public void printInfo() {
        System.out.println("Receipt information:");
        System.out.println("Document Number: " + getDocumentNumber());
        System.out.println("Date: " + getDate());
        System.out.println("Issued By: " + getIssuedBy());
        System.out.println("Payer: " + getPayer());
        System.out.println("Recipient: " + getRecipient());
        System.out.println("Amount: " + getAmount());
    }
}
