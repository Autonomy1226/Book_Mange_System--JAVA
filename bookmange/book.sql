drop database if exists book ;
create database book character set UTF8 ;
use book ;
drop table if exists user ;

CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(50) default NULL,
  `password` varchar(32) NOT NULL,
  `power` int(11) default 1,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

insert into `user`(`id`,`username`,`password`,`power`) values (1,'root','root',10);

CREATE TABLE `book` (
  `id` int(11) NOT NULL auto_increment,
  book_name varchar(50) default NULL,
  book_author varchar(50) default NULL,
  book_number int ,
  book_type varchar(20),
  book_concern varchar(55),
  language_type char(30) default NULL, 
  book_price double,
  remark text,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;