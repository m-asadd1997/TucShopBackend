package com.example.TucShopBackend.DTO;

import java.time.LocalDate;

public class ProfitDTO {

    LocalDate date;
    double profit;


    public ProfitDTO(){

    }


    public ProfitDTO(LocalDate date, double profit) {
       this.date = date;
        this.profit = profit;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
