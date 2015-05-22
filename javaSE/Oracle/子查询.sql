
//自连接
select e1.ename, e2.ename from emp e1, emp e2
where e1.mgr = e2.empno;
select e1.ename, e2.ename from emp e1, emp e2, emp e3
where e1.mgr = e2.empno and e2.mgr = e3.empno;

//1992
select ename, dname, grade from emp e, dept d, salgrade s
where e.deptno = d.deptno and e.sal between s.losal and s.hisal and 
job <> 'CLERK';  //连接条件及过滤条件

select ename, dname from emp, dept; //自然连接14*4

select ename, dname from emp, dept  //等值连接
where emp.deptno = dept.deptno;

//1999
select ename, dname from emp cross join dept;  

select ename, dname from emp join dept
on emp.deptno = dept.deptno;

select ename, dname from emp join dept 
using (deptno);  //不推荐，必须俩表都有deptno字段且类型一致

select ename, grade from emp join salgrade s
on (emp.sal between s.losal and s.hisal);

select ename, dname, grade from
emp e join dept d on (e.deptno = d.deptno)
join salgrade s on (e.sal between s.losal and s.hisal)
where ename not like '_A%' 
order by grade;

select e1.ename, e2.ename from 
emp e1 left join emp e2 on (e1.mgr = e2.empno);  //左外连接 ，左边没匹配到的显示出来

select ename, dname from
emp e1 right join dept on (e1.deptno = dept.deptno); //右外连接,省略outer

select e1.ename, e2.ename from 
emp e1 full join emp e2 on (e1.mgr = e2.empno);  //全外连接


