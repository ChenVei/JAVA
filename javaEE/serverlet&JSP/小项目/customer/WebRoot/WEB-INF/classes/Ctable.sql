create database test;
use test;
create table customer
(
id varchar(40) primary key,
name varchar(20) not null,
gender varchar(4) not null,
birthday date,
cellphone varchar(20),
email varchar(40),
preference varchar(255),
type varchar(10),
description varchar(255)
)