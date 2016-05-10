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
create trigger commodity_tigger
       before insert on commodity
       for each row 
         begin
           select commodity_seq.nextval into :new.commodity_number from dual;
         end;
         
         
 
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('沃特篮球鞋', '佛山', 180, 500, '001.jpg',5);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('安踏运动鞋', '福州', 120, 800, '002.jpg',5);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('耐克运动鞋', '广州', 500, 1000, '003.jpg',5);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('阿迪达斯T血衫', '上海', 388,600,'004.jpg',6);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('李宁文化衫', '广州', 180, 900, '005.jpg',6);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('小米3', '北京', 1999, 3000, '006.jpg',7);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('小米2S', '北京', 1299, 1000, '007.jpg',7);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('thinkpad笔记本', '北京', 6999, 500, '008.jpg',8);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('dell笔记本', '北京', 3900, 500, '009.jpg',8);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('ipad5', '北京', 5900, 500, '010.jpg',8);

         