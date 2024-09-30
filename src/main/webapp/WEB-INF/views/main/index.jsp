<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<tr class="item">
						<th>공지</th>
						<td>9/24 임시 점검 안내</td>
					</tr>
					<tr class="item">
						<th>공지</th>
						<td>9/20 정기 점검 안내</td>
					</tr>
				</table>
			</div>
			<div class="grid g20">
				<h3 class="f24">강의 목록</h3>
				<p class="c87c791">강의 시작 14일 전, 강의 종료 14일 후까지 표시됩니다.</p>
				<table class="tab course">
					<tr class="item">
						<td class="deco"></td>
						<td class="category">웹 개발</td>
						<td class="name">HTML의 기초</td>
					</tr>
					<tr class="item">
						<td class="deco"></td>
						<td class="category">데이터 과학</td>
						<td class="name">빅데이터와 비즈니스의 미래</td>
					</tr>
					<tr class="item">
						<td class="deco"></td>
						<td class="category">데이터베이스</td>
						<td class="name">데이터베이스 기초 및 설계</td>
					</tr>
					<tr class="item">
						<td class="deco"></td>
						<td class="category">프로그래밍 언어</td>
						<td class="name">프로그래밍 언어의 기초</td>
					</tr>
					<tr class="item">
						<td class="deco"></td>
						<td class="category">소프트웨어 개발 도구</td>
						<td class="name">소프트웨어 개발 도구의 이해와 응용</td>
					</tr>
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