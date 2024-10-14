-- 테스트용 단일 학생 단일 강사 매일 강의 데이터 추가
-- 테스트용 강의 추가
INSERT INTO FINAL_COURSE fc 
VALUES(8080, 1, '쉽게 배우는 JSP 웹 프로그래밍', null, trunc(sysdate), trunc(sysdate+100), 40, default, default, default);
-- 테스트용 강의 일정 추가
INSERT INTO FINAL_COURSE_SCHEDULE fcs
VALUES(8080, trunc(sysdate), trunc(sysdate+100), '09:00', '18:00', DEFAULT, DEFAULT);
-- 모든 요일에 강의가 존재하도록 추가
INSERT INTO FINAL_COURSE_DAY fcd 
VALUES(8080, 1, 1, 1, 1, 1, 1, 1);
-- 테스트용 학생 데이터 추가
INSERT INTO FINAL_MEMBER fm 
VALUES (8080, '테스트 학생', 'test_student', 'test_password', 'test_email.email.com', NULL, NULL, NULL, DEFAULT, DEFAULT);
-- 테스트용 강사 데이터 추가
INSERT INTO FINAL_MEMBER fm 
VALUES (8081, '테스트 강사', 'test_instructor', 'test_password', 'test_email.email.com', NULL, NULL, NULL, DEFAULT, 2);

-- 강사에게 강의 담당 정보를 배정
INSERT INTO FINAL_COURSE_INSTRUCTOR fci
VALUES(8080, 8081, trunc(sysdate), trunc(sysdate+100));

-- 학생에게 강의 수강 정보를 배정
INSERT INTO FINAL_COURSE_STUDENT fcs
VALUES(9091, 8080, 8080, DEFAULT);