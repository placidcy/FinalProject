package com.project.model;

import java.util.Arrays;
import java.util.List;

public class CourseItem {
	private int courseId;
	private String courseName;
	private String categoryName;
	private int limits;
	private int count;
	private String startDate;
	private String endDate;
	private List<String> instList;
	private int dDay;
	private String qrCode;
	private String qrRegdate;
	private String qrEffdate;

	public CourseItem() {

	}

	public int getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getLimits() {
		return limits;
	}

	public void setLimits(int limits) {
		this.limits = limits;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<String> getInstList() {
		return instList;
	}

	public void setInstList(String instString) {
		this.instList = Arrays.asList(instString.split(","));
	}

	public int getdDay() {
		return dDay;
	}

	public void setdDay(int dDay) {
		this.dDay = dDay;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getQrRegdate() {
		return qrRegdate;
	}

	public void setQrRegdate(String qrRegdate) {
		this.qrRegdate = qrRegdate;
	}

	public String getQrEffdate() {
		return qrEffdate;
	}

	public void setQrEffdate(String qrEffdate) {
		this.qrEffdate = qrEffdate;
	}
}