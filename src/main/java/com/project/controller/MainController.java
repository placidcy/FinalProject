package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.project.service.MainSO;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	MainSO mainSO;

	@GetMapping("/")
	public String getMain(org.springframework.ui.Model model) {
		// model.addAttribute("course", mainSO.selectCourseItems(3, 1));
		// model.addAttribute("notice", mainSO.selectNoticeItems());

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
