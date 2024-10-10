-- 금일 존재하는 수업에 대하여 강의ID를 반환하는 뷰 생성문
CREATE OR REPLACE VIEW final_course_today AS
SELECT
	course_id
FROM
	final_course_day
WHERE
	CASE
		WHEN TO_CHAR(SYSDATE, 'D') = 1 THEN d_sun
		WHEN TO_CHAR(SYSDATE, 'D') = 2 THEN d_mon
		WHEN TO_CHAR(SYSDATE, 'D') = 3 THEN d_tue
		WHEN TO_CHAR(SYSDATE, 'D') = 4 THEN d_wed
		WHEN TO_CHAR(SYSDATE, 'D') = 5 THEN d_thu
		WHEN TO_CHAR(SYSDATE, 'D') = 6 THEN d_fri
		WHEN TO_CHAR(SYSDATE, 'D') = 7 THEN d_sat
	END = 1
	
-- 자정이 되면 금일 출석 데이터를 새로 추가하는 프로시져 생성문
CREATE OR REPLACE PROCEDURE pro_s_attend_autocreate AS
BEGIN
  INSERT INTO final_student_attend(student_id, a_date)
  SELECT fcs.student_id AS student_id, trunc(sysdate)
  FROM final_course_student fcs
  INNER JOIN final_course fc ON fcs.course_id = fc.course_id
  WHERE sysdate BETWEEN c_sdate AND c_edate
    AND fc.course_id IN (SELECT * FROM final_course_today)
END;

-- 자정이 되면 전일 출석 데이터에 대한 기록을 갱신하는 프로시져 생성문
CREATE OR REPLACE PROCEDURE pro_s_attend_autoupdate AS
BEGIN
  UPDATE final_student_attend
  SET a_status =
    CASE
      WHEN (student_id, a_date) = (
        SELECT student_id, a_yesdate
        FROM final_schedule_yesterday fsy
        INNER JOIN final_course_student fcs ON fsy.course_id = fcs.course_id
        WHERE ((a_couttime - a_cintime) - (a_rettime - a_souttime)) * 24 < 4
      ) THEN 2
      WHEN (student_id, a_date) = (
        SELECT student_id, a_yesdate
        FROM final_schedule_yesterday fsy
        INNER JOIN final_course_student fcs ON fsy.course_id = fcs.course_id
        WHERE a_cintime <= s_cindatetime AND a_couttime >= s_coutdatetime
      ) THEN 1
      WHEN (student_id, a_date) = (
        SELECT student_id, a_yesdate
        FROM final_schedule_yesterday fsy
        INNER JOIN final_course_student fcs ON fsy.course_id = fcs.course_id
        WHERE a_cintime IS NOT NULL AND a_couttime < s_coutdatetime
      ) THEN 4
      WHEN (student_id, a_date) = (
        SELECT student_id, a_yesdate
        FROM final_schedule_yesterday fsy
        INNER JOIN final_course_student fcs ON fsy.course_id = fcs.course_id
        WHERE a_couttime IS NOT NULL AND a_cintime > s_cindatetime
      ) THEN 3
      ELSE 2
    END
  WHERE a_date = TRUNC(SYSDATE-1)
END;

-- 자정이 되면 자동으로 출석 관련 프로시져를 실행하는 JOB 생성문
DECLARE
  N NUMBER;
BEGIN
  SYS.DBMS_JOB.SUBMIT (
    JOB => N,
    WHAT => 'BEGIN pro_s_attend_autocreate(); END;',
    NEXT_DATE => TRUNC(sysdate + 1),
    INTERVAL => 'SYSDATE + 1',
    NO_PARSE => TRUE
  );

  SYS.DBMS_JOB.SUBMIT (
    JOB => N,
    WHAT => 'BEGIN pro_s_attend_autoupdate(); END;',
    NEXT_DATE => TRUNC(sysdate + 1),
    INTERVAL => 'SYSDATE + 1',
    NO_PARSE => TRUE
  );