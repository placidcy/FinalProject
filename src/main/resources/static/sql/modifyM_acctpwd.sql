-- 비밀번호 해싱을 위해 컬럼의 크기를 확장했습니다.

ALTER TABLE SCOTT.FINAL_MEMBER
MODIFY M_ACCTPWD VARCHAR2(60);