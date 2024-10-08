package com.project.model;

public class AttendanceResponse {
	private int r_status;
	private String r_details;
	private int reqType;
	private int student_id;
	private int response_id;
	private String date;
	
	public AttendanceResponse() {
		
	}

	public int getR_status() {
		return r_status;
	}

	public void setR_status(int r_status) {
		this.r_status = r_status;
	}

	public String getR_details() {
		return r_details;
	}

	public void setR_details(String r_details) {
		this.r_details = r_details;
	}

	public int getReqType() {
		return reqType;
	}

	public void setReqType(int reqType) {
		this.reqType = reqType;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getResponse_id() {
		return response_id;
	}

	public void setResponse_id(int response_id) {
		this.response_id = response_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
