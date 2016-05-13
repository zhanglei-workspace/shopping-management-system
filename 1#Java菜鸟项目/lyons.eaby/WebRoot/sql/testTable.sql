

-- insert into classify
insert into classify(gname) values('鞋子');
insert into classify(gname) values('衬衫');
insert into classify(gname) values('手机');
insert into classify(gname) values('电子产品');
commit;

drop trigger classify_tigger
-- insert into commodity

INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('沃特篮球鞋', '佛山', 180, 500, '001.jpg',1);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('安踏运动鞋', '福州', 120, 800, '002.jpg',1);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('耐克运动鞋', '广州', 500, 1000, '003.jpg',1);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('阿迪达斯T血衫', '上海', 388,600,'004.jpg',2);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('李宁文化衫', '广州', 180, 900, '005.jpg',2);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('小米3', '北京', 1999, 3000, '006.jpg',3);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('小米2S', '北京', 1299, 1000, '007.jpg',3);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('thinkpad笔记本', '北京', 6999, 500, '008.jpg',4);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('dell笔记本', '北京', 3900, 500, '009.jpg',4);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('ipad5', '北京', 5900, 500, '010.jpg',4);

--Drop all table 注意删除顺序--
drop trigger commodity_trigger;
commit;
drop sequence commodity_seq;
commit;
drop table commodity;
commit;

drop trigger classify_trigger;
commit;
drop sequence classify_seq;
commit;
drop table classify;
commit;

drop trigger orderForm_trigger;
commit;
drop sequence orderForm_seq;
commit;
drop table orderForm ;
commit;

 
