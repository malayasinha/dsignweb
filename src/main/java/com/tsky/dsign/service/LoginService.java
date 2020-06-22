package com.tsky.dsign.service;

import com.tsky.dsign.entity.UserEntity;

public interface LoginService {

	public UserEntity getLoginDetail(String userId);
	
}
