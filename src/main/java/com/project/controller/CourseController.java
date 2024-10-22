package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.model.CourseBoardDO;
import com.project.model.CourseMaterialDO;
import com.project.model.CourseMaterialWriteDO;
import com.project.model.dao.CourseMaterialWriteDAO;
import com.project.model.response.LoginResponse;
import com.project.service.CourseBoardService;
import com.project.service.UserRoleService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CourseController {

	@Autowired
	private CourseBoardService courseBoardService;

	@Autowired
	private CourseMaterialWriteDAO courseMaterialWriteDAO;
	
    @Autowired
    private UserRoleService userRoleService;

	@GetMapping("/home")
	public String course_homeHandler() {
		return "course_home";
	}

	@GetMapping("/alert")
	public String alertHandler() {
		return "alert";
	}

	@GetMapping("acceptanceManagement")
	public String acceptance_managementHandler() {
		return "acceptance_management";
	}

	@GetMapping("calendarForm")
	public String calendarFormHandler() {
		return "calendarForm";
	}

	// 리액트 테스트
//	@GetMapping("/reactTest")
//    public String reactTestHandler() {
//        return "reactTest";
//    }

	@GetMapping("/CourseBoard")
	public String goToCourseBoard(HttpSession session, HttpServletRequest request) {
	    Integer courseId = (Integer) session.getAttribute("currentId");
	    LoginResponse loginResponse = (LoginResponse) session.getAttribute("auth");
	    Integer userId = loginResponse.getMember_id();
	    Integer userRole = loginResponse.getM_role();

	    if (courseId != null && userId != null) {
	        String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), "");
	        String redirectUrl = baseUrl.replace(":" + request.getServerPort(), ":3000");

	        return "redirect:" + redirectUrl + "/CourseBoard?courseId=" + courseId + "&userId=" + userId + "&role=" + userRole;
	    }
	    return "redirect:/error";
	}

	@GetMapping("/api/coursesBoard/{courseId}")
	@ResponseBody
	public List<CourseBoardDO> getAllPosts(@PathVariable("courseId") int courseId) {
		List<CourseBoardDO> posts = courseBoardService.getAllPosts(courseId);
		for (CourseBoardDO post : posts) {
			List<String> attachments = courseBoardService.getAttachmentsByPostId(post.getPostId());
			post.setAttachments(attachments);
		}
		return posts;
	}

	@GetMapping("/api/courseMaterials/{courseId}")
	@ResponseBody
	public List<CourseMaterialDO> getCourseMaterials(@PathVariable("courseId") int courseId) {
		List<CourseMaterialDO> materials = courseBoardService.getCourseMaterials(courseId);
		return materials;
	}

	@PostMapping("/api/courseMaterials")
	public ResponseEntity<String> uploadMaterials(
	        @RequestParam("title") String title,
	        @RequestParam("courseId") int courseId,
	        @RequestParam(value = "userId", required = false) Integer userId,
	        @RequestParam("attachments") List<MultipartFile> attachments,
	        HttpSession session) {
		
	    if (userId == null) {
	        userId = ((LoginResponse) session.getAttribute("auth")).getMember_id();
	    }
	    
	    CourseMaterialWriteDO courseMaterial = new CourseMaterialWriteDO();
	    courseMaterial.setTitle(title);
	    courseMaterial.setMemberId(userId);
	    courseMaterial.setCourseId(courseId);

	    int postId = courseMaterialWriteDAO.savePost(courseMaterial);
	    for (MultipartFile file : attachments) {
	        String fileName = file.getOriginalFilename();
	        courseMaterialWriteDAO.saveAttachment(postId, fileName);
	    }

	    return ResponseEntity.ok("자료가 성공적으로 업로드되었습니다.");
	}

}
