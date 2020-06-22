package com.tsky.dsign.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.tsky.dsign.entity.UserEntity;
import com.tsky.dsign.service.LoginService;
import com.tsky.dsign.utility.Constants;


@Controller
@SessionAttributes({Constants.USERID})
public class LoginController {
	static Logger logger = LogManager.getLogger(LoginController.class);
	
	@Autowired
    private LoginService loginService;
   
    @GetMapping("/")
    public String getLoginPage(Model model) {
    	logger.debug("logger has logged in");
		
		
    	return "Login";
    }

    @GetMapping("/home")
    public String getHomePage(Model model) {
    	return "Home";
    }
            
    @PostMapping("/validateuser")
    public ModelAndView validateUser(@RequestParam ("userId") String userId,
    		@RequestParam ("password") String password, HttpServletRequest request, Model model) {
    	logger.debug("validate user method called...");
    	ModelAndView mav = null;
    	HttpSession sess = request.getSession();
		UserEntity userBean = new UserEntity();
		userBean = loginService.getLoginDetail(userId);
		if (userBean != null) {
			sess.setAttribute(Constants.USERID, userId);
			if (!userBean.getIsActive()) {
				mav = new ModelAndView("redirect:/");
				//model.addAttribute("error", "INACTIVE");
			} else { //if user is active
				String decryptedPassword = userBean.getPassword();//EncryptionUtil.decrypt(userBean.getPassword());
				if (!decryptedPassword.equalsIgnoreCase(password)) { //if password is wrong
					logger.info("User password not correct");
					mav = new ModelAndView("redirect:/");
				} else { //if password is correct
					mav = new ModelAndView("redirect:/home");
					//loginService.saveLoginBean(username, (String) request.getRemoteAddr(), macAddr);
				}
			}

		} else {
			mav = new ModelAndView("redirect:/");

		}
		//mav.addObject("user", userId);
		return mav;
    }    
}	
