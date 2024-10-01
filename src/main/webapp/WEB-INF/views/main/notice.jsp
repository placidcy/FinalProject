<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CHECK-공지사항</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/notice.css">
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
			<div class="grid g20">
				<h3 class="f24">공지사항</h3>
				<div class="search box">
					<input type="text" placeholder="검색어를 입력하세요.">
					<div class="iconBtn">
						<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 50 50"
							width="20px" height="20px">
                                <path
								d="M 21 3 C 11.601563 3 4 10.601563 4 20 C 4 29.398438 11.601563 37 21 37 C 24.355469 37 27.460938 36.015625 30.09375 34.34375 L 42.375 46.625 L 46.625 42.375 L 34.5 30.28125 C 36.679688 27.421875 38 23.878906 38 20 C 38 10.601563 30.398438 3 21 3 Z M 21 7 C 28.199219 7 34 12.800781 34 20 C 34 27.199219 28.199219 33 21 33 C 13.800781 33 8 27.199219 8 20 C 8 12.800781 13.800781 7 21 7 Z" />
                            </svg>
					</div>
				</div>
				<table class="tab notice mbe30">
					<c:forEach items="${list }" var="item">
						<tr class="item" data-id="${item.noticeId }">
							<td class="prefix">공지</td>
							<td class="title">${item.noticeTitle }</td>
						</tr>
					</c:forEach>
				</table>
				<ul class="pagination">
					<c:if test="${page ne 1 }">
						<li class="page">이전</li>
					</c:if>
					<c:forEach var="i" begin="1" end="${size }">
						<li class="page selected">${i}</li>
					</c:forEach>
					<c:if test="${page ne size}">
						<li class="page">다음</li>
					</c:if>
				</ul>
			</div>
		</main>
	</div>
</body>

</html>