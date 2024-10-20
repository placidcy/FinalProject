package com.project.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class MemberCleanSO {

    @Autowired
    private MemberDAO memberDao;

    @Scheduled(cron = "0 0 01 * * ?") // "초 분 시각 일 월 요일 연도"
    public void deleteInactiveMembers() {
        memberDao.deleteMemberInfo();
    }
}
