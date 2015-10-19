create database booklibrary character set utf8;
use booklibrary;
create table category
(
	id int primary key auto_increment,
	name varchar(20) not null unique
);

create table book
(
	id int primary key auto_increment,
	name varchar(20),
	description varchar(200),
	author varchar(20),
	pdate date,
	publisher varchar(45)
);

create table category_book
(
	cid int,
	bid int,
	primary key(cid,bid),
	constraint cid_FK foreign key(cid) references category(id) on delete cascade on update cascade,
	constraint bid_FK foreign key(bid) references book(id) on delete cascade on update cascade
);

create table user
(
	id int primary key auto_increment,
	username varchar(20) not null unique,
	password varchar(20) not null,
	email varchar(30) not null unique,
	admin boolean not null 
)
create table news
(
	id int primary key auto_increment,
	title varchar(40) not null,
	content varchar(3000) not null,
	pdate timestamp not null
)