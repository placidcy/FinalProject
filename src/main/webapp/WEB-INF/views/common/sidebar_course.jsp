<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!-- 강의 사이드바 -->
<aside>
    <div class="course-sidebar-left">
        <ul class="sidebar-menu">
            <li>
                <a href="/mypage">
                    <img class="sidebar-icon" src="/resources/img/mypage.png" alt="">
                </a>
            </li>
            <li>
                <a href="/">
                    <img class="sidebar-icon" src="/resources/img/course.png" alt="">
                </a>
            </li>
            <li>
                <a href="">
                    <img class="sidebar-icon" src="/resources/img/attend.png" alt="">
                </a>
            </li>
            <li>
                <a href="/register">
                    <img class="sidebar-icon" src="/resources/img/register.png" alt="">
                </a>
            </li>
            <li>
                <a href="/alert">
                    <img class="sidebar-icon" src="/resources/img/alert.png" alt="">
                </a>
            </li>
            <li>
                <a href="/notice">
                    <img class="sidebar-icon" src="/resources/img/notice.png" alt="">
                </a>
            </li>
            <li>
                <a href="/logout">
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
            <p class="menuName" >HTML의 기초</p>
            <div id="mobile-menu-icon">
                <svg xmlns="http://www.w3.org/2000/svg" width="30px" height="30px" viewBox="0 0 24 24" fill="none">
                    <path d="M4 6H20M4 12H20M4 18H20" stroke="#000000" stroke-width="2" stroke-linecap="round"
                        stroke-linejoin="round" />
                </svg>
            </div>
        </div>
        <!-- 강사/학생에 따라 인라인 css 적용 -->
		<c:choose>
		<c:when test="${auth.m_role==1}">
			<ul class="sidebar-menu">
				<c:set var="home" value="home"></c:set>
				<a href="/home" 
				class="menu <c:if test="${menu eq home}">clicked</c:if>"
				style="width:33.3%">
				<li>홈</li></a>
				
	            <a href="" class="sidebar-menu-unselected" style="width:33.3%"><li>강의 게시판</li></a>
				
				<c:set var="attendanceCalendar" value="attendanceCalendar"></c:set>
				<a href="/attendanceCalendar" 
				class="menu <c:if test="${menu eq attendanceCalendar}">clicked</c:if>"
				style="width:33.3%">
				<li>출결 확인</li></a>     
	        </ul>
			
	        <ul id="menuList" style="visibility: hidden;">
	            <li><a href="/">코스</a></li>
	            <li>출석 체크</li>
	            <li><a href="register">수강 신청</a></li>
	            <li><a href="/alert">알림</a></li>
	            <li><a href="/mypage">마이 페이지</a></li>
				<li><a href="/notice">공지사항</a></li>
	            <li><a href="/logout">로그아웃</a></li>
	        </ul>
		</c:when>
        
		<c:otherwise>
			<ul class="sidebar-menu">
				<c:set var="home" value="home"></c:set>
				<a href="/home" 
				class="menu <c:if test="${menu eq home}">clicked</c:if>"
				style="width:25%">
				<li>홈</li></a>

	            <a href="" class="sidebar-menu-unselected" style="width:25%"><li>강의 게시판</li></a>
				
				<c:set var="currentAttendance" value="currentAttendance"></c:set>
				<a href="/currentAttendance" 
				class="menu <c:if test="${menu eq currentAttendance}">clicked</c:if>"
				style="width:25%">
				<li>출결 확인</li></a>
				
				<c:set var="acceptanceManagement" value="acceptanceManagement"></c:set>
				<a href="/acceptanceManagement" 
				class="menu <c:if test="${menu eq acceptanceManagement}">clicked</c:if>"
				style="width:25%">
				<li>수강 신청 관리</li></a>
				
				<c:set var="courseAttend" value="courseAttend"></c:set>
				<a href="/courseAttend" 
				class="menu <c:if test="${menu eq courseAttend}">clicked</c:if>"
				style="width:25%">
				<li>강의 일정 관리</li></a>
	        </ul>
			

			
	        <ul id="menuList" style="visibility: hidden;">
	            <li><a href="/">코스</a></li>
	            <li>출석 체크</li>
	            <li><a href="/alert">알림</a></li>
				<li><a href="/mypage">마이 페이지</a></li>
	            <li><a href="/notice">공지사항</a></li>
	            <li><a href="/logout">로그아웃</a></li>
	        </ul>
		</c:otherwise>
		</c:choose>
		
    </div>

    
</aside>
