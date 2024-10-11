package com.project.model;

public class Timetable {
	private int studentId;
	private String regDate;
	private String cinTime;
	private String retTime;
	private String soutTime;
	private String coutTime;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getCinTime() {
		return cinTime;
	}

	public void setCinTime(String cinTime) {
		this.cinTime = cinTime;
	}

	public String getRetTime() {
		return retTime;
	}

	public void setRetTime(String retTime) {
		this.retTime = retTime;
	}

	public String getSoutTime() {
		return soutTime;
	}

	public void setSoutTime(String soutTime) {
		this.soutTime = soutTime;
	}

	public String getCoutTime() {
		return coutTime;
	}

	public void setCoutTime(String coutTime) {
		this.coutTime = coutTime;
	}

}