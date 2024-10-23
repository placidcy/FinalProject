package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.dao.UserRoleDAO;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleDAO userRoleDAO;

    public Integer getUserRole(int memberId) {
        return userRoleDAO.getUserRoleById(memberId);
    }
}
