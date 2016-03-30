-- orderForm订单表 --

create table orderForm 
(
     id number(10) primary key,
     username varchar2(255),
     mess varchar2(255),
     sum number(18,2) 
);

--生成序列

CREATE SEQUENCE orderForm_seq
       START WITH      1
       INCREMENT BY    1
       MINVALUE        1
       MAXVALUE     100000
       NOCYCLE
       CACHE           10
       
--触发器

CREATE TRIGGER  orderForm_trigger
       BEFORE INSERT ON orderForm
       FOR EACH ROW 
       BEGIN
           SELECT orderForm_seq.nextval into :new.id FROM dual;
       END
commit;
