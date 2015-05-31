//数据字典表
desc user_tables
select table_name from user_tables;

desc user_views
select view_name from user_views;

desc user_constraints
select constraint_name from user_constraints;

desc user_indexes
select index_name from user_indexes; 

//数据字典表的表
desc dictionary
select table_name from dictionary;
select table_name from dictionary 
where table_name like 'USER%';

//创建索引
create index idex_stu_email on stu (email);
//删除索引
drop index idex_stu_email; 

create table article
(
id number,
title varchar2(1024),
cont long
);

//创建序列
create sequence seq;
select seq.nextval from dual;
insert into article values (seq.nextval,'a','b');