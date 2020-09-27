package com.kosmos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kosmos.entity.User;
import com.kosmos.entity.UserRepo;


@RestController
@RequestMapping(value = "/service/")
public class UserServiceClass {
	
	private Logger logger = LoggerFactory.getLogger(UserServiceClass.class);
	@Autowired
	private UserRepo repo;
	
	@RequestMapping(value = "/viewProfile/{userName}")
	@ResponseBody
	public User viewProfile(@PathVariable (name = "userName") String userName) {
		User user = new User();
		try {
			logger.info(" /viewProfile MS access");
			
			user = repo.findById(userName).orElse(null);
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Error in app home page " + ex.getMessage());
			ModelAndView mv = new ModelAndView();
			mv.setViewName("error");
		}
		return user;
	}

	

}
