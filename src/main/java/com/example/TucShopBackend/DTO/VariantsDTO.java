package com.example.TucShopBackend.DTO;

public class VariantsDTO {
    public Long id;
    String name;
    String variants;

    public VariantsDTO() {
    }

    public VariantsDTO(Long id, String name, String variants) {
        this.id = id;
        this.name = name;
        this.variants = variants;
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

    public String getVariants() {
        return variants;
    }

    public void setVariants(String variants) {
        this.variants = variants;
    }
}
