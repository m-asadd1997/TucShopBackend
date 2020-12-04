package com.example.TucShopBackend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
public class Online_Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private Long uuid;
    private String firstName;
    private String lastName;
    private String address;
    private String townCity;
    private String stateCountry;
    private String emailAddress;
    private String phone;
    private String postCodeZip;
    private double cartSubTotal;
    private double shipping;
    private double orderTotal;
    private String orderStatus;
    private LocalDate orderDate;
    private LocalTime orderTime;

    @OneToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id", nullable = false)
    private  Cart cart;


    public Online_Order(Long id, Long uuid, Cart cart, LocalTime orderTime, String orderStatus, LocalDate orderDate, String firstName, String lastName, String address, String townCity, String stateCountry, String emailAddress, String phone, String postCodeZip, double cartSubTotal, double shipping, double orderTotal) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.townCity = townCity;
        this.stateCountry = stateCountry;
        this.emailAddress = emailAddress;
        this.phone = phone;
        this.postCodeZip = postCodeZip;
        this.cartSubTotal = cartSubTotal;
        this.shipping = shipping;
        this.orderTotal = orderTotal;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.uuid = uuid;
        this.orderTime = orderTime;
        this.cart = cart;
    }

    public Online_Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTownCity() {
        return townCity;
    }

    public void setTownCity(String townCity) {
        this.townCity = townCity;
    }

    public String getStateCountry() {
        return stateCountry;
    }

    public void setStateCountry(String stateCountry) {
        this.stateCountry = stateCountry;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostCodeZip() {
        return postCodeZip;
    }

    public void setPostCodeZip(String postCodeZip) {
        this.postCodeZip = postCodeZip;
    }

    public double getCartSubTotal() {
        return cartSubTotal;
    }

    public void setCartSubTotal(double cartSubTotal) {
        this.cartSubTotal = cartSubTotal;
    }

    public double getShipping() {
        return shipping;
    }

    public void setShipping(double shipping) {
        this.shipping = shipping;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }


    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalTime orderTime) {
        this.orderTime = orderTime;
    }


    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
