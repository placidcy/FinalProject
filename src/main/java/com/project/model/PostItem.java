package com.project.model;

import java.sql.Array;

public class PostItem {
	private int postId;
	private String postTitle;
	private String postContents;
	private String regdate;
	private String attachments;

	public PostItem() {
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContents() {
		return postContents;
	}

	public void setPostContents(String postContents) {
		this.postContents = postContents;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String string) {
		this.attachments = string;
	}
}
