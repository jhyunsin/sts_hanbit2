-- 메타
select object_name from user_procedures order by object_name asc;
select * from member;
-- CREATE
DROP SEQUENCE seq;
DROP SEQUENCE art_seq;
DROP SEQUENCE subj_seq;
DROP SEQUENCE major_seq;
DROP SEQUENCE exam_seq;
CREATE SEQUENCE grade_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE art_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE subj_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE major_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE exam_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;

-- SELECT SEQUENCE_OWNER, SEQUENCE_NAME FROM ALL_SEQUENCES WHERE SEQUENCE_OWNER = 'HANBIT';

DROP TABLE Major CASCADE CONSTRAINT;
DROP TABLE Member CASCADE CONSTRAINT;
DROP TABLE Grade CASCADE CONSTRAINT;
DROP TABLE Board CASCADE CONSTRAINT;
DROP TABLE Subject CASCADE CONSTRAINT;
DROP TABLE Exam CASCADE CONSTRAINT;

CREATE TABLE Major(
	major_seq INT PRIMARY KEY,
	title VARCHAR2(20) NOT NULL UNIQUE
);
CREATE TABLE Member(
	mem_id VARCHAR2(20) PRIMARY KEY,
	pw VARCHAR2(20) NOT NULL,
	name VARCHAR2(20) NOT NULL,
	gender VARCHAR2(10) NOT NULL,
	reg_date VARCHAR2(20) NOT NULL,
	ssn VARCHAR2(10) NOT NULL UNIQUE,
	email VARCHAR2(30),
	profile_img VARCHAR2(100) DEFAULT 'default.jpg',
	role VARCHAR2(10) DEFAULT 'STUDENT',
	phone VARCHAR2(13) NOT NULL UNIQUE,
	major_seq INT,
	CONSTRAINT gender_ck CHECK (gender IN ('MALE', 'FEMALE')),
	CONSTRAINT major_member_fk FOREIGN KEY (major_seq) REFERENCES Major(major_seq) ON DELETE CASCADE
);
CREATE TABLE Grade(
	grade_seq INT PRIMARY KEY,
	grade VARCHAR2(5) NOT NULL,
	term VARCHAR2(10) NOT NULL,
	mem_id VARCHAR2(20) NOT NULL,
	CONSTRAINT member_grade_fk FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE
);
CREATE TABLE Board(
	art_seq INT PRIMARY KEY,
	category VARCHAR2(20) NOT NULL UNIQUE,
	title VARCHAR2(30) DEFAULT 'NO TITLE',
	reg_date VARCHAR2(20) NOT NULL,
	content VARCHAR2(100) DEFAULT 'NO CONTENT',
	mem_id VARCHAR2(20),
	CONSTRAINT member_board_fk FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE
);
CREATE TABLE Subject(
	subj_seq INT PRIMARY KEY,
	subj_name VARCHAR2(20) NOT NULL UNIQUE,
	mem_id VARCHAR2(20)NOT NULL,
	CONSTRAINT member_subject_fk FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE
);
CREATE TABLE Exam(
	exam_seq INT PRIMARY KEY,
	term VARCHAR2(10)NOT NULL,
	score INT DEFAULT 0,
	subj_seq INT,
	mem_id VARCHAR2(20),
	CONSTRAINT subject_exam_fk FOREIGN KEY (subj_seq) REFERENCES Subject(subj_seq) ON DELETE CASCADE,
	CONSTRAINT member_exam_fk FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE
);

-- VIEW
CREATE OR REPLACE VIEW Major_view
AS
SELECT 
	m.major_seq AS majorSeq,
	m.title AS majorTitle,
	u.mem_id AS id,
	u.pw AS pw,
	u.name AS name,
	u.gender AS gender,
	u.reg_date AS regDate,
	u.ssn AS ssn,
	u.email AS email,
	u.profile_img AS profileImg,
	u.role AS role,
	u.phone AS phone
FROM Major m, Member u
WHERE m.major_seq = u.major_seq;

CREATE OR REPLACE VIEW Grade_view
AS
SELECT 
    x.exam_seq AS examSeq,
	x.score AS score,
	s.subj_seq AS subjSeq,
	s.subj_name AS subjName,
	g.grade_seq AS gradeSeq,
	g.grade AS grade,
	g.term AS term,
	u.mem_id AS id,
	u.pw AS pw,
	u.name AS name,
	u.gender AS gender,
	u.reg_date AS regDate,
	u.ssn AS ssn,
	u.email AS email,
	u.profile_img AS profileImg,
	u.role AS role,
	u.phone AS phone,
	u.birth AS birth
