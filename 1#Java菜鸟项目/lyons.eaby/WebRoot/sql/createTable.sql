--商品分类表01--
create table classify
(
       gid   number(11) primary key,
       gname varchar2(200) not null
);

--为classify表主键gid生成唯一 序列--
create sequence classify_seq
       start with   1
       increment by 1
       minvalue     1
       maxvalue     10000
       nocycle
       cache        10;
      
--创建触发器--
create trigger classify_trigger
       before insert on classify
       for each row 
         begin
           select classify_seq.nextval into :new.gid from dual;
         end;
       
       
       
--commodity表 储存商品信息02--

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

--为commodity表主键gid生成唯一 序列--
create sequence commodity_seq
       start with   1
       increment by 1
       minvalue     1
       maxvalue     100000
       nocycle
       cache        10;

--创建触发器--
create trigger commodity_trigger
       before insert on commodity
       for each row 
         begin
           select commodity_seq.nextval into :new.commodity_number from dual;
         end;


--orderForm订单表03 --
create table orderForm 
(
     id number(10) primary key,
     username varchar2(255) not null,
     commodity_name varchar2(255) not null,
     commodity_price NUMBER(18,2) not null,
     orderDate DATE DEFAULT SYSDATE NOT NULL,
     sum number(18,2) 
);

--生成序列--
CREATE SEQUENCE orderForm_seq
       START WITH      1
       INCREMENT BY    1
       MINVALUE        1
       MAXVALUE     100000
       NOCYCLE
       CACHE           10;
      
--触发器--
CREATE TRIGGER  orderForm_trigger
       BEFORE INSERT ON orderForm
       FOR EACH ROW 
       BEGIN
           SELECT orderForm_seq.nextval into :new.id FROM dual;
       END;

--用户表vip
create table vip
(
       username varchar2(255) primary key,
       userpass varchar2(255) not null,
       phone    varchar2(255),
       address  varchar2(255),
       realname varchar2(255) 
);

commit;

INSERT INTO vip(username,userpass,phone,address,realname) VALUES('lyons','123456','15853123329','北京','大哥')

select * from commodity
