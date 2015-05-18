1. backup scott
   exp
2. create user
   create user ws identified by ws default tablespace users quota 10M on users;
   grant create session, create table, create view to ws;
3. import the data
   imp

//备份
create table emp2 as select * from emp;

create table dept2 as select * from dept;
create table salgrade2 as select * from salgrade;
create table emp3 as select * from emp;

//插入
insert into dept2 values (50,'game','bj');
insert into dept2 (deptno, dname) values (60,'game2');
insert into dept2 select * from dept;
rollback;

rownum 不允许取 >= 
select r, ename from
(select rownum r, ename from emp)
where r > 10;

select ename, sal from
  (select ename, sal from emp order by sal desc)
  where rownum <= 5;

//求薪水最高的 第6人至第10人
select ename, sal, r from
	(
	select ename, sal, rownum r from
	(select ename, sal from emp order by sal desc)
	)
where r between 6 and 10;

//更新
update emp2 set sal = sal*2, ename = ename||'-'
	where deptno = 10;
//删除
delete from emp2 where deptno <= 20;


//一个 transaction(事务) 起始于一条 dml(update,insert,delete) 语句，
  结束于commit,ddl(create),dcl(grant),exit语句 (正常状态)
  断点，宕机 会回滚 (非正常状态)