package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.model.CourseNoticeItem;
import com.project.model.dao.CourseNoticeDAO;

public class CourseNoticeService {
	@Autowired
    private CourseNoticeDAO courseNoticeDAO; // DAO 주입

    public List<CourseNoticeItem> selectAll(int page, int limit) {
        int startNum = (page - 1) * limit + 1;
        int endNum = startNum + limit - 1;
        return courseNoticeDAO.selectAll(startNum, endNum); // DAO 호출
    }

    public int getCount() {
        return courseNoticeDAO.getCount(); // 공지사항 수를 가져오는 메서드
    }
}
