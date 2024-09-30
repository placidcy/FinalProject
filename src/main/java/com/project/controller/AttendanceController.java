package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AttendanceController {
	@GetMapping("/attendanceCalendar")
	public String attendanceCalendarHandler() {
		return "attendanceCalendar";
	}
	
	@GetMapping("/attendanceDetail")
	public String attendanceDetailHandler() {
		return "attendanceDetail";
	}
	
	@GetMapping("/currentAttendance")
	public String currentAttendanceHandler() {
		return "currentAttendance";
	}
	
	@GetMapping("/setAttendance")
	public String setAttendanceHandler() {
		return "setAttendance";
	}
		
}
