package com.project.model;

public class NoticeItem {
	private int noticeId;
	private String noticeTitle;
	private String regdate;

	public NoticeItem() {
	}

	public int getNoticeId() {
		return noticeId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}