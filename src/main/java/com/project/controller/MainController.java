package com.project.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MainController {
	@GetMapping("/")
	public String getMain() {
		return "main/index";
	}

	@GetMapping("/checkin")
	public String getChecin() {
		return "main/checkin";
	}

	@GetMapping("/register")
	public String getCourseRegisteration() {
		return "main/register";
	}

	@GetMapping("/notification")
	public String getNotifications() {
		return "main/alert";
	}

	@GetMapping("/notice")
	public String getNotice() {
		return "main/notice";
	}

	@GetMapping("/mypage")
	public String getMyPage() {
		return "main/mypage";
	}

	@GetMapping("/logout")
	public String logout() {
		return "redirect:/login";
	}
}
