package com.example.SpringBootOTPDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootOTPDemo.configration.TwilioConfigration;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Service
public class OTPservice {
	
	
	@Autowired
	TwilioConfigration twilioConfigration;
	

	
   public void sendOtp(String mobileNo,String otp) {
	   
		try {
	   Message.creator(
			   new PhoneNumber(mobileNo),
			   new PhoneNumber(twilioConfigration.getContactNo()),
			   "your otp is "+otp).create();
		}catch(Exception e) {
			e.printStackTrace();
		}
	
   }
}
