package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.project.model.dao.CourseItemDAO;

@Service
public class SchedulingSO {
	@Autowired
	CourseItemDAO dao;

	@Scheduled(cron = "0 0 12 * * ?") // 매일 정오에 실행
	public void performTaskUsingCron() {
		int insertResult, updateResult;
		System.out.println("Scheduled task using cron executed at " + System.currentTimeMillis());

		insertResult = dao.insertDailyRecords();
		System.out.println("Insert: " + (insertResult > 0));

		updateResult = dao.updateDailyRecords();
		System.out.println("Insert: " + (updateResult > 0));
	}
}
