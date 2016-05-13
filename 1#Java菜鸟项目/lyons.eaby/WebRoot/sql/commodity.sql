-- commodity表 储存商品信息 --
create table commodity
(
    commodity_number varchar2(255) primary key,
    commodity_name   varchar(255) not null,
    commodity_made   varchar2(255),
    commodity_price  NUMBER(18,2) not null,
    commodity_balance NUMBER(7) not null,
    commodity_pic    varchar2(255)not null,
    commodity_id number(11) references classify(gid) not null
);
-- 为commodity表主键gid生成唯一 序列--
create sequence commodity_seq
       start with   1
       increment by 1
       minvalue     1
       maxvalue     100000
       nocycle
       cache        10
       
--创建触发器
create trigger commodity_trigger
       before insert on commodity
       for each row 
         begin
           select commodity_seq.nextval into :new.commodity_number from dual;
         end;

         
