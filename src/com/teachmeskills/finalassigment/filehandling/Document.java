package com.teachmeskills.finalassigment.filehandling;

public abstract class Document {
    private String documentNumber;
    private String date;
    private String issuedBy;

    public Document(String documentNumber, String date, String issuedBy) {
        this.documentNumber = documentNumber;
        this.date = date;
        this.issuedBy = issuedBy;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getDate() {
        return date;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public abstract void printInfo();
}