<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CHECK-메인</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" as="style" crossorigin
	href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
<script src="js/mobile.js"></script>
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
					<a id="seemore" class="end self" href=""> <span>더보기</span>
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
						<tr class="item">
							<td class="deco"></td>
							<td class="category">${item.categoryName }</td>
							<td class="name">${item.courseName }</td>
						</tr>
					</c:forEach>
				</table>
				<ul class="pagination">
					<li class="page disabled">이전</li>
					<li class="page selected">1</li>
					<li class="page">2</li>
					<li class="page">3</li>
					<li class="page">다음</li>
				</ul>
			</div>
		</main>
	</div>
</body>

</html>