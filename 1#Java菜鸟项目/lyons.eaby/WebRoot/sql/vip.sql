--vip表 用于储存用户信息--

create table vip
(
       username varchar2(255) primary key,
       userpass varchar2(255) not null,
       phone    varchar2(255),
       address  varchar2(255),
       realname varchar2(255) 
);
