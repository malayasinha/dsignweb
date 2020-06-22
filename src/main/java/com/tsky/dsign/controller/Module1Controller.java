package com.tsky.dsign.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tsky.dsign.dto.ResponseObject;
import com.tsky.dsign.service.ModuleService;
import com.tsky.dsign.utility.Constants;
import com.tsky.dsign.utility.ResourceReader;


@Controller
@SessionAttributes({Constants.USERID})
public class Module1Controller {
	static Logger logger = LogManager.getLogger(Module1Controller.class);
	@Autowired
	ModuleService service;
	
    @GetMapping("/searchmod1")
    public String getSearchModPage1(Model model) {
    	logger.info("searchmod1 module called...");
    	return "SearchModule1";
    }
     
    private final String module = "dsigndb"; 
    
	@PostMapping("/search1")
	public ResponseEntity<ResponseObject<Map<String,String>>> searchData(@RequestParam("fileName") String fileName) {
		ResponseObject<Map<String,String>> resp = service.getSignedHistoryList(module, fileName);  
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}
    
    //==========================================================
    @GetMapping("/reportmod1")
    public String getReportPage(Model model) {
    	return "ReportModule1";
    }
    
    
    @PostMapping("/report1") //2018-11-15T18:30:00.000Z  yyyy-MM-dd'T'h:mm:ss.SSSZ
	public ResponseEntity<ResponseObject<Map<String,String>>> generateReport(@RequestParam("fromdate") String fromDate,
			@RequestParam("todate") String toDate) {
		logger.info("report this is a from Date: "+fromDate+"  to Date :"+toDate);
		ResponseObject<Map<String,String>> resp = service.getSignedHistoryList(module, fromDate, toDate);  
		return new ResponseEntity<>(resp,HttpStatus.OK);
	
    }
    
	@RequestMapping("/download1/{fileName:.+}")
	public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("fileName") String fileName) {
		logger.info("Download file called...");
		String dataDirectory = ResourceReader.readConfigProps("file.location.search");
		//Path file = Paths.get(dataDirectory, fileName);
		Path path = Paths.get(dataDirectory, fileName);
		logger.info("isExist : "+Files.exists(path));
		if (Files.exists(path)) {
			response.setContentType("application/csv");
			response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
			try {
				Files.copy(path, response.getOutputStream());
				//response.getOutputStream().flush();
				response.flushBuffer();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
    @GetMapping("/manageappmod1")
    public String getManageAppPage(Model model) {
    	return "ManageAppModule1";

    
    }
    @PostMapping("/manage1") //2018-11-15T18:30:00.000Z  yyyy-MM-dd'T'h:mm:ss.SSSZ
	public ResponseEntity<ResponseObject<String>> manageApp() {
    	String command=ResourceReader.readConfigProps("server.profile1.command");
		service.executeCommand(command);
    	
		//ResponseObject<String> resp = new ResponseObject<>("OK", service.getSignedHistoryList(fromDate, toDate), false);  
		
		return null;//new ResponseEntity<>(resp,HttpStatus.OK);
	
    }
}	
