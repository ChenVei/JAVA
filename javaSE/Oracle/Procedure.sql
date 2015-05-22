//存储过程
create or replace procedure p  //用来代替declare
is							   //调用 execute p或begin p end;
...

//带参数存储过程
//类似于形参 和 实参&
create or replace procedure p
  (v_a in number, v_b number, v_ret out number, v_temp in out number) --默认是in
is 
begin
  if (v_a > v_b) then
  	v_ret := v_a;
  else
  	v_ret := v_b;
  end if;
  v_temp := v_temp + 1;
end;
/
调用过程
declare
  v_a number := 3;
  v_b number := 4;
  v_ret number;  --用于接收
  v_temp number := 5;  --用于传入 和 接受
begin
  p(v_a, v_b, v_ret, v_temp);
  dbms_output.put_line(v_ret);
  dbms_output.put_line(v_temp);
end;
/

create or replace function sal_tax
  (v_sal number)
  return number
is begin
  if (v_sal < 2000) then
  	return 0.10;
  elsif ( v_sal <2750) then
    return 0.15;
  else 
  	return 0.20;
  end if;
end;
/
select ename,sal,sal_tax(sal) from emp2 order by sal;