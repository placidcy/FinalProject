package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.CourseDAO;
import com.project.model.CourseDO;
import com.project.model.MemberDAO;
import com.project.model.MemberDO;
import com.project.model.dao.NoticeItemDAO;
import com.project.model.response.LoginResponse;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	@Autowired
	private NoticeItemDAO noticeDao;

	@Autowired
	private CourseDAO courseDao;

    @Autowired
    private MemberDAO memberDao;
	
	@GetMapping("/adminMain")
	public String adminMainHandler(HttpSession session, Model model,
			@RequestParam(name = "page", defaultValue = "1", required = false) String page) {
		LoginResponse auth = (LoginResponse) session.getAttribute("auth");
		if (auth == null || auth.getM_role() != 0) {
			return "redirect:/login";
		}
		model.addAttribute("noticeList", noticeDao.selectAll(1, 3));

//        List<CourseDO> courseList = courseDao.selectAllCourses();
		List<CourseDO> courseList = courseDao.selectAllCourses(Integer.parseInt(page));
		int size = courseDao.getSize(courseDao.getAllCoursesCount(), 10);

		model.addAttribute("courseList", courseList);
		model.addAttribute("page", page);
		model.addAttribute("size", size);

		model.addAttribute("menu", "adminMain");
		return "adminMain";

	}

    @GetMapping("/instructorManagement")
    public String instructorManagementHandler(HttpSession session, Model model) {
        LoginResponse auth = (LoginResponse) session.getAttribute("auth");
        if (auth == null || auth.getM_role() != 0) {
            return "redirect:/login";
        }
        List<MemberDO> instructorList = memberDao.getAllInstructors(); // 모든 강사 조회
        model.addAttribute("instructorList", instructorList);

        model.addAttribute("menu", "instructorManagement");
        return "instructorManagement";
    }

    @PostMapping("/issueInstructorId")
    @ResponseBody
    public String issueInstructorHandler(
    		@RequestParam("name") String name,
    		@RequestParam("email") String email,
    		@RequestParam("department") String department,
    		@RequestParam("tel") String tel) {
        try {
            MemberDO newInstructor = new MemberDO();
            newInstructor.setM_name(name);
            newInstructor.setM_email(email);
            newInstructor.setM_dept(department);
            newInstructor.setM_tel(tel);
            newInstructor.setM_role(1); 

            memberDao.insertMember(newInstructor);

            return "{\"success\": true}";
        } catch (Exception e) {
            return "{\"success\": false}";
        }
    }

}        