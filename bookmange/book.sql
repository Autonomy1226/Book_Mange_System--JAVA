drop database if exists book;
create database book character set UTF8;
use book;
drop table if exists user;

create table `user`(
    `id` int(11) NOT NULL auto_increment,
    `username` varchar(50) default NULL,
    `password` varchar(32) NOT NULL,
    `power` int(11) default 1,
  PRIMARY KEY  (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `user`(`id`,`username`,password,`power`) values(1,'root','root',10);

drop table if exists book;
create table `book`(
    `id` int(11) NOT NULL AUTO_INCREMENT,
    book_name varchar(60) default NULL,
    book_author varchar(60) default NULL,
    book_number int ,
    book_type varchar(20) ,
    book_concern varchar(55) ,
    language_type char(30) default NULL,
    book_price double,
    remark text,
    PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;