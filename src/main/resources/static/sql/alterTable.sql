alter table final_attend_response add res_date date default sysdate not null;
alter table final_attend_correq add req_date date default sysdate not null;
drop table final_attend_lvreq;

create table final_attend_lvreq(
student_id number(8) constraint att_lvreq_student_id_fk references final_course_student (student_id)
, req_date date default sysdate not null
, l_sdate date not null
, l_edate date not null
, l_reason varchar2(100) constraint att_lvreq_reason_ck not null check (l_reason in ('훈련', '시험', '면접', '예비군', '결혼', '사망', '질병', '입원', '그 외' ))
, l_contents varchar2(4000) constraint att_lvreq_contents_nn not null
, l_attm varchar2(4000)  
, response_id number(9) constraint att_lvreq_response_id_fk references final_attend_response (response_id)
, constraint att_lvreq_pk primary key (student_id, l_sdate)
);                					


create view course_2_day as (
select s_date
from (
	select to_date((select c_sdate from final_course where course_id=2),'YYYY/MM/DD') + LEVEL -1 as s_date
	from dual 
	connect by level <= (to_date((select c_edate from final_course where course_id=2),'YYYY/MM/DD')-to_date((select c_sdate from final_course where course_id=2),'YYYY/MM/DD') + 1)
)
where to_char(s_date,'D') in ('7', '2', '4'));
