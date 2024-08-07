package com.example.SpringBootOTPDemo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringBootOTPDemo.service.OTPservice;
import com.example.SpringBootOTPDemo.service.UserService;



@Controller
public class UserController {
	String otp;
  
	@Autowired
	private UserService userService;
	
	@Autowired
	private OTPservice otpservice;
	
	
	@GetMapping("/login")
	public String getLogin(Model model) {
		return "login";
	}
	
	
	@GetMapping("/loginsts")
	public String getOtp( @RequestParam("username") String username,Model model) {
		int count =0;
		try {
			String contact="+91"+username;
		     otp =userService.generateOpt(username);
		      System.out.println(contact+" "+otp);
		      model.addAttribute("otp",otp);
		     otpservice.sendOtp(contact,otp);
		 	return "otppage";
		}catch (Exception e) {
			
		     e.printStackTrace();
		     return "login";
		}
	
	}
	
	
	@GetMapping("/welcomests")
	public String verifyOtp(@RequestParam("otp") String sotp) {
		int count =0;
		System.out.println("user enter opt is "+sotp);
		try {
			if(sotp.equals(otp)) {
				count++;	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println(count);
		 if(count>0) {
			 return "welcome";
		 }else {
			 return "otppage";
		 }
	}
	
	
}
