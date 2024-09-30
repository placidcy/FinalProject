package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
	@GetMapping("/postDetail")
	public String postDetailHandler() {
		return "postDetail";
	}
	
	@GetMapping("/postForm")
	public String postFormHandler() {
		return "postForm";
	}
	
	@GetMapping("/home")
	public String course_homeHandler() {
		return "course_home";
	}
	
}
