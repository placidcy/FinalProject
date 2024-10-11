<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지 사항</title>
<link rel="stylesheet" href="/resources/css/course_mu.css">
<link rel="stylesheet" href="/resources/css/course_notice.css">
<link rel="stylesheet" as="style" crossorigin
	href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
<script src="/resources/js/course.js"></script>
</head>
<body>
	<div id="container">
		<jsp:include page="common/sidebar_course.jsp" />
		<main>
			<div class="header">
				<a href=""><div class="button">전체 목록</div></a>
				<a href=""><div class="button active">공지 사항</div></a>
				<a href=""><div class="button">강의 자료</div></a>
				<a href=""><div class="button">질문</div></a>
			</div>
			<a href="">
				<div class="notice_write_button">공지 작성</div>
			</a>

			<div class="announcement">
				<c:forEach var="announcement" items="${courseAnnouncements}">
					<div class="item">
						<a href="">
							<span class="title">${announcement.noticeTitle}</span>
							<span class="date">게시일: ${announcement.regDate}</span>
							<span class="content">${announcement.noticeContents}</span>
						</a> <br>
						<c:if test="${not empty announcement.attachment}">
							<a href="">첨부파일명</a>
						</c:if>
					</div>
				</c:forEach>
			</div>

			<a href="">
				<div class="notice_write_button_mobile">공지 작성</div>
			</a>
		</main>
	</div>
</body>
</html>
