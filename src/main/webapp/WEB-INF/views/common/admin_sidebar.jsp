<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<link rel="stylesheet" href="/resources/css/common.css">
<link rel="stylesheet" href="/resources/css/adminMain.css">
<link rel="stylesheet" href="/resources/css/admin_aside.css">
<aside class="sidebarMenuBox sidebar">
	<div id="asideTitle">관리자 페이지</div>
	<div>
		<ul>
			<a href="/adminMain"><c:set var="adminMain" value="adminMain"></c:set>
				<li class="menu <c:if test="${menu eq adminMain}">selected</c:if>">강의
					목록</li></a>
			<a href="/instructorManagement"><c:set var="instructorManagement"
					value="instructorManagement"></c:set>
				<li
				class="menu <c:if test="${menu eq instructorManagement}">selected</c:if>">강사
					관리</li></a>
			<a href="/admin/notice"><c:set var="adminNotice"
					value="adminNotice"></c:set>
				<li class="menu <c:if test="${menu eq adminNotice}">selected</c:if>">공지사항</li></a>
		</ul>
	</div>

	<a href="/logout">
		<div id="logout">
			<span>로그아웃</span>
		</div>
	</a>
</aside>
