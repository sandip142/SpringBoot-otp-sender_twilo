package com.example.SpringBootOTPDemo.configration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;


@Configuration
public class TwilioConfigration {
	
   @Value("${twilio.accountsid}")
   private String accountsid;
   @Value("${twilio.authToken}")
   private String authToken;
   @Value("${twilio.contactNo}")
   private String contactNo;
   
   
   @PostConstruct
   public void initTwilio() {
	   Twilio.init(accountsid,authToken);
   }
   
   public String getContactNo() {
	   return contactNo;
   }
   
}
