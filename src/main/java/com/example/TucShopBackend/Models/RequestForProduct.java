package com.example.TucShopBackend.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Created by ASAD QURESHI on 1/21/2020.
 */
@Entity
public class RequestForProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;





    public String getDate1() {
        return date1;
    }

    public void setDate1(String  date1) {
//        date1= new java.util.Date();

//        date1 = sdf.parse();

        this.date1 = date1;
    }

//    java.util.Date  date1;
    String date1;



    public RequestForProduct() {
    }

    public RequestForProduct(String name) {
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
