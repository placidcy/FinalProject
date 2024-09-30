package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

	@GetMapping("/home")
	public String course_homeHandler() {
		return "course_home";
	}
	
	@GetMapping("/alert")
	public String alertHandler() {
		return "alert";
	}
	
}
