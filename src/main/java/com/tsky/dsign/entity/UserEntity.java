package com.tsky.dsign.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity {
	
	@Id
	@Column(name="user_id", length=15, nullable=false)
	private String userId;
	
	@Column(name="password", length=55, nullable=false)
	private String password;
	
	@Column(name="name", length=35, nullable=false)
	private String userName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	private RoleEntity role;
	
	@Column(name="is_active")
	private Boolean isActive;
	
	@ManyToOne
	@JoinColumn(name="employee_id", referencedColumnName="employee_id")
	private EmployeeEntity employee;
	
	@Column(name="created_by", length=15)
	private String createdBy;
	
	@Column(name="created_on", updatable=false)
	private Timestamp createdOn;
	
	@Column(name="updated_by", length=15)
	private String updatedBy;
	
	@Column(name="updated_on")
	private Timestamp updatedOn;

	
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

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", password=" + password + ", userName=" + userName + ", role=" + role
				+ ", isActive=" + isActive + ", employee=" + employee + "]";
	}
	
}
