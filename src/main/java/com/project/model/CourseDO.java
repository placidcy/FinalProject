package com.project.model;

import java.time.LocalDateTime;

public class CourseDO {
	private int course_id;
	private int category_id;
	private String c_name;
	private String c_desc;
	private LocalDateTime c_sdate;
	private LocalDateTime c_edate;
	private int c_limits;
	private int c_prsscore;
	private int c_absscore;
	private int c_trdscore;
	
	public CourseDO() {	
	}
	
	
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_desc() {
		return c_desc;
	}
	public void setC_desc(String c_desc) {
		this.c_desc = c_desc;
	}
	
	public LocalDateTime getC_sdate() {
		return c_sdate;
	}


	public void setC_sdate(LocalDateTime c_sdate) {
		this.c_sdate = c_sdate;
	}


	public LocalDateTime getC_edate() {
		return c_edate;
	}


	public void setC_edate(LocalDateTime c_edate) {
		this.c_edate = c_edate;
	}


	public int getC_limits() {
		return c_limits;
	}
	public void setC_limits(int c_limits) {
		this.c_limits = c_limits;
	}
	public int getC_prsscore() {
		return c_prsscore;
	}
	public void setC_prsscore(int c_prsscore) {
		this.c_prsscore = c_prsscore;
	}
	public int getC_absscore() {
		return c_absscore;
	}
	public void setC_absscore(int c_absscore) {
		this.c_absscore = c_absscore;
	}
	public int getC_trdscore() {
		return c_trdscore;
	}
	public void setC_trdscore(int c_trdscore) {
		this.c_trdscore = c_trdscore;
	}
	
	
	

}
