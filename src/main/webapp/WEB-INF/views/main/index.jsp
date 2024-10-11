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
		<!-- 메인 사이드바 -->
		<jsp:include page="../common/side_main.jsp"></jsp:include>
		<!-- 본문 -->
		<main class="contents bgf2f2f2">
			<div class="grid g20 mbe30">
				<div class="grid fr2 cen v">
					<h3 class="f24">공지 목록</h3>
					<a id="seemore" class="end self" href="/notice"> <span>더보기</span>
					</a>
				</div>
				<table class="tab notice">
					<c:forEach items="${notice }" var="item">
						<tr class="item">
							<th>공지</th>
							<td>${item.noticeTitle }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="grid g20">
				<h3 class="f24">강의 목록</h3>
				<p class="c87c791">강의 시작 14일 전, 강의 종료 14일 후까지 표시됩니다.</p>
				<table class="tab course">
					<c:forEach items="${course }" var="item">
						<tr class="item" data-id="${item.courseId }">
							<td class="deco"></td>
							<td class="category">${item.categoryName }</td>
							<td class="name">${item.courseName }</td>
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