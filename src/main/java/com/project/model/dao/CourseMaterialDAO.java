package com.project.model.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.model.CourseMaterialDO;
import com.project.model.CourseMaterialRowMapper;

@Repository
public class CourseMaterialDAO {
    private JdbcTemplate jdbcTemplate;

    public CourseMaterialDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public List<CourseMaterialDO> getCourseMaterials(int courseId) {
        String sql = "SELECT to_char(p_regdate, 'YYYY-MM-DD HH24:MI:SS') as p_regdate, p_title, post_id " +
                     "FROM final_course_post " +
                     "WHERE course_id = ? AND type_id = 2";
        
        List<CourseMaterialDO> materials = this.jdbcTemplate.query(sql, new CourseMaterialRowMapper(), courseId);
        
        String attachmentSql = "SELECT p_attm FROM final_post_attm WHERE post_id = ?";
        
        for (CourseMaterialDO material : materials) {
            List<String> attachments = this.jdbcTemplate.queryForList(attachmentSql, String.class, material.getPostId());
            material.setAttachments(attachments);
        }
        
        return materials;
    }
}
