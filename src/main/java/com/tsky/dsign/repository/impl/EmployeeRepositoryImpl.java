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

import com.tsky.dsign.entity.EmployeeEntity;
import com.tsky.dsign.repository.ModuleRepository;
import com.tsky.dsign.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository  {
	static Logger logger = LogManager.getLogger(ModuleRepository.class);
		
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public int saveEmployee(EmployeeEntity entity,String user) {
		String sql = "INSERT INTO dsignweb.employees " +
			"(employee_id, name, email, phone, department,is_active,created_by, created_on, updated_by, updated_on) "+
			"VALUES(:employee_id, :name, :email, :phone, :department,:is_active,:created_by, :created_on, :updated_by, :updated_on) ";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		
		parameters.addValue("employee_id", entity.getEmployeeId());
		parameters.addValue("name", entity.getName());
		parameters.addValue("email", entity.getName());
		parameters.addValue("phone", entity.getName());
		parameters.addValue("department", entity.getName());
		parameters.addValue("is_active", true);
		parameters.addValue("created_by", user);
		parameters.addValue("created_on",new Timestamp(new Date().getTime()));
		        
        int i = jdbcTemplate.update(sql, parameters);
        
		return i;
	}


	@Override
	public int updateEmployee(EmployeeEntity entity, String user) {
		String sql = "UPDATE dsignweb.employees " +
				"SET department=:department, name=:name,email=:email, phone=:phone,updated_by=:updated_by, updated_on=current_timestamp,is_active=:is_active "+
				"WHERE employee_id=:employee_id ";
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			
			parameters.addValue("employee_id", entity.getEmployeeId());
			parameters.addValue("name", entity.getName());
			parameters.addValue("phone", entity.getPhone());
			parameters.addValue("is_active", entity.getIsActive());
			parameters.addValue("department", entity.getDepartment());
			
			parameters.addValue("modified_by", user);
			
	        int i = jdbcTemplate.update(sql, parameters);
	        
			return i;
		
	}


	@Override
	public EmployeeEntity fetchEmployeeById(String EmployeeId) {
		String sql = "SELECT document_type, Employee_name, signatory1, signatory2, signatory3, signatory4, signatory5 FROM dsignweb.Employee "+
				"where Employee_id = :EmployeeId ";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("EmployeeId", EmployeeId);
        
        return (EmployeeEntity) jdbcTemplate.queryForObject(
    			sql,
    			parameters,
    			new BeanPropertyRowMapper<>(EmployeeEntity.class));
		
	}


	@Override
	public List<EmployeeEntity> fetchAllEmployee() {
		String sql = "SELECT * FROM dsignweb.Employee";

	    List<EmployeeEntity> Employee = jdbcTemplate.query(
	            sql,
	            new BeanPropertyRowMapper<>(EmployeeEntity.class));
	    return Employee;
	}
	
}
