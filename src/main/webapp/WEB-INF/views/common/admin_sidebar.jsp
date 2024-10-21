<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<aside class="sidebarMenuBox sidebar">
	<div id="asideTitle">관리자 페이지</div>
	<div>
		<ul>
			<a href="/adminMain"><c:set var="adminMain" value="adminMain"></c:set>
				<li class="menu <c:if test="${menu eq adminMain}">clicked</c:if>">강의
					목록 조회</li></a>
			<a href=""><li class="menu">강의 생성</li></a>
			<a href="#"><li class="menu">전체 통지</li></a>
			<a href="/instructorManagement"><c:set var="instructorManagement"
					value="instructorManagement"></c:set>
				<li
				class="menu <c:if test="${menu eq instructorManagement}">clicked</c:if>">강사
					관리</li></a>
		</ul>
	</div>

	<a href="/logout">
		<div id="logout">
			<span>로그아웃</span>
		</div>
	</a>
</aside>
