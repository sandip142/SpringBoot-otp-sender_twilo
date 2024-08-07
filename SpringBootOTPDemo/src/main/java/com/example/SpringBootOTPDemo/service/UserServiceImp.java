package com.example.SpringBootOTPDemo.service;

import java.util.Random;

import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService {

	@Override
	public String generateOpt(String username) {
        Random random = new Random();
       int otp =100000+random.nextInt(999999);
       String value =String.valueOf(otp);
		return value;
	}

}