FROM Member u, Grade g, Subject s, Exam x
WHERE u.mem_id = g.mem_id AND u.mem_id = s.mem_id AND u.mem_id = x.mem_id;

CREATE OR REPLACE VIEW Board_view
AS
SELECT 
	b.art_seq AS artSeq,
	b.category AS category,
	b.title AS title,
	b.reg_date AS writeDate,
	b.content AS content,
	u.mem_id AS id,
	u.pw AS pw,
	u.name AS name,
	u.gender AS gender,
	u.reg_date AS regDate,
	u.gender AS gender,
	u.ssn AS ssn,
	u.email AS email,
	u.profile_img AS profileImg,
	u.phone AS phone,
	u.role AS role
FROM Member u,Board b
WHERE u.mem_id = b.mem_id;
/*
========= META_PROCEDURE ====
*/	
SELECT OBJECT_NAME FROM USER_PROCEDURES;
DROP PROCEDURE HANBIT.SELECT_MAJOR;
/*
============ MAJOR ==========
@AUTHOR : pakjkwan@gmail.com
@CREATE DATE : 2016-9-8
@UPDATE DATE : 2016-9-9
@DESC : 전공
==============================
*/
-- SP_INSERT_MAJOR
CREATE OR REPLACE PROCEDURE insert_major(sp_title IN Major.title%TYPE) AS
BEGIN
	INSERT INTO Major(major_seq,title) VALUES(major_seq.nextval,sp_title);
END insert_major;
-- EXE_INSERT_MAJOR
EXEC HANBIT.INSERT_MAJOR('컴퓨터공학');
-- SP_COUNT_MAJOR
CREATE OR REPLACE PROCEDURE count_major(sp_count OUT NUMBER) AS 
BEGIN SELECT COUNT(*) into sp_count FROM Major;END count_major;
-- EXE_COUNT_MAJOR
DECLARE sp_count NUMBER;BEGIN count_major(sp_count);DBMS_OUTPUT.put_line ('전공 수량 : '||sp_count);END;
-- SP_FIND_BY_MAJOR_SEQ
CREATE OR REPLACE PROCEDURE find_by_major_seq(
	sp_major_seq IN OUT Major.major_seq%TYPE,
	sp_title OUT Major.title%TYPE,
	sp_result OUT VARCHAR2
) AS 
    sp_temp_count NUMBER;
BEGIN
    SELECT COUNT(*) into SP_temp_count from major where major_seq = sp_major_seq; 
	IF (sp_temp_count > 0) 
	THEN
        SELECT major_seq, title
        INTO sp_major_seq,sp_title 
        FROM Major 
        WHERE major_seq = sp_major_seq;
        sp_result :='과목번호 : '||sp_major_seq||', 과목명 : '||sp_title;
    ELSE  
        sp_result :='전공 과목이 없습니다';
    END IF;
END find_by_major_seq;
-- EXE_FIND_BY_MAJOR_SEQ
DECLARE
 sp_major_seq NUMBER := 1001;
 sp_result VARCHAR2(100);
 sp_title VARCHAR2(100);
BEGIN
 find_by_major_seq(sp_major_seq,sp_title,sp_result);
  DBMS_OUTPUT.put_line (sp_result);
 END;
-- SP_ALL_MAJOR(CURSOR VERSION)
CREATE OR REPLACE PROCEDURE HANBIT.all_major(
    major_cur OUT SYS_REFCURSOR
) IS
BEGIN
    OPEN major_cur FOR SELECT major_seq,title FROM major;
END all_major;
-- EXE_ALL_MAJOR(CURSOR VERSION)
DECLARE
  sp_cursor  SYS_REFCURSOR;
  sp_major_seq   Major.major_seq%TYPE;
  sp_title   Major.title%TYPE;
BEGIN
  all_major (sp_cursor);         
  LOOP 
    FETCH sp_cursor
    INTO  sp_major_seq, sp_title;
    EXIT WHEN sp_cursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(sp_major_seq || ',' ||sp_title);
  END LOOP;
  CLOSE sp_cursor;
END;
-- SP_ALL_MAJOR(CLOB VERSION)
CREATE OR REPLACE PROCEDURE HANBIT.all_major(
    sp_result OUT CLOB
) AS
    sp_temp CLOB;
    sp_cnt  NUMBER := 0;
