--根据数据库说明书建立 营业员表 //SID 自动生成

CREATE TABLE salesman
(
       sid        NUMBER(10) PRIMARY KEY,
       sname      VARCHAR2(10) NOT NULL UNIQUE,
       spassword  VARCHAR(20) NOT NULL
       
);

--生成序列

CREATE SEQUENCE salesman_seq
       START WITH     1
       INCREMENT BY   1
       MINVALUE       1
       MAXVALUE     100000
       NOCYCLE
       CACHE        10;
       
--触发器

CREATE TRIGGER salesman_trigger
       BEFORE INSERT ON salesman
       FOR EACH ROW
       BEGIN
           SELECT salesman_seq.nextval INTO :new.sid FROM dual;
       END;
       
--用户违反唯一约束多次创建信息时，会占用自动生成的序列号（我觉得这个可能存在安全隐患）
