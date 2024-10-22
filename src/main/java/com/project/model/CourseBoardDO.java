package com.project.model;

import java.util.List;

public class CourseBoardDO {
    private int postId;
    private String title;
    private String contents;
    private String regDate;
    private int typeId;
    private List<String> attachments;
    
    public CourseBoardDO() {
    }
    
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
    
    public List<String> getAttachments() {
    	return attachments;
    }
    
    public void setAttachments(List<String> attachments) {
    	this.attachments = attachments;
    }
}