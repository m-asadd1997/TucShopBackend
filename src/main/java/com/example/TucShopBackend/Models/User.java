package com.example.TucShopBackend.Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.TimeZone;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String email;
    @Column
    private String name;
    @Column
    private String password;

    @Column
    private Boolean active;
    
    @Column
    private String userType;
    
    @Column
    private Long clientId;
	
    @Column
	  private String date;

	  @Column
	  private String time;

    @Column
	  private String accountAccessKey;

    @Column
	  LocalDate accountExpire;

    @Column
	  LocalDate accountAccessDate;

	public User() {
	}

	public User(String email, String name, String password, Boolean active, String userType, Long clientId, LocalDate accountAccessDate, LocalDate accountExpire, String accountAccessKey) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.active = active;
		this.userType = userType;
		this.clientId = clientId;
		this.accountAccessKey = accountAccessKey;
		this.accountAccessDate = accountAccessDate;
		this.accountExpire = accountExpire;
	}

	public User(String email, String name, String password, Boolean active, String userType, Long clientId) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.active = active;
		this.userType = userType;
		this.clientId = clientId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAccountAccessKey() {
		return accountAccessKey;
	}

	public void setAccountAccessKey(String accountAccessKey) {
		this.accountAccessKey = accountAccessKey;
	}

	public LocalDate getAccountExpire() {
		return accountExpire;
	}

	public void setAccountExpire(LocalDate accountExpire) {
		this.accountExpire = accountExpire;
	}

	public LocalDate getAccountAccessDate() {
		return accountAccessDate;
	}

	public void setAccountAccessDate(LocalDate accountAccessDate) {
		this.accountAccessDate = accountAccessDate;
	}
}
