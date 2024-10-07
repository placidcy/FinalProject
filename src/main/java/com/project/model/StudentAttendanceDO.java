package com.project.model;

import java.time.LocalDateTime;

public class StudentAttendanceDO {
	private int student_id;
	private String m_name;
	private String m_dept;
	private String m_tel;
	private Long c;
	private Long ab;
	private Long l;
	private Long d;
	private LocalDateTime a_date;
	private int a_status;
	private String a_request;

	public StudentAttendanceDO() {
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_dept() {
		return m_dept;
	}

	public void setM_dept(String m_dept) {
		this.m_dept = m_dept;
	}

	public String getM_tel() {
		return m_tel;
	}

	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}

	public Long getC() {
		return c;
	}

	public void setC(Long c) {
		this.c = c;
	}

	public Long getAb() {
		return ab;
	}

	public void setAb(Long ab) {
		this.ab = ab;
	}

	public Long getL() {
		return l;
	}

	public void setL(Long l) {
		this.l = l;
	}
	
	public Long getD() {
		return d;
	}

	public void setD(Long d) {
		this.d = d;
	}

	public LocalDateTime getA_date() {
		return a_date;
	}

	public void setA_date(LocalDateTime a_date) {
		this.a_date = a_date;
	}

	public int getA_status() {
		return a_status;
	}

	public void setA_status(int a_status) {
		this.a_status = a_status;
	}
	
	public String getA_request() {
		return a_request;
	}

	public void setA_request(String a_request) {
		this.a_request = a_request;
	}

	public String getZero(int value) {
		String result = Integer.toString(value);
		if(value<10) {
			result = "0" + result;
		}
		return result;

	}
	
	public String getEmblem(int status) {
		String result = "○";
		if(status==3) {
			result = "▲";
		}else if(status==2) {
			result = "X";
		}else if(status == 0) {
			result = "";
		}
		
		return result;
	}
	
}