BEGIN
        
    FOR major_rec IN (SELECT m.major_seq
                            ,m.title
                      FROM   major m
                     )
    LOOP
        sp_cnt := sp_cnt + 1;
        IF sp_cnt = 1 THEN
           sp_temp := major_rec.major_seq||','||major_rec.title;
           
        ELSE
        
          sp_temp := sp_temp||CHR(10)||
                     major_rec.major_seq||','||major_rec.title;
          
        END IF;
    END LOOP;
    
    sp_result := sp_temp;
    
END all_major;
-- EXE_ALL_MAJOR(CLOB VERSION)
DECLARE sp_result CLOB; BEGIN all_major(sp_result);DBMS_OUTPUT.PUT_LINE(sp_result);END; 
-- SP_UPDATE_MAJOR
CREATE OR REPLACE PROCEDURE update_major(
  sp_major_seq IN Major.major_seq%TYPE,
  sp_title IN Major.title%TYPE
)AS BEGIN UPDATE Major SET title = sp_title WHERE major_seq = sp_major_seq;END update_major;
-- EXE_UPDATE_MAJOR
BEGIN update_major(1002,'경영학부');END;
-- SP_DELETE_MAJOR
CREATE OR REPLACE PROCEDURE delete_major(sp_major_seq IN Major.major_seq%TYPE)AS 
BEGIN DELETE FROM Major WHERE major_seq = sp_major_seq; END;
-- EXE_DELETE_MAJOR
BEGIN delete_major(1006); END;
/*
========= MEMBER_PROF =======
@AUTHOR : pakjkwan@gmail.com
@CREATE DATE : 2016-9-8
@UPDATE DATE : 2016-9-9
@DESC : 교수
==============================
*/
-- SP_INSERT_PROF
CREATE OR REPLACE PROCEDURE insert_prof(
	sp_mem_id IN Member.mem_id%TYPE,
	sp_pw IN Member.pw%TYPE,
	sp_name IN Member.name%TYPE,
	sp_gender IN Member.gender%TYPE,
	sp_reg_date IN Member.reg_date%TYPE,
	sp_ssn IN Member.ssn%TYPE,
	sp_email IN Member.email%TYPE,
	sp_profile_img IN Member.profile_img%TYPE,
	sp_role IN Member.role%TYPE,
	sp_phone IN Member.phone%TYPE
) AS
BEGIN
	INSERT INTO Member(mem_id,pw,name,gender,reg_date,ssn,email,profile_img,role,phone) 
	VALUES(sp_mem_id,sp_pw,sp_name,sp_gender,sp_reg_date,sp_ssn,sp_email,sp_profile_img,sp_role,sp_phone);
END insert_prof;
-- EXE_INSERT_PROF
EXEC HANBIT.INSERT_PROF('prof_x','1','찰스','MALE','2010-06-01','700101-1','prof_x@test.com','default.jpg','PROF','010-1234-5678');
-- SP_COUNT_PROF
CREATE OR REPLACE PROCEDURE count_prof(sp_count OUT NUMBER) AS 
BEGIN SELECT COUNT(*) into sp_count FROM Member WHERE role='PROF';END count_prof;
-- EXE_COUNT_PROF
DECLARE sp_count NUMBER;BEGIN count_prof(sp_count);DBMS_OUTPUT.put_line ('교수 인원 : '||sp_count||' 명');END;
-- SP_EXIST_MEMBER_ID
CREATE OR REPLACE PROCEDURE exist_member_id(
    sp_mem_id IN Member.mem_id%TYPE,
    sp_count OUT NUMBER
)AS BEGIN SELECT COUNT(*) INTO sp_count FROM Member WHERE mem_id = sp_mem_id;END exist_member_id;
-- EXE_EXIST_MEMBER_ID
DECLARE sp_mem_id VARCHAR2(30) := 'hong';sp_count NUMBER;BEGIN exist_member_id(sp_mem_id,sp_count);DBMS_OUTPUT.put_line ('조회결과는  : '||sp_count||' 명');END;
-- SP_FIND_BY_PROF_ID
CREATE OR REPLACE PROCEDURE find_by_prof_id(
	sp_prof_id IN Member.mem_id%TYPE,
	sp_prof OUT Member%ROWTYPE
) AS BEGIN SELECT * INTO sp_prof FROM Member 
    WHERE mem_id = sp_prof_id AND role='PROF'; END find_by_prof_id;
