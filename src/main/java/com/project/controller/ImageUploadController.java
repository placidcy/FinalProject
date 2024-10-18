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
import com.project.model.response.LoginResponse;
import com.project.service.*;

import jakarta.servlet.http.HttpSession;
@Controller
public class ImageUploadController {
	@Autowired
	ImageUploadSO uploadSO;
	
	@Autowired
	AttendanceDAO attendanceDAO;
	
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
}