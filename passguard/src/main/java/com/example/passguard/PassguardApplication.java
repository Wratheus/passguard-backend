package com.example.passguard;

import com.example.passguard.requests.user.UserService;
import com.example.passguard.util.JWTTokenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PassguardApplication {
	public static final Logger LOGGER = LoggerFactory.getLogger(JWTTokenProvider.class);
	public static final Logger UserServiceLogger = LoggerFactory.getLogger(UserService.class);


	public static void main(String[] args) {
		SpringApplication.run(PassguardApplication.class, args);
	}

}
