package com.project.controller;
import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.SdkClientException;
import com.project.model.AttReq;
import com.project.model.AttendanceDAO;
import com.project.model.CourseDAO;
import com.project.model.InstructorCalendar;
import com.project.model.response.LoginResponse;
import com.project.service.*;

import jakarta.servlet.http.HttpSession;
@Controller
public class ImageUploadController {
	@Autowired
	ImageUploadSO uploadSO;
	
	@Autowired
	AttendanceDAO attendanceDAO;
	
	@Autowired
	CourseDAO courseDAO;
	
	@RequestMapping("/upload/testPage")
	public String test() {
		return "main/test";
	}
	@RequestMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam(name = "file", required = true) MultipartFile file)
			throws SdkClientException, IOException {
		return uploadSO.uploadFile(file);
	}
	
	@RequestMapping("/attRequest")
	public String attRequestHandler(HttpSession session, AttReq attReq) throws SdkClientException, IOException{
		LoginResponse auth = (LoginResponse )session.getAttribute("auth");
		if(auth.getM_role()==1) {
		int course_id = (int) session.getAttribute("currentId");
		attReq.setStudent_id(attendanceDAO.getStudentId(auth.getMember_id(), course_id));

		if(attReq.getAttm().isEmpty()) {
			attReq.setFileURL("noURL");
		}else {
			attReq.setFileURL(uploadSO.uploadFile(attReq.getAttm()).getBody());
		}

		attendanceDAO.insertAttendanceReq(attReq);
		
		return "redirect:/attendanceCalendar";
		}
		
		return "redirect:/" ;
	
	}
	
	@RequestMapping("attendWriteProcess")
	public String attendWriteProcessHandler(InstructorCalendar insCal, HttpSession session) {
		LoginResponse auth = (LoginResponse )session.getAttribute("auth");
		if(auth.getM_role()==2) {
			int course_id = (int) session.getAttribute("currentId");
			
			insCal.setSdate(insCal.getSdate().substring(0,10) + ' ' + insCal.getSdate().substring(11));
			insCal.setEdate(insCal.getEdate().substring(0,10) + ' ' +  insCal.getEdate().substring(11));

			courseDAO.insertInsSchedule(insCal, course_id, auth.getMember_id());
			return "redirect:/courseAttend" ;
		}
		
		return "redirect:/" ;
	}

	@RequestMapping("attendUpdateProcess")
	public String attendUpdateProcessHandler(InstructorCalendar insCal, HttpSession session) {
		LoginResponse auth = (LoginResponse )session.getAttribute("auth");
		if(auth.getM_role()==2) {
			insCal.setSdate(insCal.getSdate().substring(0,10) + ' ' + insCal.getSdate().substring(11));
			insCal.setEdate(insCal.getEdate().substring(0,10) + ' ' +  insCal.getEdate().substring(11));
			

			courseDAO.updateInsSchedule(insCal);
			return "redirect:/courseAttend" ;
		}
		
		return "redirect:/" ;
	}
}