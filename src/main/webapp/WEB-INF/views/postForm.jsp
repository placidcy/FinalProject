<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/course_mu.css">
    <link rel="stylesheet" href="css/postForm.css">
    <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
    <script src="js/course.js"></script>
</head>

<body>
    <div id="container">
        <aside>
            <div class="course-sidebar-left">
                <ul class="sidebar-menu">
                    <li>
                        <a href="">
                            <img class="sidebar-icon" src="./img/mypage.png" alt="">
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img class="sidebar-icon" src="./img/course.png" alt="">
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img class="sidebar-icon" src="./img/attend.png" alt="">
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img class="sidebar-icon" src="./img/register.png" alt="">
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img class="sidebar-icon" src="./img/alert.png" alt="">
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img class="sidebar-icon" src="./img/notice.png" alt="">
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img class="sidebar-icon" src="./img/logout.png" alt="">
                        </a>
                    </li>
                </ul>
            </div>

            <div class="course-sidebar-right">
                <div class="sidebar-logo">
                    <a href=""><h1>CHECK</h1></a>
                    <h3>HTML의 기초</h3>
                        <hr>
                </div>

                <div id="mobile-menu">
                    <h1 id="backBtn">◀</h1>
                    <h1 class="menuName">HTML의 기초</h1>
                    <div id="mobile-menu-icon">
                        <svg xmlns="http://www.w3.org/2000/svg" width="30px" height="30px" viewBox="0 0 24 24" fill="none">
                            <path d="M4 6H20M4 12H20M4 18H20" stroke="#000000" stroke-width="2" stroke-linecap="round"
                                stroke-linejoin="round" />
                        </svg>
                    </div>
                </div>
                <!-- 강사/학생에 따라 인라인 css 적용 -->
                <ul class="sidebar-menu">
                    <a href="" class="sidebar-menu-selected" style="width:25%"><li>홈</li></a>
                    <a href="" class="sidebar-menu-unselected" style="width:25%"><li>강의 게시판</li></a>
                    <a href="" class="sidebar-menu-unselected" style="width:25%"><li>출결 확인</li></a>
                    <a href="" class="sidebar-menu-unselected" style="width:25%"><li>수강 신청 관리</li></a>
                    <a href="" class="sidebar-menu-unselected" style="width:25%"><li>강의 일정 관리</li></a>
                </ul>

                <ul id="menuList" style="visibility: hidden;">
                    <li>코스</li>
                    <li>출석 체크</li>
                    <li>수강 신청</li>
                    <li>알림</li>
                    <li>공지사항</li>
                    <li>마이 페이지</li>
                    <li>로그아웃</li>
                </ul>
            </div>

            
        </aside>
        
        <main>
            <div class="">
                <div class="header">
                    <div class="button">전체 목록</div>
                    <div class="button active">공지 사항</div>
                    <div class="button">강의 자료</div>
                    <div class="button">질문</div>
                </div>

                <div class="formBox">
                    <form>
                    <span class="postType">공지 작성</span> 
                    <button id="postCancelBtn">취소</button><button type="submit" id="postSubmitBtn">등록</button>
                    <hr />

                    <div>
                    <label for="postTitle" class="label">제목</label>
                    <input type="text" name="postTitle" id="postTitle" placeholder="제목을 작성해 주세요." />
                    </div>

                    <div>
                    <label for="postContent" class="label">내용</label>
                    <textarea name="postContent" id="postContent" placeholder="내용을 작성해 주세요."></textarea>
                    </div>

                    <div>
                    <label for="postFile" class="label">파일</label>
                    <label for="postFile" class="custom-file-upload">이미지/문서 첨부</label>
                    <input type="file" name="postFile" id="postFile" />
                    </div>
                    
                </form>
                </div>
            </div>
        </main>
    </div>
</body>

</html>