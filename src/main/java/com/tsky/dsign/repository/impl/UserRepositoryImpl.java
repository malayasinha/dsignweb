package com.tsky.dsign.repository.impl;

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

import com.tsky.dsign.entity.UserEntity;
import com.tsky.dsign.repository.ModuleRepository;
import com.tsky.dsign.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository  {
	static Logger logger = LogManager.getLogger(ModuleRepository.class);
		
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public int saveUser(UserEntity entity,String user) {
		String sql = "INSERT INTO dsignweb.users " +
			"(user_id, is_active, password, name, employee_id, role_id,created_by, created_on) "+
			"VALUES(:user_id, :is_active, :password, :name, :employee_id, :role_id,:created_by, :created_on) ";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		
		parameters.addValue("user_id", entity.getUserId());
		parameters.addValue("name", entity.getUserName());
		parameters.addValue("password", entity.getPassword());
		parameters.addValue("employee_id", entity.get());
		parameters.addValue("is_active", true);
		parameters.addValue("created_by", user);
		parameters.addValue("created_on",new Timestamp(new Date().getTime()));
		        
        int i = jdbcTemplate.update(sql, parameters);
        
		return i;
	}


	@Override
	public int updateUser(UserEntity entity, String user) {
		String sql = "UPDATE dsignweb.users " +
				"SET department=:department, name=:name,email=:email, phone=:phone,updated_by=:updated_by, updated_on=current_timestamp,is_active=:is_active "+
				"WHERE user_id=:user_id ";
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			
			parameters.addValue("user_id", entity.getUserId());
			parameters.addValue("name", entity.getName());
			parameters.addValue("phone", entity.getPhone());
			parameters.addValue("is_active", entity.getIsActive());
			parameters.addValue("department", entity.getDepartment());
			
			parameters.addValue("modified_by", user);
			
	        int i = jdbcTemplate.update(sql, parameters);
	        
			return i;
		
	}


	@Override
	public UserEntity fetchUserById(String UserId) {
		String sql = "SELECT document_type, User_name, signatory1, signatory2, signatory3, signatory4, signatory5 FROM dsignweb.User "+
				"where User_id = :UserId ";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("UserId", UserId);
        
        return (UserEntity) jdbcTemplate.queryForObject(
    			sql,
    			parameters,
    			new BeanPropertyRowMapper<>(UserEntity.class));
		
	}


	@Override
	public List<UserEntity> fetchAllUser() {
		String sql = "SELECT * FROM dsignweb.User";

	    List<UserEntity> User = jdbcTemplate.query(
	            sql,
	            new BeanPropertyRowMapper<>(UserEntity.class));
	    return User;
	}
	
}
