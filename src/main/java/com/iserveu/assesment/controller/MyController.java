package com.iserveu.assesment.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iserveu.assesment.entity.LoginRequest;
import com.iserveu.assesment.entity.LoginResponse;

@RestController
public class MyController {
	
	@PostMapping("/getlogintoken")
    public LoginResponse getLoginToken(@RequestBody LoginRequest loginRequest) {
        if(validate(loginRequest.getUsername(), loginRequest.getPassword())) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setToken("eyJhbGciOiJIUzUxMiJ9");
            loginResponse.setAdmin("demoisu");
            loginResponse.setMobileNumber("9999999999");
            return loginResponse;
        } 
        return null;
    }
	
	
	private boolean validate(String username, String password) {
	    String[][] users = {{"admin", "password"},{"itpl", "itpl4692"}};
	    
	    for (String[] user : users) {
	        if (username.equals(user[0]) && password.equals(user[0])) {
	            return true;
	        }
	    }
	    return false;
	}
}
