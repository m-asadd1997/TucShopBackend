package com.example.TucShopBackend.DTO;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class EmailDTO {

    @NotNull
    @Email
    String email;
    MultipartFile file;

    public EmailDTO(@NotNull @Email String email, MultipartFile file) {
        this.email = email;
        this.file = file;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
