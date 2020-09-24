package com.tsky.dsign.repository.impl;

import java.sql.SQLType;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tsky.dsign.entity.ProfileEntity;
import com.tsky.dsign.repository.ModuleRepository;
import com.tsky.dsign.repository.ProfileRepository;

@Repository
public class ProfileRepositoryImpl implements ProfileRepository  {
	static Logger logger = LogManager.getLogger(ModuleRepository.class);
		
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<String> getDocList(String codeType) {
		logger.info("dao report for ");
		String sql = "Select * from app_code where code_type = :codeType ";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("codeType", codeType);
        
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,parameters);
        
        List<String> list = new ArrayList<String>();
        
        for (Map row : rows) {
        	list.add((String)row.get("code_key"));
        }
        return list;
	}


	@Override
	public Map<String, String> getSignerList() {
		logger.info("dao report for ");
		String sql = "Select * from signatories where is_active = 1 ";
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
        //parameters.addValue("codeType", codeType);
        
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,parameters);
        Map<String,String> map = new HashMap<String,String>();
        
        for (Map row : rows) {
        	map.put((String)row.get("signatory_id"),(String)row.get("name"));
        }
        
        return map;
	}


	@Override
	public int saveProfile(ProfileEntity pb,String user) {
		String sql = "INSERT INTO dsignweb.profile " +
			"(profile_id, created_by, created_on, document_type, profile_name, signatory1, signatory2, signatory3, signatory4, signatory5,is_active) "+
			"VALUES(:profile_id, :created_by, current_timestamp, :document_type, :profile_name, :signatory1, :signatory2, :signatory3, :signatory4, :signatory5,:is_active)";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		System.out.println(UUID.randomUUID().toString());
		parameters.addValue("profile_id", UUID.randomUUID().toString());
		parameters.addValue("created_by", user);
		parameters.addValue("created_on",new Timestamp(new Date().getTime()));
		parameters.addValue("document_type", pb.getDocumentType());
		parameters.addValue("profile_name", pb.getProfileName());
		parameters.addValue("is_active", true);
		if(pb.getSignatory1()!=null) 
			parameters.addValue("signatory1", pb.getSignatory1().getSignatoryId()); 
		else
			parameters.addValue("signatory1", null);
		if(pb.getSignatory2()!=null) 
			parameters.addValue("signatory2", pb.getSignatory2().getSignatoryId());
		else 
			parameters.addValue("signatory2",null);
		if(pb.getSignatory3()!=null) 
			parameters.addValue("signatory3", pb.getSignatory3().getSignatoryId());
		else 
			parameters.addValue("signatory3",null);
		if(pb.getSignatory4()!=null) 
			parameters.addValue("signatory4", pb.getSignatory4().getSignatoryId());
		else 
			parameters.addValue("signatory4",null);
		if(pb.getSignatory5()!=null) 
			parameters.addValue("signatory5", pb.getSignatory5().getSignatoryId());
		else 
			parameters.addValue("signatory5",null);
        
        int i = jdbcTemplate.update(sql, parameters);
        
		return i;
	}


	@Override
	public int updateProfile(ProfileEntity pb, String user) {
		String sql = "UPDATE dsignweb.profile " +
				"SET document_type=:document_type, modified_by=:modified_by, modified_on=current_timestamp, profile_name=:profile_name, signatory1=:signatory1, signatory2=:signatory2, signatory3=:signatory3, signatory4=:signatory4, signatory5=:signatory5,is_active=:is_active "+
				"WHERE profile_id=:profile_id ";
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			System.out.println(UUID.randomUUID().toString());
			parameters.addValue("profile_id", UUID.randomUUID().toString());
			parameters.addValue("modified_by", user);
			parameters.addValue("modified_on",new Timestamp(new Date().getTime()));
			parameters.addValue("document_type", pb.getDocumentType());
			parameters.addValue("profile_name", pb.getProfileName());
			parameters.addValue("is_active", pb.getIsActive());
			
			if(pb.getSignatory1()!=null) 
				parameters.addValue("signatory1", pb.getSignatory1().getSignatoryId()); 
			else
				parameters.addValue("signatory1", null);
			if(pb.getSignatory2()!=null) 
				parameters.addValue("signatory2", pb.getSignatory2().getSignatoryId());
			else 
				parameters.addValue("signatory2",null);
			if(pb.getSignatory3()!=null) 
				parameters.addValue("signatory3", pb.getSignatory3().getSignatoryId());
			else 
				parameters.addValue("signatory3",null);
			if(pb.getSignatory4()!=null) 
				parameters.addValue("signatory4", pb.getSignatory4().getSignatoryId());
			else 
				parameters.addValue("signatory4",null);
			if(pb.getSignatory5()!=null) 
				parameters.addValue("signatory5", pb.getSignatory5().getSignatoryId());
			else 
				parameters.addValue("signatory5",null);
	        
	        int i = jdbcTemplate.update(sql, parameters);
	        
			return i;
		
	}


	@Override
	public ProfileEntity fetchProfileById(String profileId) {
		String sql = "SELECT document_type, profile_name, signatory1, signatory2, signatory3, signatory4, signatory5 FROM dsignweb.profile "+
				"where profile_id = :profileId ";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("profileId", profileId);
        
        return (ProfileEntity) jdbcTemplate.queryForObject(
    			sql,
    			parameters,
    			new BeanPropertyRowMapper<>(ProfileEntity.class));
		
	}


	@Override
	public List<ProfileEntity> fetchAllProfile() {
		String sql = "SELECT * FROM dsignweb.profile";

	    List<ProfileEntity> profile = jdbcTemplate.query(
	            sql,
	            new BeanPropertyRowMapper<>(ProfileEntity.class));
	    return profile;
	}
	
}
