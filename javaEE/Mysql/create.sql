create database mydata;
use mydata;

create table dept
	(
	deptno int primary key,
	dname varchar(14),
	loc varchar(13)
	);
create table emp
	(
	empno int primary key,
	ename varchar(10),
	job varchar(10),
	mgr int,
	hiredate datetime,
	sal double,
	comm double,
	deptno int,
	foreign key (deptno) references dept(deptno)
	);

show databases;
show tables;
desc dept;

insert into dept values (10,'A','A');
insert into dept values (20,'B','B');
insert into dept values (30,'C','C');
insert into dept values (40,'D','D');
insert into dept values (50,'E','E');

delete from dept;

//分页
select * from dept order by deptno desc limit 3,2; --从第三条后数两条

//自增
create table article
	(
	id int primary key auto_increment,
	title varchar(255)
	);
insert into article values (null,'a');
insert into article values (null,'b');
insert into article (title) values ('c');

//日期处理
select now();
select date_format(now(),'%Y-%m-%d %H:%i:%s');

insert into emp values (9999,'test','clerk',7369,'1981-12-23 12:23:23',8000,80,10);