package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.AttendanceCalendar;
import com.project.model.AttendanceDAO;
import com.project.model.AttendanceSO;
import com.project.model.response.LoginResponse;

import jakarta.servlet.http.HttpSession;

@RestController
public class AttendanceRestController {
	
	@Autowired
	AttendanceDAO attendanceDAO;
	
	@GetMapping("/getStudentCalendar")
	public List<AttendanceCalendar> getStudentCalendarHandler(HttpSession session, Model model, @RequestParam(value="c_year") int c_year, @RequestParam(value="c_month") int c_month) {
		LoginResponse auth = (LoginResponse) session.getAttribute("auth");
		List<AttendanceCalendar> attCal=null;
		if(auth.getM_role()==1) {
		
		int course_id = (int) session.getAttribute("currentId");

		
		attCal = attendanceDAO.getStudentAttendanceCalendar(attendanceDAO.getStudentId(auth.getMember_id(), course_id), c_year, c_month);

		model.addAttribute("menu", "attendanceCalendar");

		}
		return attCal; 
		
	}
	
	@GetMapping("/getInstructorCalendar")
	public List<AttendanceCalendar> getInstructorCalendarHandler(HttpSession session, Model model, @RequestParam(value="c_year") int c_year, @RequestParam(value="c_month") int c_month) {
		LoginResponse auth = (LoginResponse) session.getAttribute("auth");
		List<AttendanceCalendar> attCal=null;
		if(auth.getM_role()==2) {
		
		int course_id = (int) session.getAttribute("currentId");

		
		attCal = attendanceDAO.getStudentAttendanceCalendar(attendanceDAO.getStudentId(auth.getMember_id(), course_id), c_year, c_month);

		model.addAttribute("menu", "courseAttend");

		}
		return attCal; 
		
	}
	
	
	
}
