package com.project.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.model.CourseDAO;
import com.project.model.CourseDO;
import com.project.model.MemberDAO;
import com.project.model.MemberDO;
import com.project.model.MessageItem;
import com.project.model.NoticeItem;
import com.project.model.dao.NoticeItemDAO;
import com.project.model.response.LoginResponse;
import com.project.service.ImageUploadSO;
import com.project.service.MainSO;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	@Autowired
	private NoticeItemDAO noticeDao;

	@Autowired
	private CourseDAO courseDao;

	@Autowired
	private MemberDAO memberDao;

	/**/
	@Autowired
	private MainSO mainSo;
	@Autowired
	private ImageUploadSO uploadSO;

	@GetMapping("/adminMain")
	public String adminMainHandler(HttpSession session, Model model,
			@RequestParam(name = "page", defaultValue = "1", required = false) String page) {
		LoginResponse auth = (LoginResponse) session.getAttribute("auth");
		if (auth == null || auth.getM_role() != 0) {
			return "redirect:/login";
		}
		model.addAttribute("noticeList", noticeDao.selectAll(1, 3));

		// List<CourseDO> courseList = courseDao.selectAllCourses();
		List<CourseDO> courseList = courseDao.selectAllCourses(Integer.parseInt(page));
		int size = courseDao.getSize(courseDao.getAllCoursesCount(), 10);

		model.addAttribute("courseList", courseList);
		model.addAttribute("page", page);
		model.addAttribute("size", size);

		model.addAttribute("menu", "adminMain");
		return "adminMain";
	}

	@GetMapping("/instructorManagement")
	public String instructorManagementHandler(HttpSession session, Model model,
			@RequestParam(name = "page", defaultValue = "1", required = false) String page) {
		LoginResponse auth = (LoginResponse) session.getAttribute("auth");
		if (auth == null || auth.getM_role() != 0) {
			return "redirect:/login";
		}

		int currentPage = Integer.parseInt(page);
		int itemsPerPage = 10; // 페이지 당 강사 수

		// 현재 페이지의 강사 목록 가져오기
		List<MemberDO> instructorList = memberDao.getPagedInstructors(currentPage, itemsPerPage);

		// 전체 강사 수 가져오기
		int totalInstructors = memberDao.getTotalInstructorsCount();
		int totalPages = (int) Math.ceil((double) totalInstructors / itemsPerPage);

		model.addAttribute("instructorList", instructorList);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("menu", "instructorManagement");

		return "instructorManagement";
	}

	@PostMapping("/issueInstructorId")
	@ResponseBody
	public String issueInstructorHandler(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("department") String department, @RequestParam("tel") String tel) {
		try {
			MemberDO newInstructor = new MemberDO();
			newInstructor.setM_name(name);
			newInstructor.setM_email(email);
			newInstructor.setM_dept(department);
			newInstructor.setM_tel(tel);
			newInstructor.setM_role(1);
			newInstructor.setM_acctid("inst_user_" + UUID.randomUUID().toString());
			newInstructor.setM_acctpwd("");

			memberDao.insertMember(newInstructor);

			return "{\"success\": true}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"success\": false}";
		}
	}

	@GetMapping("/instructor/search")
	public String searchInstructor(@RequestParam(value = "keyword") String keyword, Model model) {
		List<MemberDO> instructorList = memberDao.searchInstructors(keyword);
		model.addAttribute("instructorList", instructorList);
		model.addAttribute("keyword", keyword);
		model.addAttribute("menu", "instructorManagement");
		return "instructorManagement";
	}

	/**/
	@RequestMapping("/admin/error")
	public String getErrorPage(@RequestParam("msg") String msg, @RequestParam("redirect") String redirect,
			Model model) {
		model.addAttribute("msg", msg);
		model.addAttribute("redirect", redirect);
		return "admin/error";
	}

	@RequestMapping("/admin/notice")
	public String getAmdinNotice(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
		model.addAttribute("list", mainSo.selectAll(page));
		model.addAttribute("size", mainSo.getTotalSize());
		model.addAttribute("page", page);

		model.addAttribute("menu", "adminNotice");
		return "admin/notice";
	}

	@RequestMapping("/admin/notice/search")
	public String getNoticeByKeyword(Model model, @RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "keyword", required = true) String keyword) {
		model.addAttribute("list", mainSo.selectAll(page, keyword));
		model.addAttribute("size", mainSo.getTotalSize(keyword));
		model.addAttribute("page", page);
		model.addAttribute("keyword", keyword);

		model.addAttribute("menu", "adminNotice");
		return "admin/notice_search";
	}

	@RequestMapping("/admin/notice/write")
	public String write(Model model) {
		model.addAttribute("menu", "adminNotice");
		return "admin/notice_write";
	}

	@RequestMapping("/admin/notice/addPost")
	public String addPost(@RequestParam("files") MultipartFile[] files, @RequestParam("title") String title,
			@RequestParam("content") String content, @RequestParam("target") int target, HttpSession session)
			throws UnsupportedEncodingException {
		LoginResponse auth = (LoginResponse) session.getAttribute("auth");
		int memberId = auth.getMember_id();
		if (uploadSO.insertNewPost(title, content, files, target, memberId)) {
			return "redirect:/admin/notice";
		} else {
			return this.redirectErrorPage("게시글 작성에 실패하였습니다.", "write");
		}
	}

	@RequestMapping("/admin/notice/details")
	public String getDetails(Model model, @RequestParam("postId") int postId, @RequestParam("page") int page) {
		NoticeItem post = mainSo.selectOne(postId);
		model.addAttribute("notice", post);
		if (post.getAttachments() != null) {
			model.addAttribute("attms", uploadSO.getFiles(post.getAttachments()));
		}
		model.addAttribute("page", page);
		model.addAttribute("menu", "adminNotice");
		return "admin/notice_details";
	}

	@RequestMapping("/admin/notice/delete")
	@ResponseBody
	public MessageItem deletePost(@RequestParam("postId") int postId) {
		MessageItem messageItem = new MessageItem();
		messageItem.setRes(uploadSO.deletePost(postId));
		if (messageItem.isRes()) {
			messageItem.setMsg("게시글이 삭제되었습니다.");
		} else {
			messageItem.setMsg("게시글이 삭제되지 않았습니다.");
		}
		return messageItem;
	}

	private String redirectErrorPage(String errorMessage, String redirectKeyword) throws UnsupportedEncodingException {
		return "redirect:/admin/error?msg=" + URLEncoder.encode(errorMessage, "UTF-8") + ".&redirect="
				+ redirectKeyword;
	}
}