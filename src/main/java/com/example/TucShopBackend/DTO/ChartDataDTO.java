package com.example.TucShopBackend.DTO;

import java.time.LocalDate;
import java.util.List;

public class ChartDataDTO {

    List<String> labels;
    List<Double> series;
    List<Double> amounts;


    public List<Double> getAmounts() {
        return amounts;
    }

    public void setAmounts(List<Double> amounts) {
        this.amounts = amounts;
    }

    List<LocalDate> dates;

    public ChartDataDTO() {
    }

    public ChartDataDTO(List<String> labels, List<Double> series,List<LocalDate> dates,List<Double>amounts ){
        this.labels = labels;
        this.series = series;
        this.dates=dates;
        this.amounts=amounts;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<Double> getSeries() {
        return series;
    }

    public void setSeries(List<Double> series) {
        this.series = series;
    }

    public List<LocalDate> getDates() {
        return dates;
    }

    public void setDates(List<LocalDate> dates) {
        this.dates = dates;
    }
}
