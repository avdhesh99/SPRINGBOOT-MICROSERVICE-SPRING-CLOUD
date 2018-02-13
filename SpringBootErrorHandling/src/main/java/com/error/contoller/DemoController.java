package com.error.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@RequestMapping("/test")
	public void demoTest() {
		
		throw new RuntimeException("Demo test exception");
	
	}

}
