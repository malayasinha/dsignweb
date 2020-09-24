package com.tsky.dsign.repository;

import java.util.List;

import com.tsky.dsign.entity.UserEntity;

public interface UserRepository{
	
	public UserEntity fetchUserById(String UserId);
	public List<UserEntity> fetchAllUser();
	
	public int saveUser(UserEntity pe,String user);
	public int updateUser(UserEntity User, String user);
}
