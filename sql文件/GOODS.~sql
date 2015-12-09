--根据数据库设计书，建立 GOODS 表。 

CREATE TABLE GOODS
(
       gid     NUMBER(10) primary key,
       gname   VARCHAR2(20) NOT NULL UNIQUE,
       gprice  NUMBER(18,1) NOT NULL,
       gnum    NUMBER(11) NOT NULL
);

--需求：gid主键自动生成。分以下两步实现！
 
--1.为GOODS表生成唯一 序列

CREATE SEQUENCE goods_seq  --序列名字随便取
       START WITH    1
       INCREMENT  BY 1
       MINVALUE      1
       MAXVALUE   100000 --最大数值可以随便设置
       NOCYCLE           --用完maxvalues后，不再循环！
       CACHE 10;         --每次提前缓存10数字提高效率，可以随便设置
       

--2.为表创建 触发器 ，用于自动从序列取值给GOODS表中gid自动赋值

CREATE TRIGGER goods_trigger
       BEFORE INSERT ON goods
       FOR EACH ROW        --行级触发器：插入的每一行数据都会触发
       BEGIN               --从序列中获取新的序号并赋给 新行 的gid 字段
           SELECT goods_seq.nextval INTO :new.gid FROM dual;
       END;


--truncate 能够清除数据，然而，不能抹掉序列的记忆。
