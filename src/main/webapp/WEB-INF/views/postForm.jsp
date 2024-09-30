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
        <jsp:include page="common/sidebar_course.jsp" />
        
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