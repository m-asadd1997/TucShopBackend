package com.example.TucShopBackend.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by ASAD QURESHI on 1/21/2020.
 */
public class RequestForProductDTO {

    public Long id;
    @NotBlank(message = "Name cannot be blank" )
    @NotNull(message = "Name cannot be null")
    public String name;
    public Long countName;


    public RequestForProductDTO( ) {

    }

    public RequestForProductDTO(Long id, @NotBlank(message = "Name cannot be blank") @NotNull(message = "Name cannot be null") String name, Long countName) {
        this.id = id;
        this.name = name;
        this.countName = countName;
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

    public Long getCountName() {
        return countName;
    }

    public void setCountName(Long countName) {
        this.countName = countName;
    }
}
