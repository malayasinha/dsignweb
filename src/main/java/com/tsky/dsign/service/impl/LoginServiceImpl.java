package com.tsky.dsign.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsky.dsign.entity.UserEntity;
import com.tsky.dsign.repository.LoginRepository;
import com.tsky.dsign.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginRepository loginDao;
	
	public UserEntity getLoginDetail(String userId) {
		UserEntity userBean = new UserEntity();
		
		userBean = loginDao.getLoginDetail(userId);
		
		return userBean;
	}
}
