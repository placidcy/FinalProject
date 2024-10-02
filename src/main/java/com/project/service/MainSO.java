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

	/* 강의 관련 메소드 정의 */

	public List<CourseItem> selectByMemberId(int memberId, int page) {
		int limit = 10;
		return courseDAO.selectByMemberId(memberId, this.getStartNum(page, limit), this.getEndNum(page, limit));
	}

	public int getSizeByMemberId(int memberId) {
		int limit = 10;
		return this.getSize(courseDAO.getCountByMemberId(memberId), limit);
	}

	public List<CourseItem> selectByDates(int page) {
		int limit = 10;
		return courseDAO.selectByDates(this.getStartNum(page, limit), this.getEndNum(page, limit));
	}

	public List<CourseItem> selectByDates(String keyword, int page) {
		int limit = 10;
		return courseDAO.selectByDates(keyword, this.getStartNum(page, limit), this.getEndNum(page, limit));
	}

	public int getSizeByDates() {
		int limit = 10;
		return this.getSize(courseDAO.getCountByDates(), limit);
	}

	public int getSizeByDates(String keyword) {
		int limit = 10;
		return this.getSize(courseDAO.getCountByDates(keyword), limit);
	}

	/* 공지사항 관련 DAO 메소드 정의 */

	public List<NoticeItem> selectNoticeItems(int page) {
		int limit = 10;
		return noticeDAO.selectAll(this.getStartNum(page, limit), this.getEndNum(page, limit));
	}

	public List<NoticeItem> selectNoticeItems(int page, String keyword) {
		int limit = 10;
		return noticeDAO.selectByKeyword(keyword, this.getStartNum(page, limit), this.getEndNum(page, limit));
	}

	public List<NoticeItem> selectNoticeItems(int startNum, int endNum) {
		return noticeDAO.selectAll(startNum, endNum);
	}

	public NoticeItem selectOne(int noticeId) {
		return noticeDAO.selectOne(noticeId);
	}

	public int getSize() {
		int limit = 10;
		return this.getSize(noticeDAO.getCount(), limit);
	}

	public int getSize(String keyword) {
		int limit = 10;
		return this.getSize(noticeDAO.getCount(keyword), limit);
	}
}