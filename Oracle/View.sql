conn sys/123456 as sysdba
grant create table, create view to scott;

//求平均薪水等级最低的 部门名称

create view v$_dept_avg_sal_info as
	select deptno, grade, avg_sal from
	  (select deptno, avg(sal) avg_sal from emp group by deptno) t
	  join salgrade s on (t.avg_sal between s.losal and s.hisal);

select dname, t1.deptno, grade, avg_sal from
	v$_dept_avg_sal_info t1
join dept on (t1.deptno = dept.deptno)
where t1.grade = 
(
	select min(grade) from
	v$_dept_avg_sal_info
);