select * from member;
create table member(
			 id varchar2(20) primary key,
			 pw varchar2(20),
			 name varchar2(20),
			 reg_date varchar2(20),
			 ssn varchar2(10),
			 email varchar2(30),
			 profile_img varchar2(100)
			 );

--CREATE
insert into member(id,pw,name,reg_date,ssn,email,profile_img)
values('lee','1','이순신','2016-07-01','800101-1','lee@test.com','lee.jpg');
insert into member(id,pw,name,reg_date,ssn,email,profile_img)
values('hong1','1','홍길동','2015-07-01','901201-1','hong@test.com','hong.jpg');
insert into member(id,pw,name,reg_date,ssn,email,profile_img)
values('you','1','유관순','2014-07-01','010701-4','you@test.com','you.jpg');
insert into member(id,pw,name,reg_date,ssn,email,profile_img)
values('hong','1','홍길동','2015-07-01','301201-1','hoing2@test.com','hong.jpg');
insert into member(id,pw,name,reg_date,ssn,email,profile_img)
values('hong3','1','홍길동','2015-07-01','501201-1','hong3@test.com','hong3.jpg');
insert into member(id,pw,name,reg_date,ssn,email,profile_img)
values('choi','1','최진실','2015-07-01','501201-1','choi@test.com','choi.jpg');

--READ ()// static 개념으로 접근한다
select * from member;-- list
select * from member where id = 'hong';-- findByPK map의 키값
select * from member where gender = '남';-- findByNotPK
select count(*) as count from member;--- count
--UPDATE
alter table member add email varchar2(30);
alter table member add profile_img varchar2(100);
update member set email='hong@test.com' where id = 'you';
update member set email= id||'@test.com';
update member set profile_img= id||'.jpg';
update member set reg_date = '2015-03-03' where reg_date is null;
update member set reg_date = '2013-06-29' where id = 'ogong';
--delete
delete from member where id = 'qqq';

drop table member1;