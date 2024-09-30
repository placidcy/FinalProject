<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CHECK-수강신청</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/mobile.css">
<link rel="stylesheet" as="style" crossorigin
	href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
<script src="script/mobile.js"></script>
</head>
<body>
	<div class="container flex">
		<!-- 메인 사이드바 -->
		<jsp:include page="../common/side_main.jsp"></jsp:include>
		<!-- 본문 -->
		<main class="contents bgf2f2f2">
			<div class="grid g20">
				<h3 class="f24">수강 가능 강의 목록</h3>
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
				<table class="tab course">
					<tr class="item">
						<td class="deco"></td>
						<td class="category">웹 개발</td>
						<td class="name">HTML의 기초</td>
						<td class="flex g20">
							<div class="grid" style="text-align: start;">
								<p>
									<strong>기간</strong> 2024.03.12-2024.06.30 (총 40시간)
								</p>
								<p>
									<strong>정원</strong> 27/30 (명)
								</p>
							</div>
							<div>
								<button class="btn bg87c791 cffffff">신청</button>
							</div>
						</td>
					</tr>
					<tr class="item">
						<td class="deco"></td>
						<td class="category">데이터 과학</td>
						<td class="name">빅데이터와 비즈니스의 미래</td>
						<td class="flex g20">
							<div class="grid" style="text-align: start;">
								<p>
									<strong>기간</strong> 2024.03.12-2024.06.30 (총 40시간)
								</p>
								<p>
									<strong>정원</strong> 27/30 (명)
								</p>
							</div>
							<div>
								<button class="btn bg87c791 cffffff">신청</button>
							</div>
						</td>
					</tr>
					<tr class="item">
						<td class="deco"></td>
						<td class="category">데이터베이스</td>
						<td class="name">데이터베이스 기초 및 설계</td>
						<td class="flex g20">
							<div class="grid" style="text-align: start;">
								<p>
									<strong>기간</strong> 2024.03.12-2024.06.30 (총 40시간)
								</p>
								<p>
									<strong>정원</strong> 27/30 (명)
								</p>
							</div>
							<div>
								<button class="btn bg87c791 cffffff">신청</button>
							</div>
						</td>
					</tr>
					<tr class="item">
						<td class="deco"></td>
						<td class="category">프로그래밍 언어</td>
						<td class="name">프로그래밍 언어의 기초</td>
						<td class="flex g20">
							<div class="grid" style="text-align: start;">
								<p>
									<strong>기간</strong> 2024.03.12-2024.06.30 (총 40시간)
								</p>
								<p>
									<strong>정원</strong> 27/30 (명)
								</p>
							</div>
							<div>
								<button class="btn bg87c791 cffffff">신청</button>
							</div>
						</td>
					</tr>
					<tr class="item">
						<td class="deco"></td>
						<td class="category">소프트웨어 개발 도구</td>
						<td class="name">소프트웨어 개발 도구의 이해와 응용</td>
						<td class="flex g20">
							<div class="grid" style="text-align: start;">
								<p>
									<strong>기간</strong> 2024.03.12-2024.06.30 (총 40시간)
								</p>
								<p>
									<strong>정원</strong> 27/30 (명)
								</p>
							</div>
							<div>
								<button class="btn bg87c791 cffffff">신청</button>
							</div>
						</td>
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