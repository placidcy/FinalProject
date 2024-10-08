<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CHECK-출석체크</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="/css/main/checkin.css">
<link rel="stylesheet" href="/css/mobile.css">
<link rel="stylesheet" as="style" crossorigin
	href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
<script src="js/main/mobile.js"></script>
<script src="js/main/checkin.js"></script>
<body>
	<div class="container flex">
		<!-- 메인 사이드바 -->
		<jsp:include page="../common/side_main.jsp"></jsp:include>
		<!-- 본문 -->
		<main class="contents bgf2f2f2">
			<div class="grid g10 mbe30">
				<p class="f24 bold">출석 체크</p>
				<p>
					출결에 이상이 있는 경우, 관련 서류 구비 후 제출바랍니다. <a class="bold" href="#">📝
						출결 정정 신청하기</a>
				</p>
			</div>
			<div class="grid c2 g10">
				<div class="grid g20 fig full">
					<p class="f20 bold">분류 > ${info.categoryName }</p>
					<p class="f30 bold">${info.courseName }</p>
					<div class="info">
						<p>
							<span>강의 기간:</span><span class="float-right">${info.startDate }
								~ ${info.endDate }</span>
						</p>
						<p>
							<span>강사:</span><span class="float-right"><c:forEach
									items="${info.instList }" var="inst" varStatus="status">${inst }</c:forEach></span>
						</p>
					</div>
					<p>
						종료일까지 남은 기간: <span class="bold">${info.dDay }</span>
					</p>
					<a class="f20 bold h end self" href="course.html">📖 강의 홈으로
						이동하기</a>
				</div>
				<table class="tab ta cen">
					<tr>
						<td><span>입실</span> <span class="bold">${time.cinTime }</span></td>
						<td><span>복귀</span> <span class="bold">${time.retTime }</span></td>
					</tr>
					<tr>
						<td><span>외출</span> <span class="bold">${time.soutTime }</span></td>
						<td><span>퇴실</span> <span class="bold">${time.coutTime }</span></td>
					</tr>
				</table>
				<div class="fig qr">
					<div class="ta cen">
						<p>
							해당 코드는 <span class="bold">공유가 불가능</span>하며, 이를 이용한 <span
								class="bold">부정 출결 시 제적</span>을 당할 수 있습니다.
						</p>
						<div class="grid c2 cen v h">
							<div class="">
								<p>QR코드 만료까지 남은 시간</p>
								<p class="bold" id="timeLimit">00시간 00분 00초</p>
							</div>
							<div>
								<img class="img s200"
									src="https://quickchart.io/qr?text=${empty info.qrCode ? 'null' : info.qrCode }&centerImageUrl=https://imgur.com/RB0yUtw.png"
									alt="">
							</div>
						</div>
						<p>
							<span class="bold">QR 코드 스캔</span>은 <span class="bold">모바일
								환경으로 접속</span>하여 수행하시길 바랍니다.
						</p>
					</div>
				</div>
				<table>
					<tr>
						<td><c:if test="${empty time.cinTime }">
								<button class="btn attend" id="cinBtn">입실</button>
							</c:if> <c:if test="${empty time.coutTime and not empty time.soutTime }">
								<button class="btn attend" id="retBtn">복귀</button>
							</c:if></td>
					</tr>
					<tr>
						<td><c:if
								test="${not empty time.cinTime and empty time.coutTime }">
								<button class="btn attend" id="soutBtn">외출</button>
							</c:if> <c:if test="${not empty time.cinTime and empty time.coutTime }">
								<button class="btn attend" id="coutBtn">퇴실</button>
							</c:if></td>
					</tr>
				</table>
				<div class="grid g20 fig full">
					<p class="f20 bold">출결 현황</p>
					<div class="grid c4 ta cen fig">
						<div class="border-right">
							<p>출석</p>
							<p class="bold">${stats.presentCnt }</p>
						</div>
						<div class="border-right">
							<p>지각</p>
							<p class="bold">${stats.tardyCnt }</p>
						</div>
						<div class="border-right">
							<p>조퇴</p>
							<p class="bold">${stats.leaveCnt }</p>
						</div>
						<div>
							<p>결석</p>
							<p class="bold">${stats.absentCnt }</p>
						</div>
					</div>
					<div class="grid g10">
						<p>
							<span class="bold">나의 출석률</span> <span> <fmt:formatNumber
									value="${stats.myCnt/stats.totalCnt }" type="percent"
									pattern="0.0%"></fmt:formatNumber>
							</span> <span> (${stats.myCnt }/${stats.totalCnt }일)</span>
						</p>
						<!-- 차트 라이브러리 연결 후 수정-->
						<div class="chart grid cen v">
							<div class="grid cen h" id="avg">
								<p>
									<b>평균</b> <span id="avgPer"><fmt:formatNumber
											value="${stats.avgCnt/stats.totalCnt }" type="percent"
											pattern="0.0%"></fmt:formatNumber></span>
								</p>
								<div class="line"></div>
							</div>
							<div class="bullet box bgd9d9d9">
								<div class="bullet bar bg24c2a2"></div>
							</div>
							<div class="grid cen h" id="curr">
								<div class="line"></div>
								<p>
									<b>나</b> <span id="myPer"><fmt:formatNumber
											value="${stats.myCnt/stats.totalCnt }" type="percent"
											pattern="0.0%"></fmt:formatNumber></span>
								</p>
							</div>
						</div>
					</div>
					<div class="scanner">
						<svg xmlns="http://www.w3.org/2000/svg" width="60px" height="60px"
							viewBox="0 0 24 24">
	                            <g>
	                                <path fill="none" d="M0 0h24v24H0z" />
	                                <path
								d="M15 3h6v5h-2V5h-4V3zM9 3v2H5v3H3V3h6zm6 18v-2h4v-3h2v5h-6zm-6 0H3v-5h2v3h4v2zM3 11h18v2H3v-2z" />
	                            </g>
	                        </svg>
					</div>
				</div>
			</div>
		</main>
	</div>
</body>

</html>