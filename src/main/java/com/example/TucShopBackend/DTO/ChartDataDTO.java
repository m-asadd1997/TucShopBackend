package com.example.TucShopBackend.DTO;

import java.util.List;

public class ChartDataDTO {

    List<String> labels;
    List<Double> series;

    public ChartDataDTO() {
    }

    public ChartDataDTO(List<String> labels, List<Double> series) {
        this.labels = labels;
        this.series = series;
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
}
