package com.tsky.dsign.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_USER_AUTHORITIES")
public class UserAuthorityEntity {
	@Id
	@Column(name = "AUTHORITY_ID")
	private Integer authorityId;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UserEntity userId;

	public Integer getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	public UserEntity getUserId() {
		return userId;
	}

	public void setUserId(UserEntity userId) {
		this.userId = userId;
	}
	
}
