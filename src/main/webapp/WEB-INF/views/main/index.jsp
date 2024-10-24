<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CHECK-메인</title>
<link rel="stylesheet" href="/resources/css/common.css">
<link rel="stylesheet" href="/resources/css/main/main.css">
<link rel="stylesheet" as="style" crossorigin
	href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
<script src="/resources/js/main/mobile.js"></script>
<script src="/resources/js/main/course.js"></script>
</head>

<body>
	<div class="container flex">
		<c:set var="auth" value="${sessionScope.auth}" />
		<!-- 메인 사이드바 -->
		<c:choose>
			<c:when test="${auth.m_role eq 1 }">
				<jsp:include page="../common/side_main.jsp"></jsp:include>
			</c:when>
			<c:otherwise>
				<jsp:include page="../common/side_main_i.jsp"></jsp:include>
			</c:otherwise>
		</c:choose>
		<!-- 본문 -->
		<main class="contents bgf2f2f2">
			<div class="grid g20 mbe30">
				<div class="grid fr2 cen v">
					<h3 class="f24">공지 목록</h3>
					<a id="seemore" class="end self" href="/notice"> <span>더보기</span>
					</a>
				</div>
				<table class="tab notice">
					<c:if test="${empty notice }">
						<tr class="item">
							<td class="error">현재 게시된 공지사항이 없습니다.</td>
						</tr>
					</c:if>
					<c:forEach items="${notice }" var="item">
						<tr class="item">
							<td>${item.noticeTitle }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="grid g20">
				<h3 class="f24">강의 목록</h3>
				<p class="c87c791">강의 시작 14일 전, 강의 종료 14일 후까지 표시됩니다.</p>
				<table class="tab course">
					<c:if test="${empty course }">
						<tr class="item">
							<td class="error" colspan="4">현재 참여 중인 강의가 없습니다. 관리자에게
								문의하세요.</td>
						</tr>
					</c:if>
					<c:forEach items="${course }" var="item">
						<tr class="item" data-id="${item.courseId }">
							<td class="deco"></td>
							<td class="category">${item.categoryName }</td>
							<td class="name">${item.courseName }</td>
							<td class="day"><c:forEach begin="0" end="7"
									varStatus="status">
									<c:set var="day" value="${status.index}" />
									<c:if test="${item.days[day] eq 1}">
										<c:choose>
											<c:when test="${day eq 0}">
												<span>일 </span>
											</c:when>
											<c:when test="${day eq 1}">
												<span>월 </span>
											</c:when>
											<c:when test="${day eq 2}">
												<span>화 </span>
											</c:when>
											<c:when test="${day eq 3}">
												<span>수 </span>
											</c:when>
											<c:when test="${day eq 4}">
												<span>목 </span>
											</c:when>
											<c:when test="${day eq 5}">
												<span>금 </span>
											</c:when>
											<c:when test="${day eq 6}">
												<span>토 </span>
											</c:when>
										</c:choose>
									</c:if>
								</c:forEach></td>
							<td class="enter"><button>입장하기</button></td>
						</tr>
					</c:forEach>
				</table>
				<ul class="pagination">
					<c:if test="${page ne 1 }">
						<a href="?page=${page-1 }">
							<li class="page">이전</li>
						</a>
					</c:if>
					<c:forEach var="i" begin="1" end="${size }">
						<a href="?page=${i}">
							<li class="page <c:if test="${i eq page }">selected</c:if>">${i}</li>
						</a>
					</c:forEach>
					<c:if test="${page ne size}">
						<a href="?page=${page+1 }">
							<li class="page">다음</li>
						</a>
					</c:if>
				</ul>

			</div>
		</main>
	</div>
</body>

</html>