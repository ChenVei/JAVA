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
	pdate date
);

create table category_book
(
	cid int,
	bid int,
	primary key(cid,bid),
	constraint cid_FK foreign key(cid) references category(id) on delete cascade on update cascade,
	constraint bid_FK foreign key(bid) references book(id) on delete cascade on update cascade
);
