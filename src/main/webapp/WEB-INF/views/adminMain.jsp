<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CHECK-공지사항</title>
    <link rel="stylesheet" href="/resources/css/admin.css">
    <link rel="stylesheet" as="style" crossorigin
    href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
  


</head>

<body>
    <div class="container">
        <jsp:include page="common/admin_sidebar.jsp" />
        <main class="bg-f2f2f2">
            <div class="grid g20 mb30">
                <div class="course-notice-title">
                    <h3>공지사항</h3>
                    <a href="">
                        <span>더보기</span>
                    </a>
                </div>
                <ul class="course-notice white f20">
                    <li>
                        2024 1학기 LMS 강사님 오프라인 안내

                    </li>
                    <li>
                        홈페이지 점검 안내 ( 2024.08.12(월) 19:00~24:00 )
                    </li>
                    <li>
                        일반 로그인 장애 안내 (조치완료)
                    </li>
                    <li>
                        근로자의 날 (5월 1일) 휴무 안내</li>
                    </li>
                </ul>
            </div>
            <div class="grid g20">
                <div class="grid c2 ac">
                    <h3>현재 개설 강의 목록</h3>
                    <div class="search-box flex ac">
                        <div class="flex ac">
                            <input type="text" placeholder="검색어를 입력하세요.">
                            <div class="search-button">
                                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 50 50" width="20px" height="20px">
                                    <path
                                        d="M 21 3 C 11.601563 3 4 10.601563 4 20 C 4 29.398438 11.601563 37 21 37 C 24.355469 37 27.460938 36.015625 30.09375 34.34375 L 42.375 46.625 L 46.625 42.375 L 34.5 30.28125 C 36.679688 27.421875 38 23.878906 38 20 C 38 10.601563 30.398438 3 21 3 Z M 21 7 C 28.199219 7 34 12.800781 34 20 C 34 27.199219 28.199219 33 21 33 C 13.800781 33 8 27.199219 8 20 C 8 12.800781 13.800781 7 21 7 Z" />
                                </svg>
                            </div>
                        </div>
                    </div>
                </div>
                <table class="course-list">
                    <tr class="course-item">
                        <td class="course-decoration grayscale"></td>
                        <td class="course-category">웹 개발</td>
                        <td class="course-name">HTML의 기초</td>
                    </tr>
                    <tr class="course-item">
                        <td class="course-decoration grayscale"></td>
                        <td class="course-category">데이터 과학</td>
                        <td class="course-name">빅데이터와 비즈니스의 미래</td>
                    </tr>
                    <tr class="course-item">
                        <td class="course-decoration grayscale"></td>
                        <td class="course-category">데이터베이스</td>
                        <td class="course-name">데이터베이스 기초 및 설계</td>
                    </tr>
                    <tr class="course-item">
                        <td class="course-decoration grayscale"></td>
                        <td class="course-category">프로그래밍 언어</td>
                        <td class="course-name">프로그래밍 언어의 기초</td>
                    </tr>
                    <tr class="course-item">
                        <td class="course-decoration grayscale"></td>
                        <td class="course-category">소프트웨어 개발 도구</td>
                        <td class="course-name">소프트웨어 개발 도구의 이해와 응용</td>
                    </tr>
                </table>
                <ul class="pagination">
                    <li class="page-disabled">이전</li>
                    <li class="page-selected">1</li>
                    <li>2</li>
                    <li>3</li>
                    <li>다음</li>
                </ul>
            </div>
        </main>

    </div>
</body>

</html>