package com.project.model;

import java.time.LocalDateTime;

public class CourseReg {
	
	private String m_name;
	private String m_dept;
	private int c_regstatus;
	private int member_id;

	public CourseReg() {
		
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

	public int getC_regstatus() {
		return c_regstatus;
	}

	public void setC_regstatus(int c_regstatus) {
		this.c_regstatus = c_regstatus;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	
	
	
}
