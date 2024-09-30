package com.project.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.model.*;

@Controller
public class AttendanceController {
	
	@Autowired
	private AttendanceDAO attendanceDAO;
	
	@GetMapping("/attendanceCalendar")
	public String attendanceCalendarHandler() {
		return "attendanceCalendar";
	}
	
	@GetMapping("/attendanceDetail")
	public String attendanceDetailHandler() {
		return "attendanceDetail";
	}
	
	@GetMapping("/currentAttendance")
	public String currentAttendanceHandler(Model model) {
		/*일단 2로 둠*/
		List<MemberDO> memberList = attendanceDAO.selectAllMemberByCourse(2);
		
		model.addAttribute("memberList",memberList);
		return "currentAttendance";
	}
	
	@GetMapping("/setAttendance")
	public String setAttendanceHandler() {
		return "setAttendance";
	}
	
	
		
}
