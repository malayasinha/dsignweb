package com.tsky.dsign.service;

import java.util.List;
import java.util.Map;

import com.tsky.dsign.bean.ResponseBean;
import com.tsky.dsign.entity.ProfileEntity;

public interface ProfileService {
	public ResponseBean<List<String>> getDocumentList();
	public ResponseBean<Map<String,String>> getSignerList();
	
	public ResponseBean<ProfileEntity> fetchProfileById(String profileId);
	public ResponseBean<List<ProfileEntity>> fetchAllProfile();
	
	public ResponseBean<String> saveProfile(ProfileEntity profileBean,String user);
	public ResponseBean<String> updateProfile(ProfileEntity profile, String user);
	
}
