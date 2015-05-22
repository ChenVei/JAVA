数据类型，语法
Procedual Language

set serveroutput on; //指示类型变量默认为off
begin
  dbms_output.put_line('HelloWorld!');
end;
/


declare
  v_name varchar2(20);
begin
  v_name := 'myname';
  dbms_output.put_line(v_name);
end;

declare
  v_num number := 0;
begin
  v_num := 2/v_num;
  dbms_output.put_line(v_num);
exception 
  when others then     //异常捕捉
    dbms_output.put_line('error');
end;

//变量声明
declare
  v_temp number(1);
  v_count binary_integer := 0;  --用于计数
  v_sal number(7,2) := 4000.00;
  v_date date := sysdate;
  v_pi constant number(3,2) := 3.14;
  v_valid boolean := false;  --不能打印布尔类型
  v_name varchar2(20) not null := 'MyName';
begin
  dbms_output.put_line('v_temp value:'||v_pi);
end;
/

declare
  v_empno number(4);
  v_empno2 emp.empno%type;  --动态类型
  v_empno3 v_empno2%type;
begin
 dbms_output.put_line('TEST');
end;

Table变量类型  //类似java数组
declare 
  type type_emp_empno is table of emp.empno%type index by binary_integer;
    v_empnos type_emp_empno;
begin
  v_empnos(0) := 7369;
  v_empnos(2) := 7865;
  v_empnos(-1) := 4583;
  dbms_output.put_line(v_empnos(-1));
end;
/

Record变量类型  //类似java类
declare
  type type_record_dept is record
  (
    deptno dept.deptno%type,
      dname dept.dname%type,
      loc dept.loc%type
  );
  v_temp type_record_dept;
begin
  v_temp.deptno := 50;
  v_temp.dname := 'aaaa';
  v_temp.loc := 'bj';
  dbms_output.put_line(v_temp.deptno||' '||v_temp.dname);
end;
/

declare
  v_temp dept%rowtype;
begin
  v_temp.deptno := 50;
  v_temp.dname := 'aaaa';
  v_temp.loc := 'bj';
  dbms_output.put_line(v_temp.deptno||' '||v_temp.dname);
end;
/