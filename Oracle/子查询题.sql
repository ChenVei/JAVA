
//求工资最多的人姓名 按部门
select ename, sal from emp
join (select max(sal) max_sal, deptno from emp group by deptno) t
on (emp.sal = t.max_sal and emp.deptno = t.deptno);

//求每个部门的平均工资 及 等级
select deptno, avg_sal, grade from
(select deptno, avg(sal) avg_sal from emp group by deptno) t
join salgrade s on (t.avg_sal between s.losal and s.hisal);

//求每个部门的平均等级
select deptno, avg(grade) from (
select deptno, ename, grade from emp e join
salgrade s on (e.sal between s.losal and s.hisal)
) group by deptno;

//雇员中哪些人是经理人
select distinct e2.ename from emp e1
join emp e2 on (e1.mgr = e2.empno); 

select ename from emp 
where empno in (select mgr from emp);

//不用组函数，求薪水最高值
select e1.sal from emp e1
left join emp e2 on (e1.sal < e2.sal)
where e2.sal is null;

select distinct sal from emp 
where sal not in (
select e1.sal from emp e1
join emp e2 on (e1.sal < e2.sal) );

//平均薪水最高的 部门编号
select avg_sal, deptno from
(select avg(sal) avg_sal, deptno from emp group by deptno) //这里无法使用别名
where avg_sal = (select max(avg_sal) max from 
(select avg(sal) avg_sal, deptno from emp group by deptno) //提示：表或视图不存在
);

select avg_sal, deptno from
(select avg(sal) avg_sal, deptno from emp group by deptno) 
where avg_sal = (select max(avg(sal)) from emp group by deptno);  //组合函数嵌套，但只能嵌套一层

//平均薪水最高的 部门名称
select dname from dept 
where deptno = (
select deptno from
(select avg(sal) avg_sal, deptno from emp group by deptno) 
where avg_sal = (select max(avg_sal) max from 
(select avg(sal) avg_sal, deptno from emp group by deptno) 
));

//求平均薪水等级最低的 部门名称
select dname, t1.deptno, grade, avg_sal from
	(
	select deptno, grade, avg_sal from 
	    (select deptno, avg(sal) avg_sal from emp group by deptno) t
	join salgrade s on (t.avg_sal between s.losal and s.hisal)
	) t1
join dept on (t1.deptno = dept.deptno)
where t1.grade = 
(
	select min(grade) from
	(
	  select deptno, grade, avg_sal from 
	    (select deptno, avg(sal) avg_sal from emp group by deptno) t
	  join salgrade s on (t.avg_sal between s.losal and s.hisal)
	)
);

//求部门经理人中平均薪水最低的部门名称

//求比 普通员工的最高薪水 还要高的 经理人名称

select ename,sal from emp 
where empno in  
 (select distinct mgr from emp)
and sal > 
(
 select sal from emp
  where empno not in 
  (select distinct mgr from emp 
  	where mgr is not null)
);


有3个表S，C，SC 
S（SNO，SNAME）代表（学号，姓名） 
C（CNO，CNAME，CTEACHER）代表（课号，课名，教师） 
SC（SNO，CNO，SCGRADE）代表（学号，课号, 成绩） 
问题： 
1，找出 没选过“黎明”老师的 所有学生姓名。 
2，列出 2门以上（含2门）不及格 学生姓名及平均成绩。 
3，既学过1号课程又学过2号课所有学生的姓名。 

1.	select sname from S join
	SC on (S.sno = SC.sno) join
	C on (C.cno = SC.cno)
	where c.cteacher <> '黎明';
2.
SELECT t.av,s.SNAME FROM ( 
SELECT sc.SNO,AVG(sc.SCGRADE) AS av FROM Stu_Cau sc 
WHERE sc.SNO IN 
(SELECT SNO FROM Stu_Cau WHERE SCGRADE<60 GROUP BY SNO HAVING COUNT(SNO) >= 2) 
GROUP BY sc.SNO  ) AS t 
LEFT JOIN Student s ON s.SNO = t.SNO 

select sname where sno in
	(
	select sno, count(*) from sc 
	where scgrade < 60
	group by sno having count(*) >= 2
	);
3.
select sname from s 
where sno in
(
	select sno from SC where
	cno = 1 and sno in 
	(select distinct sno from sc where cno = 2)
)