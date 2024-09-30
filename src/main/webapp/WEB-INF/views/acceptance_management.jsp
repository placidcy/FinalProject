<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>

<head>
    <link href="https://fonts.googleapis.com/css?family=Inter&display=swap" rel="stylesheet" />
    <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
    <link rel="stylesheet" href="/resources/css/course_acceptance_management.css">
    <link rel="stylesheet" href="/resources/css/course_mu.css">
    <script src="/resources/js/course.js"></script>
    <title>Document</title>
</head>

<body>
    <div id="container">
        <jsp:include page="common/sidebar_course.jsp" />
 
        <main>
            <h1>수강 신청 관리</h1>

            <div class="search">
                <span class="search_title">검색</span>
                <select class="search_type">
                    <option value="1">이름</option>
                    <option value="2">소속</option>
                </select>
                <div class="search-box">
                    <div>
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

            <div class="students_enrolleds">
                <div class="std_head">
                    <span class="name">이름</span>
                    <span class="belong">소속</span>
                    <span class="state">상태</span>
                </div>

                <div class="std_body">
                    <span class="std_name">두루미</span>
                    <span class="std_belong">1반</span>
                    <a href="" class="std_approval">승인</a>
                    <a href="" class="std_rejection">거절</a>
                </div>
                <div class="std_body">
                    <span class="std_name">황새</span>
                    <span class="std_belong">2반</span>
                    <a href="" class="std_approval">승인</a>
                    <a href="" class="std_rejection">거절</a>
                </div>
                <div class="std_body">
                    <span class="std_name">고길동</span>
                    <span class="std_belong">3반</span>
                    <a href="" class="std_approval">승인</a>
                    <a href="" class="std_rejection">거절</a>
                </div>
                <div class="std_body">
                    <span class="std_name">김수강</span>
                    <span class="std_belong">1반</span>
                    <a href="" class="std_approval">승인</a>
                    <a href="" class="std_rejection">거절</a>
                </div>
                <div class="std_body">
                    <span class="std_name">강호동</span>
                    <span class="std_belong">2반</span>
                    <a href="" class="std_approval">승인</a>
                    <a href="" class="std_rejection">거절</a>
                </div>
                <div class="std_body">
                    <span class="std_name">남궁혁</span>
                    <span class="std_belong">4반</span>
                    <a href="" class="std_approval">승인</a>
                    <a href="" class="std_rejection">거절</a>
                </div>
                <div class="std_body">
                    <span class="std_name">박혁거세</span>
                    <span class="std_belong">1반</span>
                    <a href="" class="std_approval">승인</a>
                    <a href="" class="std_rejection">거절</a>
                </div>
            </div>

            <div class="paging_list">
                <a href=""><span class="prev_paging">이전</span></a>
                <a href=""><span class="paging active">1</span></a>
                <a href=""><span class="paging">2</span></a>
                <a href=""><span class="paging">3</span></a>
                <a href=""><span class="next_paging">다음</span></a>
            </div>
        </main>
    </div>
</body>

</html>