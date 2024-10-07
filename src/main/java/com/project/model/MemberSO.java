package com.project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.request.LoginRequest;
import com.project.model.request.SignupRequest;

@Service
public class MemberSO {
	
	@Autowired
	private MemberDAO memberDao;
	
	public MemberSO() {
		
	}
	
	@Transactional
	public void signupStudent(SignupRequest req) {
		MemberDO newMember = new MemberDO();
		
		newMember.setMember_id(req.getMember_id());
		newMember.setM_acctid(req.getM_acctid());
		newMember.setM_acctpwd(req.getM_acctpwd());
		newMember.setM_name(req.getM_name());
		newMember.setM_email(req.getM_email());
		newMember.setM_tel(req.getM_tel());
		newMember.setM_dept(req.getM_dept());
        
        // 학생 기본값 설정
		newMember.setM_role(1);
        newMember.setM_status(1);
		
		memberDao.insertMember(newMember);
	}
	
	public void login(LoginRequest req) {
		MemberDO member = new MemberDO();
	}
	
	// 중복되지 않은 아이디일 때 true 반환
	public boolean isM_acctidDuplicate(String m_acctid) {
		return !memberDao.duplicateCheckM_acctid(m_acctid);
	}
	
	// 중복되지 않은 이메일이면 true
	public boolean isM_emailDuplicate(String m_email) {
		return !memberDao.duplicateCheckM_email(m_email);
	}
}
