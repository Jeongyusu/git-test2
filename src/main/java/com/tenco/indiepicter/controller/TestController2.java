package com.tenco.indiepicter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController2 {

	@GetMapping("/main")
	public String main() {
		return "hi";
	}
	
}
