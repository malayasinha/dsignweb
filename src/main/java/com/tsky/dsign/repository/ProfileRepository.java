package com.tsky.dsign.repository;

import java.util.List;
import java.util.Map;

import com.tsky.dsign.entity.ProfileEntity;

public interface ProfileRepository{
	
	public List<String> getDocList(String codeType);
	public Map<String,String> getSignerList();
	
	public ProfileEntity fetchProfileById(String profileId);
	public List<ProfileEntity> fetchAllProfile();
	
	public int saveProfile(ProfileEntity pe,String user);
	public int updateProfile(ProfileEntity profile, String user);
}
