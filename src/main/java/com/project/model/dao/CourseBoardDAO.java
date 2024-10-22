package com.project.model.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.model.CourseBoardDO;
import com.project.model.CourseBoardRowMapper;

@Repository
public class CourseBoardDAO {

    private JdbcTemplate jdbcTemplate;

    public CourseBoardDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<CourseBoardDO> getAllPosts(int courseId) {
        String sql = "SELECT to_char(p_regdate, 'YYYY-MM-DD HH24:MI:SS') as p_regdate, p_title, p_contents, post_id, type_id " +
                     "FROM final_course_post " +
                     "WHERE course_id = ?";
        
        List<CourseBoardDO> posts = this.jdbcTemplate.query(sql, new CourseBoardRowMapper(), courseId);
        
        String attachmentSql = "SELECT p_attm FROM final_post_attm WHERE post_id = ?";
        
        for (CourseBoardDO post : posts) {
            List<String> attachments = this.jdbcTemplate.queryForList(attachmentSql, String.class, post.getPostId());
            post.setAttachments(attachments);
        }

        return posts;
    }

    public CourseBoardDO getPost(int courseId, int postId) {
        String sql = "SELECT to_char(p_regdate, 'YYYY-MM-DD HH:MI:SS') as p_regdate, p_title, p_contents, post_id, type_id " +
                     "FROM final_course_post " +
                     "WHERE course_id = ? AND post_id = ?";
        
        return this.jdbcTemplate.queryForObject(sql, new CourseBoardRowMapper(), courseId, postId);
    }
}