-- EXE_FIND_BY_PROF_ID
DECLARE
 sp_prof_id VARCHAR2(100) := 'profx';
 sp_prof Member%ROWTYPE;
BEGIN
 find_by_prof_id(sp_prof_id,sp_prof);
  DBMS_OUTPUT.put_line (sp_prof.name);
 END;
 -- SP_ALL_PROF(CURSOR VERSION)
CREATE OR REPLACE PROCEDURE HANBIT.all_prof(
    prof_cur OUT SYS_REFCURSOR
) IS
BEGIN
    OPEN prof_cur FOR SELECT * FROM Member WHERE role = 'PROF';
END all_prof;
 -- EXE_ALL_PROF(CURSOR VERSION)
DECLARE
  sp_cursor  SYS_REFCURSOR;
  sp_prof Member%ROWTYPE;
BEGIN
  all_prof (sp_cursor);         
  LOOP 
    FETCH sp_cursor
    INTO  sp_prof;
    EXIT WHEN sp_cursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(sp_prof.mem_id || ' : '||sp_prof.name || '   교수 : '||sp_prof.email);
  END LOOP;
  CLOSE sp_cursor;
END;
-- SP_UPDATE_PROF
CREATE OR REPLACE PROCEDURE update_prof(
  sp_prof_id IN Member.mem_id%TYPE,
  sp_pw IN Member.pw%TYPE,
  sp_email IN Member.email%TYPE,
  sp_phone IN Member.phone%TYPE
)AS BEGIN UPDATE Member SET pw = sp_pw , email = sp_email 
, phone = sp_phone WHERE mem_id = sp_prof_id;END update_prof;
-- EXE_UPDATE_PROF
BEGIN update_prof('profx','1','change@test.com','101-9999-9999');END;
-- SP_DELETE_PROF
CREATE OR REPLACE PROCEDURE delete_prof(sp_prof_id IN Member.mem_id%TYPE)AS 
BEGIN DELETE FROM Member WHERE mem_id = sp_prof_id; END;
-- EXE_DELETE_PROF
BEGIN delete_prof('profx'); END;
/*
========= MEMBER_STUDENT =====
@AUTHOR : pakjkwan@gmail.com
@CREATE DATE : 2016-9-8
@UPDATE DATE : 2016-9-9
@DESC : 학생
==============================
*/
-- SP_INSERT_STUDENT
CREATE OR REPLACE PROCEDURE insert_student(
	sp_mem_id IN Member.mem_id%TYPE,
	sp_pw IN Member.pw%TYPE,
	sp_name IN Member.name%TYPE,
	sp_gender IN Member.gender%TYPE,
	sp_reg_date IN Member.reg_date%TYPE,
	sp_ssn IN Member.ssn%TYPE,
	sp_email IN Member.email%TYPE,
	sp_profile_img IN Member.profile_img%TYPE,
	sp_role IN Member.role%TYPE,
	sp_phone IN Member.phone%TYPE,
	sp_major_seq IN Member.major_seq%TYPE 
) AS
BEGIN
	INSERT INTO Member(mem_id,pw,name,gender,reg_date,ssn,email,profile_img,role,phone,major_seq) 
	VALUES(sp_mem_id,sp_pw,sp_name,sp_gender,sp_reg_date,sp_ssn,sp_email,sp_profile_img,sp_role,sp_phone,sp_major_seq);
