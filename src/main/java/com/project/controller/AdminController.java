package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.model.CourseDAO;
import com.project.model.CourseDO;
import com.project.model.dao.NoticeItemDAO;
import com.project.model.response.LoginResponse;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
    @Autowired
    private NoticeItemDAO noticeDao;

    @Autowired
    private CourseDAO courseDao;

    @GetMapping("/adminMain")
    public String adminMainHandler(HttpSession session, Model model) {
        LoginResponse auth = (LoginResponse) session.getAttribute("auth");
        if (auth == null || auth.getM_role() != 0) {
            return "redirect:/login";
        }
        model.addAttribute("noticeList", noticeDao.selectAll(0, 3));
        
        List<CourseDO> courseList = courseDao.selectAllCourses();
        model.addAttribute("courseList", courseList);
        
        model.addAttribute("menu", "adminMain");
        return "adminMain";
    }

    @GetMapping("/instructorManagement")
    public String instructorManagementHandler(HttpSession session, Model model) {
        LoginResponse auth = (LoginResponse) session.getAttribute("auth");
        if (auth == null || auth.getM_role() != 0) {
            return "redirect:/login";
        }
        model.addAttribute("menu", "instructorManagement");
        return "instructorManagement";
    }
}