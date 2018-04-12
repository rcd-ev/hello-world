package com.rc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@GetMapping
	@RequestMapping("/")
	public String mainPage() {
		return "home";
	}
}
