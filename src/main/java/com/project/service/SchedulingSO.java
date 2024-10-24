package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.project.model.dao.CourseItemDAO;

@Service
public class SchedulingSO {
	@Autowired
	CourseItemDAO dao;

	@Scheduled(cron = "0 0 0 * * ?") // 매일 자정에 실행
	public void performTaskUsingCron() {
		int insertResult, updateResult;
		System.out.println("Scheduled task using cron executed at " + System.currentTimeMillis());

		try {
			insertResult = dao.insertDailyRecords();
			System.out.println("Insert: " + (insertResult > 0));
		} catch (Exception e) {
			System.out.println("오류: 출석 데이터 생성 과정에서 오류가 발생하였습니다.");
		}

		try {
			updateResult = dao.updateDailyRecords();
			System.out.println("Update: " + (updateResult > 0));
		} catch (Exception e) {
			System.out.println("오류: 출석 데이터 갱신 과정에서 오류가 발생하였습니다.");
		}
	}
}
