package com.tsky.dsign.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="TBL_USERS")
public class UserEntity {
	
	@Id
	@Column(name="USER_ID")
	@Size(max=25)
	@NotNull
	private String userId;
	
	@Column(name="PASSWORD")
	@Size(max=55)
	@NotNull
	private String password;
	
	@Column(name="USER_NAME")
	@Size(max=55)
	private String userName;
	
	@Column(name="USER_ROLE")
	@Size(max=15)
	private String userType;
	
	@Column(name="EMAIL")
	@Size(max=35)
	private String email;
	
	@Column(name="PHONE")
	@Size(max=15)
	private String phone;
	
	@Column(name="IS_ACTIVE")
	private Boolean isActive;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", password=" + password + ", userName=" + userName + ", userType="
				+ userType + ", email=" + email + ", phone=" + phone + ", isActive=" + isActive + "]";
	}
	
	
}
