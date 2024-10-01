package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.project.model.CourseItem;
import com.project.service.MainSO;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	MainSO mainSO;

	@GetMapping("/")
	public String getMain(Model model) {
		int memberId = 3;
		int page = 1;

		model.addAttribute("course", mainSO.selectByMemberId(memberId, page));
		model.addAttribute("notice", mainSO.selectNoticeItems(1, 5));
		model.addAttribute("size", mainSO.getSizeByMemberId(memberId));
		model.addAttribute("page", page);

		return "main/index";
	}

	@GetMapping("/checkin")
	public String getChecin() {
		return "main/checkin";
	}

	@GetMapping("/register")
	public String getCourseRegisteration(Model model) {
		int page = 1;

		model.addAttribute("list", mainSO.selectByDates(page));
		model.addAttribute("size", mainSO.getSizeByDates());
		model.addAttribute("page", page);

		return "main/register";
	}

	@GetMapping("/notification")
	public String getNotifications() {
		return "main/alert";
	}

	@GetMapping("/notice")
	public String getNotice(Model model) {
		int page = 1;

		model.addAttribute("list", mainSO.selectNoticeItems(page));
		model.addAttribute("size", mainSO.getSize());
		model.addAttribute("page", page);

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
