package com.example.TucShopBackend.DTO;

import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class CategoryQuantityDTO {


    String label;

    Long value;


    public CategoryQuantityDTO() {
    }


    public CategoryQuantityDTO(String label, Long value) {

        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }


}



