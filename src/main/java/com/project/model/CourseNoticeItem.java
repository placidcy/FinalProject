package com.project.model;

public class CourseNoticeItem extends CourseNoticePostItem {
	private int target;

	public CourseNoticeItem() {
		super();
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public int getNoticeId() {
		return super.getPostId();
	}

	public void setNoticeId(int noticeId) {
		super.setPostId(noticeId);
	}

	public String getNoticeTitle() {
		return super.getNoticeTitle();
	}

	public void setNoticeTitle(String noticeTitle) {
		super.setNoticeTitle(noticeTitle);
	}

	public String getNoticeContents() {
		return super.getNoticeContents();
	}

	public void setNoticeContents(String noticeContents) {
		super.setNoticeContents(noticeContents);
	}

	public String getRegDate() {
		return super.getRegDate();
	}

	public void setRegDate(String regdate) {
		super.setRegDate(regdate);
	}

	public String getAttachment() {
		return super.getAttachment();
	}

	public void setAttachment(String attachment) {
		super.setAttachment(attachment);
	}
}