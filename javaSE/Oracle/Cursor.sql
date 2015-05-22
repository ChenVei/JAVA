//游标
declare
  cursor c is
  	select * from emp; --指向结果集的脑袋
  v_emp c%rowtype;
begin
  open c;  --打开才会执行上述语句
	fetch c into v_emp;  --自动移一格
	dbms_output.put_line(v_emp.ename);
  close c;
end;
/

declare
  cursor c is
  	select * from emp; --指向结果集的脑袋
  v_emp c%rowtype;
begin
  open c;  --打开才会执行上述语句
  loop
	fetch c into v_emp;  --自动移一格
	exit when (c%notfound);
	dbms_output.put_line(v_emp.ename);
  end loop;
  close c;
end;
/
declare
  cursor c is
  	select * from emp; --指向结果集的脑袋
  v_emp c%rowtype;
begin
  open c;  --打开才会执行上述语句
  fetch c into v_emp;
  while (c%found) loop
	dbms_output.put_line(v_emp.ename);
    fetch c into v_emp;
  end loop;
  close c;
end;
/

declare
  cursor c is
  	select * from emp; --指向结果集的脑袋
begin
  for v_emp in c loop  --for会自动帮你打开cursor
	dbms_output.put_line(v_emp.ename);
  end loop;
end;
/

//带参游标
declare
  cursor c(v_deptno emp.deptno%type, v_job emp.job%type)
  is
  	select ename, sal from emp where deptno = v_deptno and job = v_job;
  	--v_temp c%rowtype;
begin
  for v_temp in c(30,'CLERK') loop
  	dbms_output.put_line(v_temp.ename);
  end loop;
end;
/

//可更新游标
declare
  cursor c
  is 
  	select * from emp2 for update;
  --v_temp c%rowtype;
begin
  for v_temp in c loop
  	if(v_temp.sal < 2000) then
  	  update emp2 set sal = sal * 2 where current of c;
  	elsif (v_temp.sal = 5000) then
  	  delete from emp2 where current of c;
  	end if;
  	end loop;
end;