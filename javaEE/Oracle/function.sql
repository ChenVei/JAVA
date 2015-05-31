 select lower(ename) from emp;
 
 select ename from emp
 where lower(ename) like '_a%';

 select substr(ename,2,3) from emp;
 select chr(65) from dual;
 select ascii('a') from dual;
 select round(23.42314214) from dual;
 select round(23.42314214, 4) from dual;
 select to_char(sal,'$9,999.9999') from emp;

 select to_char(hiredate, 'YYYY-MM-DD HH:MI:SS') from emp;
 select ename, nvl(comm, 0) + 12 * sal from emp;
 
 //组合函数
 select avg(sal) from emp; //max,min,sum;
 select count(*) from emp where deptno = 10; //统计不是空值的个数
 select count(distinct deptno) from emp;
 select avg(sal),deptno from emp group by deptno;

  select max(sal),deptno,job from emp group by deptno, job;

  //选出工资最多的人姓名 按部门
   select ename, deptno, sal from emp
   where sal in (select max(sal) from emp group by deptno)  order by deptno;  //用in是错误的，会有重复值被选入

 select avg(sal) avg_sal, deptno from emp group by deptno having avg(sal)>2000;

 执行顺序：
 1. select * from emp
 2. where sal > 1000
 3. group by deptno
 4. having
 5. order by

select deptno, avg(sal) from emp
where sal > 1200
group by deptno
having avg(sal) > 1500
order by avg(sal) desc;