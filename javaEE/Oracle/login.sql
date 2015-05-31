system/123456
connect sys/123456 as sysdba
connect scott/tiger as sysdba

show user //查看当前用户

	desc dba_users  //查看 数据字典
	select username from dba_users

	desc dba_tablespaces
	select tablespace_name from dba_tablespaces

	desc user_tablespaces
	select tablespace_name from user_tablespaces

	desc emp   		//雇员表 在scott里 
	desc dept  		//部门表
	desc salgrade   //薪水等级

alter user scott account unlock; //sql语句要有分号
connect scott/tiger
show user

//创建表空间：
SQL> create tablespace test1_tablespace
  2  datafile 'test1file.dbf' size 10m;

表空间已创建。

SQL> create temporary tablespace temptest1_tablespace
  2  tempfile 'tempfile1.dbf' size 2m;

表空间已创建。
//查询：
select file_name from dba_data_files where tablespacename='TEST1_TABLESPACE';
select file_name from dba_temp_files where tablespacename='TEMPTEST1_TABLESPACE';