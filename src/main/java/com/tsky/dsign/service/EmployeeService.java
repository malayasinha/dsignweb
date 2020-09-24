package com.tsky.dsign.service;

import java.util.List;

import com.tsky.dsign.bean.ResponseBean;
import com.tsky.dsign.entity.EmployeeEntity;

public interface EmployeeService {
	
	public ResponseBean<EmployeeEntity> fetchEmployeeById(String employeeId);
	public ResponseBean<List<EmployeeEntity>> fetchAllEmployee();
	
	public ResponseBean<String> saveEmployee(EmployeeEntity employeeBean,String user);
	public ResponseBean<String> updateEmployee(EmployeeEntity employee, String user);
	
}