END insert_student;
-- EXE_INSERT_STUDENT
EXEC HANBIT.INSERT_STUDENT('lee1','1','이순신','MALE','2000-06-01','800101-1','lee1@test.com','default.jpg','STUDENT','010-1111-5678','1001');
EXEC HANBIT.INSERT_STUDENT('lee2','1','이정재','MALE','2001-06-01','800101-1','lee2@test.com','default.jpg','STUDENT','010-2222-5678','1001');
EXEC HANBIT.INSERT_STUDENT('lee3','1','이민우','MALE','2002-06-01','800101-1','lee3@test.com','default.jpg','STUDENT','010-3333-5678','1001');
EXEC HANBIT.INSERT_STUDENT('lee4','1','이을동','MALE','2003-06-01','800101-1','lee4@test.com','default.jpg','STUDENT','010-4444-5678','1001');
EXEC HANBIT.INSERT_STUDENT('lee5','1','이기우','MALE','2004-06-01','800101-1','lee5@test.com','default.jpg','STUDENT','010-55555-5678','1001');
EXEC HANBIT.INSERT_STUDENT('lee6','1','이나나','MALE','2005-06-01','800101-1','l336@test.com','default.jpg','STUDENT','010-6666-5678','1001');
EXEC HANBIT.INSERT_STUDENT('lee7','1','이다다','MALE','2006-06-01','800101-1','lee7@test.com','default.jpg','STUDENT','010-7777-5678','1001');
EXEC HANBIT.INSERT_STUDENT('lee8','1','이라라','MALE','2007-06-01','800101-1','lee8@test.com','default.jpg','STUDENT','010-8888-5678','1001');
EXEC HANBIT.INSERT_STUDENT('lee9','1','이마맘','MALE','2008-06-01','800101-1','lee9@test.com','default.jpg','STUDENT','010-9999-5678','1001');
EXEC HANBIT.INSERT_STUDENT('lee10','1','이저저','MALE','2009-06-01','800101-1','lee10@test.com','default.jpg','STUDENT','010-1010-5678','1001');
EXEC HANBIT.INSERT_STUDENT('jang1','1','장일일','MALE','2009-01-01','800101-1','jang1@test.com','default.jpg','STUDENT','010-0111-5678','1001');
EXEC HANBIT.INSERT_STUDENT('jang2','1','장이이','MALE','2009-02-01','800101-1','jang2@test.com','default.jpg','STUDENT','010-0222-5678','1001');
-- SP_COUNT_STUDENT
CREATE OR REPLACE PROCEDURE count_student(sp_count OUT NUMBER) AS 
BEGIN SELECT COUNT(*) into sp_count FROM Member WHERE role='STUDENT'; commit; END count_student;
-- EXE_COUNT_STUDENT
DECLARE sp_count NUMBER;BEGIN count_student(sp_count);DBMS_OUTPUT.put_line ('학생 인원 : '||sp_count||' 명');END;
-- SP_FIND_BY_STUDENT_ID
CREATE OR REPLACE PROCEDURE find_by_student_id(
	sp_student_id IN Member.mem_id%TYPE,
	sp_student OUT Member%ROWTYPE
) AS BEGIN SELECT * INTO sp_student FROM Member 
    WHERE mem_id = sp_student_id AND role='STUDENT'; END find_by_student_id;
-- EXE_FIND_BY_STUDENT_ID
DECLARE
 sp_student_id VARCHAR2(100) := 'test';
 sp_student Member%ROWTYPE;
BEGIN
 find_by_student_id(sp_student_id,sp_student);
  DBMS_OUTPUT.put_line (sp_student.name);
 END;
 -- SP_ALL_STUDENT(CURSOR VERSION)
CREATE OR REPLACE PROCEDURE HANBIT.all_student(
    student_cur OUT SYS_REFCURSOR
) IS
BEGIN
    OPEN student_cur FOR SELECT * FROM Member WHERE role = 'STUDENT';
END all_student;
 -- EXE_ALL_STUDENT(CURSOR VERSION)
DECLARE
  sp_cursor  SYS_REFCURSOR;
  sp_student Member%ROWTYPE;
BEGIN
  all_student (sp_cursor);         
  LOOP 
    FETCH sp_cursor
    INTO  sp_student;
    EXIT WHEN sp_cursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(sp_student.mem_id || ' : '||sp_student.name
     || '   학생 : '||sp_student.email);
  END LOOP;
  CLOSE sp_cursor;
END;
-- SP_UPDATE_STUDENT
CREATE OR REPLACE PROCEDURE update_student(
  sp_student_id IN Member.mem_id%TYPE,
  sp_pw IN Member.pw%TYPE,
  sp_email IN Member.email%TYPE,
  sp_phone IN Member.phone%TYPE
)AS BEGIN UPDATE Member SET pw = sp_pw , email = sp_email , phone = sp_phone WHERE mem_id = sp_student_id;END update_student;
-- EXE_UPDATE_STUDENT
BEGIN update_student('profx','1','change@test.com','101-9999-9999');END;
-- SP_DELETE_STUDENT
CREATE OR REPLACE PROCEDURE delete_student(sp_student_id IN Member.mem_id%TYPE)AS BEGIN DELETE FROM Member WHERE mem_id = sp_student_id; END;
-- EXE_DELETE_STUDENT
BEGIN delete_prof('profx'); END;
/*
=========== SUBJECT =========
@AUTHOR : pakjkwan@gmail.com
@CREATE DATE : 2016-9-8
@UPDATE DATE : 2016-9-9
@DESC : 과목
=============================
*/
-- SP_INSERT_SUBJECT
CREATE OR REPLACE PROCEDURE insert_subject(
	sp_subj_name IN Subject.subj_name%TYPE,
	sp_mem_id IN Subject.mem_id%TYPE
) AS
BEGIN
	INSERT INTO Subject(subj_seq,subj_name,mem_id) 
	VALUES(subj_seq.NEXTVAL,sp_subj_name,sp_mem_id);
