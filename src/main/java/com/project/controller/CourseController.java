package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.project.model.CourseBoardDO;
import com.project.model.CourseDAO;
import com.project.model.CourseDO;
import com.project.model.CourseMaterialDO;
import com.project.model.CourseMaterialWriteDO;
import com.project.model.CourseReg;
import com.project.model.CourseSO;

import com.project.model.InstructorCalendar;
import com.project.model.StudentAttendanceDO;
import com.project.model.dao.CourseNoticeDAO;

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
    
    @Autowired
    private CourseSO courseSO;
    @Autowired
    private CourseDAO courseDAO;
    
	@GetMapping("/home")
	public String course_homeHandler(HttpSession session, Model model) {
		LoginResponse auth = (LoginResponse) session.getAttribute("auth");

		Integer course_id = (Integer) session.getAttribute("currentId"); // 세션에서 course_id 가져옴
		if (course_id == null) {
			model.addAttribute("error", "강의 ID가 존재하지 않습니다.");
			return "error";
		}

		CourseDO course = courseSO.getCourseDetails(course_id);

		model.addAttribute("c_name", course.getC_name());
		model.addAttribute("c_desc", course.getC_desc());
		model.addAttribute("c_sdate", course.getC_sdateFormatted());
		model.addAttribute("c_edate", course.getC_edateFormatted());

		model.addAttribute("menu", "home");
		return "course_home";
	}

	@GetMapping("/alert")
	public String alertHandler() {
		return "alert";
	}

	@GetMapping("acceptanceManagement")
	public String acceptance_managementHandler(@RequestParam(value = "acceptPage", defaultValue = "0") int acceptPage,
			HttpSession session, Model model) {
		LoginResponse auth = (LoginResponse) session.getAttribute("auth");
		if (auth.getM_role() == 2) {

			int course_id = (int) session.getAttribute("currentId");

			List<CourseReg> courseRegList = courseDAO.getCourseReg(course_id);
			model.addAttribute("courseRegList", courseRegList);
			model.addAttribute("acceptPage", acceptPage);
			model.addAttribute("menu", "acceptanceManagement");

			return "acceptance_management";
		}

		return "redirect:/";
	}

	@PostMapping("/acceptanceManagementSearch")
	public String currentAttSearchHandler(@RequestParam(value = "acceptPage", defaultValue = "0") int acceptPage,
			HttpSession session, @RequestParam(value = "searchType") String searchType,
			@RequestParam(value = "searchText") String searchText, Model model) {
		LoginResponse auth = (LoginResponse) session.getAttribute("auth");
		if (auth.getM_role() == 2) {
			int course_id = (int) session.getAttribute("currentId");

			List<CourseReg> courseRegList = courseDAO.searchMemberReg(course_id, searchType, searchText);
			model.addAttribute("courseRegList", courseRegList);
			model.addAttribute("acceptPage", acceptPage);
			model.addAttribute("menu", "acceptanceManagement");

			return "acceptance_management";
		}

		return "redirect:/";
	}

	@GetMapping("courseRegApprove")
	public String courseRegApproveHandler(@RequestParam(value = "acceptPage", defaultValue = "0") int acceptPage,
			@RequestParam(value = "member_id") int member_id, HttpSession session) {
		LoginResponse auth = (LoginResponse) session.getAttribute("auth");
		if (auth.getM_role() == 2) {
			int course_id = (int) session.getAttribute("currentId");

			courseSO.approveStudent(course_id, member_id);

			return "redirect:/acceptanceManagement";
		}

		return "redirect:/";
	}

	@GetMapping("courseRegReject")
	public String courseRegRejectHandler(@RequestParam(value = "acceptPage", defaultValue = "0") int acceptPage,
			@RequestParam(value = "member_id") int member_id, HttpSession session) {
		LoginResponse auth = (LoginResponse) session.getAttribute("auth");
		if (auth.getM_role() == 2) {
			int course_id = (int) session.getAttribute("currentId");

			courseDAO.rejectCourseReg(course_id, member_id);

			return "redirect:/acceptanceManagement";
		}

		return "redirect:/";
	}

	@GetMapping("calendarForm")
	public String calendarFormHandler(@RequestParam(value="i_schedule_id", defaultValue="0") int i_schedule_id, HttpSession session, Model model) {
		LoginResponse auth = (LoginResponse )session.getAttribute("auth");
		if(auth.getM_role()==2) {
			if(i_schedule_id !=0) {
				InstructorCalendar formText = courseDAO.getCalendarFormText(i_schedule_id);
				formText.setSdate(formText.getSdate().substring(0,10) + "T"+ formText.getSdate().substring(11));
				formText.setEdate(formText.getEdate().substring(0,10) + "T"+ formText.getEdate().substring(11));
				model.addAttribute("formText", formText);
			}
			
			model.addAttribute("menu", "courseAttend");
			return "calendarForm";
			}
			
			return "redirect:/" ;
	}
	
	
	@GetMapping("attendDeleteProcess")
	public String attendDeleteProcessHandler(InstructorCalendar insCal, HttpSession session) {
		LoginResponse auth = (LoginResponse )session.getAttribute("auth");
		if(auth.getM_role()==2) {
			
			courseDAO.deleteInsSchedule(insCal.getI_schedule_id());
			return "redirect:/courseAttend" ;
		}
		
		return "redirect:/" ;
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

			return "redirect:" + redirectUrl + "/CourseBoard?courseId=" + courseId + "&userId=" + userId + "&role="
					+ userRole;
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
	public ResponseEntity<String> uploadMaterials(@RequestParam("title") String title,
			@RequestParam("courseId") int courseId, @RequestParam(value = "userId", required = false) Integer userId,
			@RequestParam("attachments") List<MultipartFile> attachments, HttpSession session) {

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
