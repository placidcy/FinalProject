package com.project.controller;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
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
	
	/*추후 세션에 저장된 course_id 커맨드 객체나, RequestParam으로 받아오기*/
	/*강의 밑에 강사 밑에 학생을 조회해야할 듯 하다 강의 하나만으로는 강사가 구분 안 됨*/
	@GetMapping("/currentAttendance")
	public String currentAttendanceHandler(Model model) {
		List<StudentAttendanceDO> memberList = attendanceDAO.selectAllMemberAttendanceByCourse(2);
		model.addAttribute("memberList", memberList);
		
		return "currentAttendance";
	}
	
	@GetMapping("/setAttendance")
	public String setAttendanceHandler(Model model) {
		CourseScheduleDO courseDateInfo = attendanceDAO.getCourseDateInfo(2);
		
		model.addAttribute("courseDateInfo", courseDateInfo);
		return "setAttendance";
	}
	
	
		
}
