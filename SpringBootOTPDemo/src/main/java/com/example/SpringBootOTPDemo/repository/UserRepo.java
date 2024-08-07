package com.example.SpringBootOTPDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootOTPDemo.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
