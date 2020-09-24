package com.tsky.dsign.service;

import java.util.List;
import java.util.Map;

import com.tsky.dsign.bean.ResponseBean;
import com.tsky.dsign.entity.EmployeeEntity;

public interface EmployeeService {
	
	public ResponseBean<EmployeeEntity> fetchEmployeeById(String EmployeeId);
	public ResponseBean<List<EmployeeEntity>> fetchAllEmployee();
	
	public ResponseBean<String> saveEmployee(EmployeeEntity EmployeeBean,String user);
	public ResponseBean<String> updateEmployee(EmployeeEntity Employee, String user);
	
}
