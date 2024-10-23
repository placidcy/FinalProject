package com.project.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer getUserRoleById(int memberId) {
        String sql = "SELECT m_role FROM final_member WHERE member_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{memberId}, Integer.class);
    }
}