END insert_subject;
-- EXE_INSERT_SUBJECT
EXEC HANBIT.INSERT_SUBJECT('java','profx');
/*
=========== EXAM ===========
@AUTHOR : pakjkwan@gmail.com
@CREATE DATE : 2016-9-8
@UPDATE DATE : 2016-9-9
@DESC : 시험
============================
*/
-- SP_INSERT_EXAM
CREATE OR REPLACE PROCEDURE insert_exam(
	sp_exam_seq IN Exam.exam_seq%TYPE,
	sp_term IN Exam.term%TYPE,
	sp_score IN Exam.score%TYPE,
	sp_subj_seq IN Exam.subj_seq%TYPE,
	sp_mem_id IN Exam.mem_id%TYPE
) AS
BEGIN
	INSERT INTO Exam(exam_seq,term,score,subj_seq,mem_id) 
	VALUES(sp_exam_seq,sp_term,sp_score,sp_subj_seq,sp_mem_id);
END insert_exam;
/*
============ GRADE =========
@AUTHOR : pakjkwan@gmail.com
@CREATE DATE : 2016-9-8
@UPDATE DATE : 2016-9-9
@DESC : 성적
============================
*/
-- SP_INSERT_GRADE
CREATE OR REPLACE PROCEDURE insert_grade(
	sp_grade_seq IN Grade.grade_seq%TYPE,
	sp_grade IN Grade.grade%TYPE,
	sp_term IN Grade.term%TYPE,
	sp_mem_id IN Grade.mem_id%TYPE
) AS
BEGIN
	INSERT INTO Grade(grade_seq,grade,term,mem_id) 
	VALUES(sp_grade_seq,sp_grade,sp_term,sp_mem_id);
END insert_grade;
/*
========== BOARD_QNA ========
@AUTHOR : pakjkwan@gmail.com
@CREATE DATE : 2016-9-8
@UPDATE DATE : 2016-9-9
@DESC : QNA
=============================
*/
-- SP_INSERT_QNA	
CREATE OR REPLACE PROCEDURE insert_qna(
	sp_art_seq IN Board.art_seq%TYPE,
	sp_category IN Board.category%TYPE,
	sp_title IN Board.title%TYPE,
	sp_reg_date IN Board.reg_date%TYPE,
	sp_content IN Board.content%TYPE,
	sp_mem_id IN Board.mem_id%TYPE
) AS
BEGIN
	INSERT INTO Board(art_seq,category,title,reg_date,content,mem_id) 
	VALUES(sp_art_seq,sp_category,sp_title,sp_reg_date,sp_content,sp_mem_id);
END insert_qna;
/*
========= BOARD_NOTICE ======
@AUTHOR : pakjkwan@gmail.com
@CREATE DATE : 2016-9-8
@UPDATE DATE : 2016-9-9
@DESC : 공지사항
=============================
*/
-- SP_INSERT_NOTICE
CREATE OR REPLACE PROCEDURE insert_notice(
	sp_art_seq IN Board.art_seq%TYPE,
	sp_category IN Board.category%TYPE,
	sp_title IN Board.title%TYPE,
	sp_reg_date IN Board.reg_date%TYPE,
	sp_content IN Board.content%TYPE
) AS
BEGIN
	INSERT INTO Board(art_seq,category,title,reg_date,content) 
	VALUES(sp_art_seq,sp_category,sp_title,sp_reg_date,sp_content);
END insert_notice;

-----------행정렬   ----> 페이징(페이스북에 1억명이 돌아갈수 있는 이유!)
select t2.* from(
select rownum seq,t.* from(
select
	m.mem_id id,
	m.name name,
	m.gender gender,
	m.reg_date regDate,
	m.ssn ssn,
	m.email email,
	m.profile_img profileImg,
	m.role role,
	m.phone phone,
	m.major_seq majorSeq
	from Member m order by reg_date desc) t)t2
	where t2.seq between 1 and 12
	order by t2.seq asc;
	
