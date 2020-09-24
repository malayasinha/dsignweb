package com.tsky.dsign.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.tsky.dsign.bean.ResponseBean;
import com.tsky.dsign.entity.ProfileEntity;
import com.tsky.dsign.repository.ProfileRepository;
import com.tsky.dsign.service.ProfileService;

@Service
@PropertySource("classpath:messages_en.properties")
public class ProfileServiceImpl implements ProfileService {
	static Logger logger = LogManager.getLogger(ProfileServiceImpl.class);
	
	@Autowired
	Environment environment;
	
	@Autowired
	ProfileRepository profileDao;
	
	@Override
	public ResponseBean<List<String>> getDocumentList() {
		ResponseBean<List<String>> response = new ResponseBean<>();
		List<String> list = profileDao.getDocList("ContractType");
		response = new ResponseBean<>(environment.getRequiredProperty("message.data.exist"),list,false);
		return response;
	}

	@Override
	public ResponseBean<Map<String, String>> getSignerList() {
		ResponseBean<Map<String,String>> response = new ResponseBean<>();
		Map<String,String> map = profileDao.getSignerList();
		response = new ResponseBean<>(environment.getRequiredProperty("message.data.exist"),map,false);
		return response;
	}

	@Override
	public ResponseBean<String> saveProfile(ProfileEntity profileBean,String user) {
		profileDao.saveProfile(profileBean,user);
		return new ResponseBean<>("Data saved successfully","OK",false);
	}

	@Override
	public ResponseBean<String> updateProfile(ProfileEntity profile, String user) {
		profileDao.updateProfile(profile,user);
		return new ResponseBean<>("Data saved successfully","OK",false);
	}

	@Override
	public ResponseBean<ProfileEntity> fetchProfileById(String profileId) {
		ProfileEntity bean = profileDao.fetchProfileById(profileId); 
		
		ResponseBean response = new ResponseBean("Data Fetched Successfully",bean,false);
		
		return response;
	}

	@Override
	public ResponseBean<List<ProfileEntity>> fetchAllProfile() {
		List<ProfileEntity> list = profileDao.fetchAllProfile(); 
		
		ResponseBean response = new ResponseBean<>("Data Fetched Successfully",list,false);
		return response;
	}
}
