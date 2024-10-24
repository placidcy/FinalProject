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

//    @Scheduled(cron = "0 0/5 * * * ?") // 5분마다 작동
//    public void deleteInactiveMembers() {
//        memberDao.deleteMemberInfo();
//    }
}
