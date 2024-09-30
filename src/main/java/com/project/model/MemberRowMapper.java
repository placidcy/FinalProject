package com.project.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class MemberRowMapper implements RowMapper<MemberDO> {
    @Override
    public MemberDO mapRow(ResultSet rs, int rowNum) throws SQLException {
    	MemberDO member = new MemberDO();
        member.setMember_id(rs.getInt("member_id"));
        member.setM_name(rs.getString("m_name"));
        member.setM_acctid(rs.getString("m_acctid"));
        member.setM_acctpwd(rs.getString("m_acctpwd"));
        member.setM_tel(rs.getString("m_tel"));
        member.setM_dept(rs.getString("m_dept"));
        member.setM_pfp(rs.getString("m_pfp"));
        member.setM_status(rs.getInt("m_status"));
        member.setM_role(rs.getInt("m_role"));
        
        return member;
    }
}
