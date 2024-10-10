package com.project.model;

import java.time.LocalDateTime;

public class AttendanceCalendar {

	private LocalDateTime dt;
	private String d;
	private int req_type;
	private int a_status;
	private int r_status;
	
	public AttendanceCalendar() {
		
	}

	public LocalDateTime getDt() {
		return dt;
	}

	public void setDt(LocalDateTime dt) {
		this.dt = dt;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public int getReq_type() {
		return req_type;
	}

	public void setReq_type(int req_type) {
		this.req_type = req_type;
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
	
	
	
	
	
}

