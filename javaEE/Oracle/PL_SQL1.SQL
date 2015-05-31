SQL语句应用
declare 
  v_ename emp.ename%type;
  v_sal emp.sal%type;
begin
  select ename,sal into v_ename,v_sal from emp where empno = 7369;  --必须有into
  dbms_output.put_line(v_ename||' '||v_sal);  --返回 保证有且只有一条记录
end;
/

declare 
  v_emp emp%rowtype;
begin
  select * into v_emp from emp where empno = 7369;
  dbms_output.put_line(v_emp.ename);
end;
/

declare
  v_deptno dept.deptno%type := 50;
  v_dname dept.dname%type := 'aaaa';
  v_loc dept.loc%type := 'bj';
begin
  insert into dept2 values (v_deptno,v_dname,v_loc);
end;
/

declare
  v_deptno emp2.deptno%type := 10;
  v_count number;
begin
  --update emp2 set sal = sal/2 where deptno = v_deptno;
  --select deptno into v_deptno from emp2 where empno = 7369;
  select count(*) into v_count from emp2;
  dbms_output.put_line(sql%rowcount||' records were modified.'); --sql代表刚执行的update语句
end;
/

DDL:
begin
  --execute immediate 'create table T (nnn varchar2(20) default ''aaa'')';
  execute immediate 'drop table T';
end;
/

//if语句：
declare 
  v_sal emp.sal%type;
begin
  select sal into v_sal from emp
  	where empno = 7369;
  if (v_sal < 1200) then
  	dbms_output.put_line('low');
  elsif(v_sal < 2000) then
  	dbms_output.put_line('middle');
  else
  	dbms_output.put_line('high');
  end if;
end;
/

//循环语句：
declare
  i binary_integer := 1;
begin
  loop
  	dbms_output.put_line(i);
  	i := i + 1;
  	exit when (i >= 11);
  end loop;
end;
/
declare
  j binary_integer := 1;
begin
  while j < 11 loop
  	dbms_output.put_line(j);
  	j := j + 1;
  end loop;
end;
/
begin
  for k in 1..10 loop
  	dbms_output.put_line(k);
  end loop;
  for k in reverse 1..10 loop
 	dbms_output.put_line(k);
  end loop;
end;
/
