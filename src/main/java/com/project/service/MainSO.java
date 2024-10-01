package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.CourseItem;
import com.project.model.NoticeItem;
import com.project.model.dao.CourseDAO;
import com.project.model.dao.NoticeDAO;

@Service
public class MainSO extends ItemSO {
	@Autowired
	private CourseDAO courseDAO;
	@Autowired
	private NoticeDAO noticeDAO;

	public List<CourseItem> selectByMemberId(int memberId, int page) {
		int limit = 10;
		return courseDAO.selectByMemberId(memberId, this.getStartNum(page, limit), this.getEndNum(page, limit));
	}

	public int getSizeByMemberId(int memberId) {
		int limit = 10;
		return this.getSize(courseDAO.getCountByMemberId(memberId), limit);
	}

	public List<NoticeItem> selectNoticeItems(int page) {
		int limit = 10;
		return noticeDAO.selecNoticeItems(this.getStartNum(page, limit), this.getEndNum(page, limit));
	}

	public List<NoticeItem> selectNoticeItems(int startNum, int endNum) {
		return noticeDAO.selecNoticeItems(startNum, endNum);
	}

	public int getSize() {
		int limit = 10;
		return this.getSize(noticeDAO.getCount(), limit);
	}
}