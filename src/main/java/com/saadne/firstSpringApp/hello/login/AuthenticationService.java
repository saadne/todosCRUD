package com.saadne.firstSpringApp.hello.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String name, String password) {
		boolean validName = name.equalsIgnoreCase("saadne");
		boolean validPassword= password.equalsIgnoreCase("password");
		
		return validName && validPassword;
	}

}
