create table emp2_log
(
uname varchar2(20),
action varchar2(20),
atime date
);
create or replace trigger trig
	after insert or delete or update on emp2 for each row  --每更新一行触发一次
begin
	if inserting then
	  insert into emp2_log values (USER,'insert',sysdate);
	elsif updating then
	  insert into emp2_log values (USER,'update',sysdate);
	elsif deleting then
	  insert into emp2_log values (user,'delete',sysdate);
	end if;
end;
/
update emp2 set sal = sal*2 where deptno = 30;


create or replace trigger trig
	after update on dept2
	for each row
begin
	update emp2 set deptno = :NEW.deptno where deptno = OLD.deptno;
end;


//recursion递归
create table article
(
id number primary key,
cont varchar2(4000),
pid number,
isleaf number(1),
alevel number(2)
)
insert into article values (1, '蚂蚁大战大象', 0, 0, 0);
insert into article values (2, '大象被打趴下了', 1, 0, 1);
insert into article values (3, '蚂蚁也不好过', 2, 1, 2);
insert into article values (4, '瞎说', 2, 0, 2);
insert into article values (5, '没有瞎说', 4, 1, 3);
insert into article values (6, '怎么可能', 1, 0, 1);
insert into article values (7, '怎么没可能', 6, 1, 2);
insert into article values (8, '可能性是很大的', 6, 1, 2);
insert into article values (9, '大象进医院了', 2, 0, 2);
insert into article values (10, '护士是蚂蚁', 9, 1, 3);
commit;

create or replace procedure p (v_pid article.pid%type, v_level binary_integer) is
	cursor c is select * from article where pid = v_pid;  --求孩子
	v_preStr varchar2(1024) := '';
begin
	for i in 0..v_level loop
		v_preStr := v_preStr || 'xxx';
	end loop;

	for v_article in c loop
		dbms_output.put_line(v_preStr || v_article.cont);
	if(v_article.isleaf=0) then
	 	p(v_article.id, v_level+1);
	end if;
	end loop;
end;