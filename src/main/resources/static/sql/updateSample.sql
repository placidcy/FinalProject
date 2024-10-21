update final_course_day set d_tue=null, d_thu=null where course_id=2;

/*강사 강의 시간 수정*/
update final_course_instructor set i_sdate=to_date('2024-05-20 09:00:00', 'YYYY-MM-DD HH24:MI:SS') where course_id=2;
update final_course_instructor set i_edate=to_date('2024-05-20 19:00:00', 'YYYY-MM-DD HH24:MI:SS') where course_id=2;
commit;