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
import com.tsky.dsign.entity.EmployeeEntity;
import com.tsky.dsign.repository.EmployeeRepository;
import com.tsky.dsign.service.EmployeeService;

@Service
@PropertySource("classpath:messages_en.properties")
public class EmployeeServiceImpl implements EmployeeService {
	static Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	Environment environment;
	
	@Autowired
	EmployeeRepository employeeDao;
	
	@Override
	public ResponseBean<String> saveEmployee(EmployeeEntity employeeBean,String user) {
		employeeDao.saveEmployee(employeeBean,user);
		return new ResponseBean<>("Data saved successfully","OK",false);
	}

	@Override
	public ResponseBean<String> updateEmployee(EmployeeEntity employee, String user) {
		employeeDao.updateEmployee(employee,user);
		return new ResponseBean<>("Data saved successfully","OK",false);
	}

	@Override
	public ResponseBean<EmployeeEntity> fetchEmployeeById(String employeeId) {
		EmployeeEntity bean = employeeDao.fetchEmployeeById(employeeId); 
		
		ResponseBean response = new ResponseBean("Data Fetched Successfully",bean,false);
		
		return response;
	}

	@Override
	public ResponseBean<List<EmployeeEntity>> fetchAllEmployee() {
		List<EmployeeEntity> list = employeeDao.fetchAllEmployee(); 
		
		ResponseBean response = new ResponseBean<>("Data Fetched Successfully",list,false);
		return response;
	}
}
