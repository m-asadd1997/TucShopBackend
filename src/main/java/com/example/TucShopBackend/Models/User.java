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


	public User() {
	}

	public User(String email, String name, String password, Boolean active, String userType, Long clientId) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.active = active;
		this.userType = userType;
		this.clientId = clientId;

    @Column
	private String date;

    @Column
	private String time;

	public User() {
	}

	public User(String date) {
		this.date = date;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
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

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean isActive) {
		this.active = isActive;
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


}
