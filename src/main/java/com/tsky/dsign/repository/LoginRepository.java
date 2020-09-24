package com.tsky.dsign.repository;

import com.tsky.dsign.entity.UserEntity;

public interface LoginRepository {

	public UserEntity getLoginDetail(String userId);

}
