package com.saadne.firstSpringApp.hello.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LoginController {
	
	private AuthenticationService authenticationService;
	
	LoginController(AuthenticationService authenticationService){
		this.authenticationService = authenticationService;
	}
	
	@RequestMapping(value="login", method= RequestMethod.GET)
	public String login() {
		return "login";
	}
	@RequestMapping(value="login", method= RequestMethod.POST)
	public String welcomePage(@RequestParam String name,@RequestParam String password, ModelMap model) {
		boolean authenticate = authenticationService.authenticate(name, password);
		if(!authenticate) {
			return "login";
		}
		model.put("name",name);
		model.put("password",password);
		return "welcome";
	}
}
