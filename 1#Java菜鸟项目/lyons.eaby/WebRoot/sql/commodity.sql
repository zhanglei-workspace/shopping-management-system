-- commodity表 储存商品信息 --
create table commodity
(
     commodity_number varchar2(255) primary key,
     commodity_name   varchar(255) not null,
     commodity_made   varchar2(255),
     commodity_price  NUMBER(18,2) not null,
     commodity_mess   varchar2(255) ,
     commodity_pic    varchar2(255)not null,
     commodity_id number(11) references classify(gid) not null
);
