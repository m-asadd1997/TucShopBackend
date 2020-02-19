package com.example.TucShopBackend.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by ASAD QURESHI on 1/21/2020.
 */
public class RequestForProductDTO {
    @NotBlank(message = "Name cannot be blank" )
    @NotNull(message = "Name cannot be null")
    String name;


    public RequestForProductDTO() {
    }

    public RequestForProductDTO(@NotBlank(message = "Name cannot be blank") @NotNull(message = "Name cannot be null") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
