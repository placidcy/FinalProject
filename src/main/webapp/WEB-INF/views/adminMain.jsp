<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관리자 메인 페이지</title>
<link rel="stylesheet" href="/resources/css/common.css">
<link rel="stylesheet" href="/resources/css/adminMain.css">
<link rel="stylesheet" href="/resources/css/admin_aside.css">
<link rel="stylesheet" href="/resources/css/admin-form.css">
<link rel="stylesheet" href="/resources/css/admin-course.css">

<link rel="stylesheet" as="style" crossorigin
	href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />

<style>
.container {
	gap: 0;
}

.contents {
	overflow-y: auto; /* 내용이 넘어가면 세로 스크롤바 추가 */
}
</style>
</head>

<body>
	<div class="container flex">
		<jsp:include page="common/admin_sidebar.jsp" />

		<main class="bg-f2f2f2 contents">
			<div class="grid g20 mb30">
				<div class="course-notice-title">
					<h3>공지사항</h3>
					<a href="/notice"> <span>더보기</span>
					</a>
				</div>

				<ul class="course-notice white f20">
					<c:if test="${empty noticeList}">
						<li>공지사항이 없습니다.</li>
					</c:if>
					<c:forEach items="${noticeList}" var="notice">
						<li>공지사항: ${notice.noticeTitle}</li>
					</c:forEach>

				</ul>
			</div>

			<div class="grid g20">
				<div class="grid c2 ac">
					<h3>현재 개설 강의 목록</h3>
				</div>
				<div>
					<table class="course-list">
						<c:forEach items="${courseList}" var="course">
							<tr class="course-item">
								<td class="course-decoration grayscale"></td>
								<td class="course-category">${course.categoryTitle}</td>
								<td class="course-name">${course.c_name}</td>
							</tr>
						</c:forEach>
					</table>
					<ul class="pagination">
						<c:if test="${page ne 1}">
							<a href="/adminMain?page=${page-1}">
								<li class="page">이전</li>
							</a>
						</c:if>
						<c:forEach var="i" begin="1" end="${size}">
							<a href="/adminMain?page=${i}">
								<li class="page <c:if test="${i eq page}">selected</c:if>">${i}</li>
							</a>
						</c:forEach>
						<c:if test="${page ne size}">
							<a href="/adminMain?page=${page+1}">
								<li class="page">다음</li>
							</a>
						</c:if>
					</ul>
				</div>
			</div>
		</main>
	</div>
</body>
</html>