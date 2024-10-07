package com.project.model;

import java.time.LocalDateTime;

public class AttendanceRequest {
	private int student_id;
	private LocalDateTime req_date;
	private LocalDateTime a_date;
	private LocalDateTime l_sdate;
	private LocalDateTime l_edate;
	private String contents;
	private String attm;
	private String l_reason;
	private int a_status;
	private int r_status;
	
	public AttendanceRequest() {
	}
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public LocalDateTime getReq_date() {
		return req_date;
	}
	public void setReq_date(LocalDateTime req_date) {
		this.req_date = req_date;
	}
	public LocalDateTime getA_date() {
		return a_date;
	}
	public void setA_date(LocalDateTime a_date) {
		this.a_date = a_date;
	}
	public LocalDateTime getL_sdate() {
		return l_sdate;
	}
	public void setL_sdate(LocalDateTime l_sdate) {
		this.l_sdate = l_sdate;
	}
	public LocalDateTime getL_edate() {
		return l_edate;
	}
	public void setL_edate(LocalDateTime l_edate) {
		this.l_edate = l_edate;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getAttm() {
		return attm;
	}
	public void setAttm(String attm) {
		this.attm = attm;
	}

	public String getL_reason() {
		return l_reason;
	}

	public void setL_reason(String l_reason) {
		this.l_reason = l_reason;
	}
	

	public int getA_status() {
		return a_status;
	}

	public void setA_status(int a_status) {
		this.a_status = a_status;
	}

	public int getR_status() {
		return r_status;
	}

	public void setR_status(int r_status) {
		this.r_status = r_status;
	}
	
	public String getStatus(int a_status) {
		String result ="";
		if(a_status == 3) {
			result="지각";
		}else if(a_status == 2) {
			result="결석";
		}
		
		return result;
	}
	
	public String getRstatus(int r_status) {
		String result ="요청";
		if(r_status == 1) {
			result="승인";
		}else if(r_status == 2) {
			result="거절";
		}
		return result;
	}
	
	public String getZero(int value) {
		String result = Integer.toString(value);
		if(value<10) {
			result = "0" + result;
		}
		return result;

	}
	
	
	
	
}
