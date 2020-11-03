package com.example.TucShopBackend.Models;

import com.example.TucShopBackend.Config.AttributeEncryptor;
import javax.persistence.*;

@Entity
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Convert(converter = AttributeEncryptor.class)
    private  String token;

    public Token (){ }


    public Token(String token) {
        this.token = token;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
