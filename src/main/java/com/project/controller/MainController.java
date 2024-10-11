
package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.NoticeItem;
import com.project.service.MainSO;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	MainSO mainSO;
	String viewPath;

	@GetMapping("/")
	public String getMain(Model model, @RequestParam(required = false, defaultValue = "1", name = "page") String page) {
		/*
		 * testTarget: 로그인 연결 이전 테스트를 목적으로 사용하는 변수(1: 회원 계정으로 로그인, 2: 강사 계정으로 로그인)
		 */
		int testTarget = 1;
		testTarget = 2;

		int memberId;

		if (testTarget == 1) {
			memberId = 3;

			model.addAttribute("course", mainSO.selectByMemberId(memberId, Integer.parseInt(page)));
			model.addAttribute("notice", mainSO.selectNoticeItems(1, 5));
			model.addAttribute("size", mainSO.getSizeByMemberId(memberId));
			model.addAttribute("page", page);
			model.addAttribute("menu", "main");
			viewPath = "main/index";
		} else {
			memberId = 8;

			model.addAttribute("notice", mainSO.selectNoticeItems(1, 5));
			viewPath = "main/index_i";
		}

		return viewPath;
	}

	@GetMapping("/checkin")
	public String getChecin(Model model) {
		int memberId = 3;
		int studentId = mainSO.checkCourse(memberId);
		if (studentId != -1) {
			model.addAttribute("info", mainSO.getInfo(studentId));
			model.addAttribute("stats", mainSO.getStats(studentId));
			model.addAttribute("time", mainSO.getTimetable(studentId));
		}
		model.addAttribute("menu", "checkin");
		return "main/checkin";
	}

	@ResponseBody
	@GetMapping("/api/checkin/update")
	public boolean updateTimetable(@RequestParam(required = true, name = "keyword") String keyword) {
		int memberId = 3;
		int studentId = mainSO.checkCourse(memberId);

		return mainSO.updateTimetable(studentId, keyword) > 0;
	}

	@GetMapping("/register")
	public String getCourseRegisteration(Model model,
			@RequestParam(required = false, defaultValue = "1", name = "page") String page) {
		model.addAttribute("list", mainSO.selectByDates(Integer.parseInt(page)));
		model.addAttribute("size", mainSO.getSizeByDates());
		model.addAttribute("page", page);
		model.addAttribute("menu", "register");
		return "main/register";
	}

	@RequestMapping("/register/search")
	public String searchCourse(Model model,
			@RequestParam(required = false, defaultValue = "1", name = "page") String page,
			@RequestParam(required = true, name = "keyword") String keyword) {
		model.addAttribute("list", mainSO.selectByDates(keyword, Integer.parseInt(page)));
		model.addAttribute("size", mainSO.getSizeByDates(keyword));
		model.addAttribute("page", page);
		model.addAttribute("menu", "register");
		model.addAttribute("keyword", keyword);
		return "main/register_search";
	}

	@GetMapping("/notification")
	public String getNotifications(Model model) {
		model.addAttribute("menu", "alert");
		return "main/alert";
	}

	@GetMapping("/notice")
	public String getNotice(Model model,
			@RequestParam(required = false, defaultValue = "1", name = "page") String page) {
		model.addAttribute("list", mainSO.selectNoticeItems(Integer.parseInt(page)));
		model.addAttribute("size", mainSO.getSize());
		model.addAttribute("page", page);
		model.addAttribute("menu", "notice");
		return "main/notice";
	}

	@RequestMapping("/notice/search")
	public String searchNotice(Model model,
			@RequestParam(required = false, defaultValue = "1", name = "page") String page,
			@RequestParam(required = true, name = "keyword") String keyword) {
		model.addAttribute("list", mainSO.selectNoticeItems(Integer.parseInt(page), keyword));
		model.addAttribute("size", mainSO.getSize(keyword));
		model.addAttribute("page", page);
		model.addAttribute("menu", "notice");
		model.addAttribute("keyword", keyword);
		return "main/notice_search";
	}

	@ResponseBody
	@GetMapping("/api/notice/getItem")
	public NoticeItem getNoticeItem(@RequestParam(name = "noticeId") int noticeId) {
		return mainSO.selectOne(noticeId);
	}
}