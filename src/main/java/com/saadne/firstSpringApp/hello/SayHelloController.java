package com.saadne.firstSpringApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SayHelloController {
	
	@RequestMapping("say-hello")
	public String sayHello() {
		return "index";
	}

}
