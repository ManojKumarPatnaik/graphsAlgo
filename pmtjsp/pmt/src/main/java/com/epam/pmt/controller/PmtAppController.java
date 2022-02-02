package com.epam.pmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PmtAppController {
	
	@GetMapping("")
	public String home() {
		return "welcome";
	}
	


}
