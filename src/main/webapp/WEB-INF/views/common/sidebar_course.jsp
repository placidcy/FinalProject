<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!-- 강의 사이드바 -->
<aside>
    <div class="course-sidebar-left">
        <ul class="sidebar-menu">
            <li>
                <a href="mypage">
                    <img class="sidebar-icon" src="/resources/img/mypage.png" alt="">
                </a>
            </li>
            <li>
                <a href="">
                    <img class="sidebar-icon" src="/resources/img/course.png" alt="">
                </a>
            </li>
            <li>
                <a href="">
                    <img class="sidebar-icon" src="/resources/img/attend.png" alt="">
                </a>
            </li>
            <li>
                <a href="">
                    <img class="sidebar-icon" src="/resources/img/register.png" alt="">
                </a>
            </li>
            <li>
                <a href="alert">
                    <img class="sidebar-icon" src="/resources/img/alert.png" alt="">
                </a>
            </li>
            <li>
                <a href="">
                    <img class="sidebar-icon" src="/resources/img/notice.png" alt="">
                </a>
            </li>
            <li>
                <a href="login">
                    <img class="sidebar-icon" src="/resources/img/logout.png" alt="">
                </a>
            </li>
        </ul>
    </div>

    <div class="course-sidebar-right">
        <div class="sidebar-logo">
            <a href="home"><h1>CHECK</h1></a>
            <h3>HTML의 기초</h3>
                <hr>
        </div>

        <div id="mobile-menu">
            <h1 id="backBtn">◀</h1>
            <h1 class="menuName">HTML의 기초</h1>
            <div id="mobile-menu-icon">
                <svg xmlns="http://www.w3.org/2000/svg" width="30px" height="30px" viewBox="0 0 24 24" fill="none">
                    <path d="M4 6H20M4 12H20M4 18H20" stroke="#000000" stroke-width="2" stroke-linecap="round"
                        stroke-linejoin="round" />
                </svg>
            </div>
        </div>
        <!-- 강사/학생에 따라 인라인 css 적용 -->
		<c:choose>
		<c:when test="${m_role==1}">
			<ul class="sidebar-menu">
	            <a href="home" class="sidebar-menu-selected" style="width:33.333%"><li>홈</li></a>
	            <a href="" class="sidebar-menu-unselected" style="width:33.333%"><li>강의 게시판</li></a>
	            <a href="attendanceCalendar" class="sidebar-menu-unselected" style="width:33.333%"><li>출결 확인</li></a>        
	        </ul>
			
	        <ul id="menuList" style="visibility: hidden;">
	            <li>코스</li>
	            <li>출석 체크</li>
	            <li>수강 신청</li>
	            <li><a href="alert">알림</a></li>
	            <li>공지사항</li>
	            <li><a href="mypage">마이 페이지</a></li>
	            <li>로그아웃</li>
	        </ul>
		</c:when>
        
		<c:otherwise>
			<ul class="sidebar-menu">
	            <a href="home" class="sidebar-menu-selected" style="width:25%"><li>홈</li></a>
	            <a href="" class="sidebar-menu-unselected" style="width:25%"><li>강의 게시판</li></a>
	            <a href="currentAttendance" class="sidebar-menu-unselected" style="width:25%"><li>출결 확인</li></a>
	            <a href="acceptanceManagement" class="sidebar-menu-unselected" style="width:25%"><li>수강 신청 관리</li></a>
	            <a href="courseAttend" class="sidebar-menu-unselected" style="width:25%"><li>강의 일정 관리</li></a>
	        </ul>
			
	        <ul id="menuList" style="visibility: hidden;">
	            <li>코스</li>
	            <li>출석 체크</li>
	            <li><a href="alert">알림</a></li>
	            <li>공지사항</li>
	            <li><a href="mypage">마이 페이지</a></li>
	            <li>로그아웃</li>
	        </ul>
		</c:otherwise>
		</c:choose>
		
    </div>

    
</aside>
