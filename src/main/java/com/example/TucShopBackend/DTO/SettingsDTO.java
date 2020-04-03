package com.example.TucShopBackend.DTO;

import org.springframework.web.multipart.MultipartFile;

public class SettingsDTO {

    String header;
    MultipartFile logo;
    String footer;



    public SettingsDTO(String header, MultipartFile logo, String footer) {
        this.header = header;
        this.logo = logo;
        this.footer = footer;


    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public MultipartFile getLogo() {
        return logo;
    }

    public void setLogo(MultipartFile logo) {
        this.logo = logo;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }



}
