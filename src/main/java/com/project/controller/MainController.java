package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.service.MainSO;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	MainSO mainSO;

	@GetMapping("/")
	public String getMain(Model model, @RequestParam(required = false, defaultValue = "1", name = "page") String page) {
		int memberId = 3;
		model.addAttribute("course", mainSO.selectByMemberId(memberId, Integer.parseInt(page)));
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
	public String getCourseRegisteration(Model model,
			@RequestParam(required = false, defaultValue = "1", name = "page") String page) {
		model.addAttribute("list", mainSO.selectByDates(Integer.parseInt(page)));
		model.addAttribute("size", mainSO.getSizeByDates());
		model.addAttribute("page", page);

		return "main/register";
	}

	@GetMapping("/notification")
	public String getNotifications() {
		return "main/alert";
	}

	@GetMapping("/notice")
	public String getNotice(Model model,
			@RequestParam(required = false, defaultValue = "1", name = "page") String page) {
		model.addAttribute("list", mainSO.selectNoticeItems(Integer.parseInt(page)));
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
