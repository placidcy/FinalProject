package com.project.model;

public class CourseItem {
	private int courseId;
	private String courseName;
	private String categoryName;
	private int limits;
	private int count;
	private String startDate;
	private String endDate;

	public CourseItem() {

	}

	public CourseItem(int courseId, String courseName, String categoryName) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.categoryName = categoryName;
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

}