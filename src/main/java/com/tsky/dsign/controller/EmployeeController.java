package com.tsky.dsign.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.tsky.dsign.bean.ResponseBean;
import com.tsky.dsign.entity.EmployeeEntity;
import com.tsky.dsign.service.EmployeeService;
import com.tsky.dsign.utility.Constants;

@Controller
@SessionAttributes({Constants.USERID})
public class EmployeeController {
	static Logger logger = LogManager.getLogger(EmployeeController.class);
	@Autowired
	EmployeeService service;
	
    @GetMapping("/employee")
    public String getEmployeePage(Model model) {
    	logger.info("employee module called...");
    	return "employee";
    }

    @GetMapping(value="/getallemployee")
    @ResponseBody
	public ResponseEntity<ResponseBean<List<EmployeeEntity>>> fetchAllEmployee() {
    	ResponseBean<List<EmployeeEntity>> response = service.fetchAllEmployee();
		return new ResponseEntity<>(response,HttpStatus.OK);
    }
    
    @GetMapping(value="/getemployee/{employeeId}")
    @ResponseBody
	public ResponseEntity<ResponseBean<EmployeeEntity>> fetchEmployeeId(@PathVariable("empoyeeId") String employeeId) {
    	ResponseBean<EmployeeEntity> response = service.fetchEmployeeById(employeeId);
		return new ResponseEntity<>(response,HttpStatus.OK);
    }
    
    @PostMapping(value="/employeesave")
    @ResponseBody
	public ResponseEntity<ResponseBean<String>> saveEmployee(@RequestBody EmployeeEntity  employee, @ModelAttribute(Constants.USERID) String user ) {
		System.out.println(employee);
		ResponseBean<String> resp = service.saveEmployee(employee,user);  
		return new ResponseEntity<>(resp,HttpStatus.OK);
    }
    
    @PostMapping(value="/employeeupdate")
    @ResponseBody
	public ResponseEntity<ResponseBean<String>> updateEmployee(@RequestBody EmployeeEntity  employee, @ModelAttribute(Constants.USERID) String user ) {
		System.out.println(employee);
		ResponseBean<String> resp = service.updateEmployee(employee,user);  
		return new ResponseEntity<>(resp,HttpStatus.OK);
    }
}	
