package com.tsky.dsign.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="TBL_LOGIN_DETAILS")
public class LoginDetailBean {
	
	@Id
	@Column(name="USER_ID")
	@Size(max=35)
	private String userId;
	
	@Column(name="PASSWORD")
	@Size(max=55)
	private String password;
	
	@Column(name="LOGIN_TIME")
	private Timestamp loginTime;
	
	public String getUserId() {
		return userId;
	}

	public void setUserName(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}
}
