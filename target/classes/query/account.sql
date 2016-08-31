create table account(
	account_no int primary key,
	money int,
	id varchar2(20)
);

select * from account_member;
select * from member;
select * from account;
insert into account(account_no,money,id) 
values(660102,880,'choi');
insert into account(account_no,name) 
values(900101,'김선달');
----------
constraint bank_member_fk foreign key(id)
references member(id) on delete cascade


drop table account;

update account set money=300 where account_no =621021 ;

----------[외부 스키마 : 논리적]--------------------
create view account_member as
select 
a.account_no as acc,       
a.money as money,
m.id as id, 
m.pw as pw,
m.name as name,
m.reg_date as reg_date,
m.ssn as ssn
from
member m, account a 
where m.id = a.id;

select 
a.account_no as acc,       
a.money as money,
m.id as id, 
m.name as name,
m.ssn as ssn
from
account_member; 