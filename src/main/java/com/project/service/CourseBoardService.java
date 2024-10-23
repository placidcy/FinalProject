package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.project.model.CourseBoardDO;
import com.project.model.CourseMaterialDO;
import com.project.model.CourseMaterialRowMapper;
import com.project.model.dao.CourseBoardDAO;
import com.project.model.dao.CourseMaterialDAO;

@Service
public class CourseBoardService {
	private final JdbcTemplate jdbcTemplate;
	
	public CourseBoardService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    private CourseBoardDAO courseBoardDAO;
    
    @Autowired
    private CourseMaterialDAO courseMaterialDAO;

    public List<CourseBoardDO> getAllPosts(int courseId) {
        return courseBoardDAO.getAllPosts(courseId);
    }

    public CourseBoardDO getPost(int courseId, int postId) {
        return courseBoardDAO.getPost(courseId, postId);
    }
    
    public List<String> getAttachmentsByPostId(int postId) {
        String sql = "SELECT p_attm FROM final_post_attm WHERE post_id = ?";
        return this.jdbcTemplate.queryForList(sql, String.class, postId);
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