select ename, sal/12 "Daily Salary" from emp;  //日薪，别名

select ename||'--'||sal from emp; //字符串连接，''表示一个

select distinct deptno from emp;  //去重

select * from emp where job = 'CLERK';

select sal from emp where sal between 800 and 1500;
select sal from emp where sal >= 800 and sal <= 1500;

select ename, sal,comm from emp where comm is null; //is not

select sal from emp where in (800, 1500, 5000);

select hiredate from emp where hiredate > '20-2月 -81'；

select ename from emp where ename like '%AR%';
select ename from emp where ename like '_A%';
select ename from emp where ename like '%$%%' escape '$'; //转义

select * from dept order by deptno desc;  
select sal,ename from emp order by sal asc;  //asc可以省略
select ename, sal, deptno from emp order by deptno,sal desc;

 select ename, sal*12 as annual_sal from emp
 where ename not like '_A%' and sal > 800
 order by sal;