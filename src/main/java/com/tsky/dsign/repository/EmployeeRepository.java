package com.tsky.dsign.repository;

import java.util.List;
import java.util.Map;

import com.tsky.dsign.entity.EmployeeEntity;

public interface EmployeeRepository{
	
	public EmployeeEntity fetchEmployeeById(String EmployeeId);
	public List<EmployeeEntity> fetchAllEmployee();
	
	public int saveEmployee(EmployeeEntity pe,String user);
	public int updateEmployee(EmployeeEntity Employee, String user);
}
