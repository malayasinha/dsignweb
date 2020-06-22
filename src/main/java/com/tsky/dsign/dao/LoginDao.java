package com.tsky.dsign.dao;

import com.tsky.dsign.entity.UserEntity;

public interface LoginDao {

	public UserEntity getLoginDetail(String userId);

}
