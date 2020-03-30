package com.example.TucShopBackend.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Created by ASAD QURESHI on 1/21/2020.
 */
public class RequestForProductDTO {

    public Long id;
    @NotBlank(message = "Name cannot be blank" )
    @NotNull(message = "Name cannot be null")
    public String name;
    public Long count;
//    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    public String  getDate1() {


        SimpleDateFormat myDate = new SimpleDateFormat("yyyy-MM-dd");
        myDate.setTimeZone(TimeZone.getTimeZone("PKT"));
        java.util.Date datee =new java.util.Date();
//        Date newDate = myDate.parse("2010-05-23T09:01:02");
        date1= myDate.format(datee);
        return date1;
    }

    public void setDate1(String  date1) {
//        this.date1 = new java.util.Date (System.currentTimeMillis());
        this.date1=date1;
    }

//    public java.util.Date  date1;

    public String date1;



    public RequestForProductDTO( ) {

    }

    public RequestForProductDTO(Long id, @NotBlank(message = "Name cannot be blank") @NotNull(message = "Name cannot be null") String name, Long count,String  date1) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.date1=date1;



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

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
