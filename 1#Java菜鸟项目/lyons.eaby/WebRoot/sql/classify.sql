-- 商品分类表 --

create table classify
(
       gid   number(11) primary key,
       gname varchar2(200) not null
);

-- 为classify表主键gid生成唯一 序列
create sequence classify_seq
       start with   1
       increment by 1
       minvalue     1
       maxvalue     10000
       nocycle
       cache        10
       
--创建触发器
create trigger classify_tigger
       before insert on classify
       for each row 
         begin
           select classify_seq.nextval into :new.gid from dual;
         end;
       
       
