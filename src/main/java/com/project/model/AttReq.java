package com.project.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class AttReq {
	private int student_id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate a_date;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate l_sdate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate l_edate;
	private String contents;
	private String l_reason;
	private MultipartFile attm;
	private String fileURL;
	private int req_type;
	
	public AttReq() {
	}
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public MultipartFile getAttm() {
		return attm;
	}
	public void setAttm(MultipartFile attm) {
		this.attm = attm;
	}

	public String getL_reason() {
		return l_reason;
	}

	public void setL_reason(String l_reason) {
		this.l_reason = l_reason;
	}
	
	public int getReq_type() {
		return req_type;
	}

	public void setReq_type(int req_type) {
		this.req_type = req_type;
	}

	public LocalDate getA_date() {
		return a_date;
	}

	public void setA_date(LocalDate a_date) {
		this.a_date = a_date;
	}

	public LocalDate getL_sdate() {
		return l_sdate;
	}

	public void setL_sdate(LocalDate l_sdate) {
		this.l_sdate = l_sdate;
	}

	public LocalDate getL_edate() {
		return l_edate;
	}

	public void setL_edate(LocalDate l_edate) {
		this.l_edate = l_edate;
	}

	public String getFileURL() {
		return fileURL;
	}

	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}
	
	

	
	
	
}
