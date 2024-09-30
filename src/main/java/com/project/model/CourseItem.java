package com.project.model;

public class CourseItem {
	private int courseId;
	private String courseName;
	private String categoryName;

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
}