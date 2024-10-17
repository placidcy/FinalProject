package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.project.model.CourseBoardDO;
import com.project.model.dao.CourseBoardDAO;

@Service
public class CourseBoardService {
	private final JdbcTemplate jdbcTemplate;
	
	public CourseBoardService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    private CourseBoardDAO courseBoardDAO;

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
}