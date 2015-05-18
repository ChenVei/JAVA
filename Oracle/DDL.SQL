//创建表
create table t (a varchar2(10));

//字段级约束
create table stu
	(
	  id number(6),
	  name varchar2(20) constraint stu_name_nn not null,
	  sex number(1),
	  age number(3),
	  sdate date,
	  grade number(2) default 1,
	  class number(4),
	  email varchar2(50) unique
	);
insert into stu(id, sex) values (1, 0); 

//表级约束
create table stu
	(
	  id number(6),
	  name varchar2(20) constraint stu_name_nn not null,
	  sex number(1),
	  age number(3),
	  sdate date,
	  grade number(2) default 1,
	  class number(4),
	  email varchar2(50),
	  constraint stu_name_email_uni unique(email,name)
	);	

//非空，唯一，主键，外键，check

create table stu
	(
	  id number(6),
	  name varchar2(20) constraint stu_name_nn not null,
	  sex number(1),
	  age number(3),
	  sdate date,
	  grade number(2) default 1,
	  class number(4), /*references class(id)*/
	  email varchar2(50),
	  constraint stu_class_fk foreign key (class) references class(id),
	  constraint stu_id_pk primary key (id, name),
	  constraint stu_name_email_uni unique(email,name)
	);
insert into stu(id,name,email) values (null,'a','a');
insert into stu(id,name,class,email) values (1,'a',100,'a');
//语法来说，primary含义not null,unique
//外键约束被参考的字段必须是主键
delete from class where id = 100;

create table class
	(
	  id number(4) primary key,
	  name varchar2(20) not null
	);


//修改表结构
alter table stu add(addr varchar2(100));
alter table stu drop (addr);

alter table stu modify (addr varchar2(50));

alter table stu drop constraint stu_class_fk;
alter table stu add constraint stu_class_fk foreign key(class) references class(id);


//删除表
drop table t;