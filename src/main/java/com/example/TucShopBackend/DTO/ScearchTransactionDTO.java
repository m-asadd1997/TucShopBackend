package com.example.TucShopBackend.DTO;

public class    ScearchTransactionDTO {
    String dateFrom;
    String dateTill;
    String user;

    public ScearchTransactionDTO() {
    }

    public ScearchTransactionDTO(String dateFrom, String dateTill, String user) {
        this.dateFrom = dateFrom;
        this.dateTill = dateTill;
        this.user = user;

    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTill() {
        return dateTill;
    }

    public void setDateTill(String dateTill) {
        this.dateTill = dateTill;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
