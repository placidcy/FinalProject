alter table final_attend_correq add req_date date default sysdate not null;
alter table final_attend_correq drop column response_id;
drop table final_attend_response;
drop table final_attend_lvreq;

create table final_attend_lvreq(
student_id number(8) constraint att_lvreq_student_id_fk references final_course_student (student_id)
, req_date date default sysdate not null
, l_sdate date not null
, l_edate date not null
, l_reason varchar2(100) constraint att_lvreq_reason_ck not null check (l_reason in ('훈련', '시험', '면접', '예비군', '결혼', '사망', '질병', '입원', '그 외' ))
, l_contents varchar2(4000) constraint att_lvreq_contents_nn not null
, l_attm varchar2(4000)  
, constraint att_lvreq_pk primary key (student_id, l_sdate)
);       

create table final_attend_corres(
response_id number(9) constraint corres_id_pk primary key
, res_date date default sysdate
, r_status number(1) constraint corre_status_ck not null check (r_status in (1,2))
, r_details varchar2(100) constraint corres_details_nn not null
, student_id number(8)  not null
, a_date date not null
, constraint corres_fk foreign key (student_id, a_date) references final_attend_correq (student_id, a_date)
); 

create table final_attend_lvres(
response_id number(9) constraint lvres_id_pk primary key
, res_date date default sysdate
, r_status number(1) constraint lvres_status_ck not null check (r_status in (1,2))
, r_details varchar2(100) constraint lvres_details_nn not null
, student_id number(8) not null
, l_sdate date not null
, constraint lvres_fk foreign key (student_id, l_sdate) references final_attend_lvreq (student_id, l_sdate)
);         					

