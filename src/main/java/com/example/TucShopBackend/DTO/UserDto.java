package com.example.TucShopBackend.DTO;

import java.time.LocalDate;

public class UserDto {

    private String name;
    private String email;
    private String password;
    private Boolean active ;
    private String userType;
    private Long clientId;
    private String date;
    private String time;
    private String accountAccessKey;
    private LocalDate accountExpire;
    private LocalDate accountAccessDate;

	public UserDto(String name, LocalDate accountAccessDate, String accountAccessKey, LocalDate accountExpire, String date, String time, String email, String password, Boolean active, String userType, Long clientId) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.active = active;
		this.userType = userType;
		this.clientId = clientId;
		this.date = date;
		this.time = time;
		this.accountAccessKey = accountAccessKey;
		this.accountExpire = accountExpire;
		this.accountAccessDate = accountAccessDate;
	}


	public UserDto() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
