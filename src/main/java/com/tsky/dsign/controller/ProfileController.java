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
import com.tsky.dsign.entity.ProfileEntity;
import com.tsky.dsign.entity.ProfileEntity;
import com.tsky.dsign.service.ProfileService;
import com.tsky.dsign.utility.Constants;

@Controller
@SessionAttributes({Constants.USERID})
public class ProfileController {
	static Logger logger = LogManager.getLogger(ProfileController.class);
	@Autowired
	ProfileService service;
	
    @GetMapping("/profile")
    public String getProfilePage(Model model) {
    	logger.info("profile module called...");
    	return "profile";
    }
     
    @GetMapping("/doclist") 
	public ResponseEntity<ResponseBean<List<String>>> getDocList() {
		ResponseBean<List<String>> resp = service.getDocumentList();  
		return new ResponseEntity<>(resp,HttpStatus.OK);
    }
    
    @GetMapping("/signlist") 
	public ResponseEntity<ResponseBean<Map<String,String>>> getSignerList() {
		
		ResponseBean<Map<String,String>> resp = service.getSignerList();  
		return new ResponseEntity<>(resp,HttpStatus.OK);
    }
    
    @GetMapping(value="/getallprofile")
    @ResponseBody
	public ResponseEntity<ResponseBean<List<ProfileEntity>>> fetchAllProfile() {
    	ResponseBean<List<ProfileEntity>> response = service.fetchAllProfile();
		return new ResponseEntity<>(response,HttpStatus.OK);
    }
    
    @GetMapping(value="/getprofile/{profileId}")
    @ResponseBody
	public ResponseEntity<ResponseBean<ProfileEntity>> fetchProfileId(@PathVariable("empoyeeId") String profileId) {
    	ResponseBean<ProfileEntity> response = service.fetchProfileById(profileId);
		return new ResponseEntity<>(response,HttpStatus.OK);
    }
    
    @PostMapping(value="/profilesave", consumes=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ResponseEntity<ResponseBean<String>> saveProfile(@RequestBody ProfileEntity  profile, @ModelAttribute(Constants.USERID) String user ) {
		System.out.println(profile);
		ResponseBean<String> resp = service.saveProfile(profile,user);  
		return new ResponseEntity<>(resp,HttpStatus.OK);
    }
    
    @PostMapping(value="/profileupdate", consumes=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ResponseEntity<ResponseBean<String>> updateProfile(@RequestBody ProfileEntity  profile, @ModelAttribute(Constants.USERID) String user ) {
		System.out.println(profile);
		ResponseBean<String> resp = service.updateProfile(profile,user);  
		return new ResponseEntity<>(resp,HttpStatus.OK);
    }
}	
