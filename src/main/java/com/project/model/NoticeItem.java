package com.project.model;

public class NoticeItem extends PostItem {
	private int target;

	public NoticeItem() {
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
		return super.getPostTitle();
	}

	public void setNoticeTitle(String noticeTitle) {
		super.setPostTitle(noticeTitle);
	}

	public String getNoticeContents() {
		return super.getPostContents();
	}

	public void setNoticeContents(String noticeContents) {
		super.setPostContents(noticeContents);
	}
}