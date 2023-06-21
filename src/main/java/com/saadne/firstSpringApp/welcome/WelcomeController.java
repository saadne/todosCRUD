package com.saadne.firstSpringApp.welcome;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String welcomePage( ModelMap model) {
		String username = getLoggedInUsername(model);
		model.put("name", username.substring(0, 1).toUpperCase() + username.substring(1));
		return "welcome";
	}
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication =
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}


	
}
