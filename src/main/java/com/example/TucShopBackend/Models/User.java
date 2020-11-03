package com.example.TucShopBackend.Models;

import com.example.TucShopBackend.Config.LocalDateEncryptDecryptConverter;

import javax.persistence.*;
import java.time.LocalDate;

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
	 @Convert(converter = LocalDateEncryptDecryptConverter.class)
     LocalDate accountExpire;

	@Column
	@Convert(converter = LocalDateEncryptDecryptConverter.class)
	LocalDate accountAccessDate;



    public User() {
	}

	public User(String s, String usertest, String encode, boolean b, String user, long l, LocalDate accessDate, LocalDate expireDate, String trial) {

		this.email=s;
		this.name=usertest;
		this.password=encode;
		this.active=b;
		this.userType=user;
		this.clientId=l;
		this.accountAccessDate=accessDate;
		this.accountExpire=expireDate;
		this.accountAccessKey=trial;
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
