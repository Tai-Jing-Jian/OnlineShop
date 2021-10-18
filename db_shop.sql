DROP TABLE IF EXISTS t_BuyerOrder;
DROP TABLE IF EXISTS t_BuyerShoppingCart;
DROP TABLE IF EXISTS t_PromotionOrder;
DROP TABLE IF EXISTS t_Buyer;
DROP TABLE IF EXISTS t_PromotionGoods;
DROP TABLE IF EXISTS t_Goods;
DROP TABLE IF EXISTS t_Seller;
DROP TABLE IF EXISTS t_GoodsClass;

create table t_GoodsClass(
    `id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '商品类别的编号，自动加1',
    `name` VARCHAR(255) DEFAULT NULL COMMENT '商品类别的名称，可以重复，id唯一',
    `is_active` TINYINT(1) UNSIGNED NOT NULL COMMENT '商品类型的状态:是否有效（1=是；0=否）;若不有效，则该类商品都不可用',
    check(`is_active` IN (0, 1))
) comment='商品类别表';
insert into t_GoodsClass (name,is_active) values ('书',1);
insert into t_GoodsClass (name,is_active) values ('衣服',0);
insert into t_GoodsClass (name,is_active) values ('数码',1);

CREATE TABLE t_Seller (
    `id` BIGINT(9) UNSIGNED ZEROFILL PRIMARY KEY COMMENT '卖家编号，注册时用雪花算法获取并返回给卖家，9位',
    `name` VARCHAR(20) NOT NULL COMMENT '用户名，可以重复，id唯一',
    `password` VARCHAR(20)  NOT NULL COMMENT '密码',
    `phone` VARCHAR(11) DEFAULT NULL COMMENT '手机号',
    `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
    `is_active` TINYINT(1) UNSIGNED DEFAULT 0 COMMENT '是否有效(1=是；0=否)',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    check(`is_active` IN (0, 1))
) COMMENT='卖家用户信息表';
INSERT INTO t_Seller(id, name, password, phone, email, is_active, create_time) VALUES (123456789, 'alice', '123456', '15627280601', '1948831260@qq.com', 1, now());



CREATE TABLE t_Goods (
    `id` BIGINT(10) UNSIGNED ZEROFILL PRIMARY KEY AUTO_INCREMENT COMMENT '商品编号，添加时用雪花算法，10位',
    `name` VARCHAR(255) NOT NULL COMMENT '商品名',
    `class_id` INT UNSIGNED NOT NULL COMMENT '商品类别的id',
    `seller_id` BIGINT(9) UNSIGNED ZEROFILL NOT NULL COMMENT '商品卖家的id',
    `price` INT UNSIGNED NOT NULL COMMENT '商品价格',
    `stock` INT UNSIGNED DEFAULT 0 COMMENT '库存',
    `is_active` TINYINT(1) UNSIGNED DEFAULT 0 COMMENT '商品的状态:是否有效（1=是；0=否），若不有效，则该商品不可用',
    `purchase_time` datetime DEFAULT NULL COMMENT '最新采购时间',
    `create_time` datetime DEFAULT NULL COMMENT '创造该记录的时间',
    foreign key(`class_id`) references t_GoodsClass(`id`),
    foreign key(`seller_id`) references t_Seller(`id`),
    check(`is_active` IN (0, 1))
) COMMENT='商品表';
INSERT INTO t_Goods(id, name, class_id, seller_id, price, stock, is_active, purchase_time, create_time) VALUES (1234567891, 'Java编程思想', 1, 123456789, 100, 100, 1, now() , now());
INSERT INTO t_Goods(id, name, class_id, seller_id, price, stock, is_active, purchase_time, create_time) VALUES (1234567892, 'Spring实战第四版', 1, 123456789, 200, 200, 1, now() , now());
INSERT INTO t_Goods(id, name, class_id, seller_id, price, stock, is_active, purchase_time, create_time) VALUES (1234567893, '深入分析JavaWeb', 1, 123456789, 300, 300, 1, now() , now());
INSERT INTO t_Goods(id, name, class_id, seller_id, price, stock, is_active, purchase_time, create_time) VALUES (1234567894, '深入分析Java', 1, 123456789, 300, 300, 1, now() , now());
INSERT INTO t_Goods(id, name, class_id, seller_id, price, stock, is_active, purchase_time, create_time) VALUES (1234567895, '深入分析Web', 1, 123456789, 300, 300, 1, now() , now());




CREATE TABLE t_PromotionGoods (
    `id` int UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '主键id，自动加1',
    `goods_id` BIGINT(10) UNSIGNED ZEROFILL NOT NULL COMMENT '商品id',
    `total` int UNSIGNED NOT NULL COMMENT '可被抢购的总数',
    `price` int UNSIGNED NOT NULL COMMENT '商品价格',
    `start_time` datetime NOT NULL COMMENT '抢购开始时间',
    `end_time` datetime NOT NULL COMMENT '抢购结束时间',
    `is_active` TINYINT(1) UNSIGNED DEFAULT 0 COMMENT '是否有效（1=是；0=否）',
    `create_time` datetime DEFAULT NULL COMMENT '创建的时间',
    foreign key(`goods_id`) references t_Goods(`id`),
    check(`is_active` IN (0, 1)),
    check(`start_time` < `end_time`)
) COMMENT='待抢购商品表';
INSERT INTO t_PromotionGoods(goods_id, total, price, start_time, end_time, is_active, create_time) VALUES (1234567891, 10, 1, '2019-06-08 21:59:07', '2022-06-15 21:59:11', 1, now());
INSERT INTO t_PromotionGoods(goods_id, total, price, start_time, end_time, is_active, create_time) VALUES (1234567892, 20, 2, '2019-06-01 21:59:19', '2022-06-30 21:59:11', 1, now());
INSERT INTO t_PromotionGoods(goods_id, total, price, start_time, end_time, is_active, create_time) VALUES (1234567893, 30, 3, '2019-07-01 18:58:26', '2022-07-30 21:59:07', 1, now());
INSERT INTO t_PromotionGoods(goods_id, total, price, start_time, end_time, is_active, create_time) VALUES (1234567894, 30, 4, '2019-07-01 18:58:26', '2022-07-30 21:59:07', 1, now());



CREATE TABLE t_Buyer (
    `id` BIGINT(11) UNSIGNED ZEROFILL PRIMARY KEY COMMENT '买家编号，注册时用雪花算法，11位',
    `name` varchar(20) NOT NULL COMMENT '用户名',
    `password` varchar(20)  NOT NULL COMMENT '密码',
    `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
    `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
    `create_time` datetime DEFAULT NULL COMMENT '注册时间',
    `is_active` TINYINT(1) UNSIGNED DEFAULT 0 COMMENT '是否有效(1=是；0=否)',
    check (`is_active` IN (0, 1))
) COMMENT='买家用户信息表';
INSERT INTO t_Buyer(id, name, password, phone, email, create_time, is_active) VALUES (12345678900,'tom', '123', '15627280601', '1948831260@qq.com', now(), 1);
INSERT INTO t_Buyer(id, name, password, phone, email, create_time, is_active) VALUES (12345678901,'tom', '123', '15627280601', '1948831260@qq.com', now(), 1);
INSERT INTO t_Buyer(id, name, password, phone, email, create_time, is_active) VALUES (12345678902,'tom', '123', '15627280601', '1948831260@qq.com', now(), 1);
INSERT INTO t_Buyer(id, name, password, phone, email, create_time, is_active) VALUES (12345678903,'tom', '123', '15627280601', '1948831260@qq.com', now(), 1);



CREATE TABLE t_PromotionOrder (
    `code` BIGINT(19) UNSIGNED ZEROFILL PRIMARY KEY COMMENT '抢购成功生成的订单编号',
    `buyer_id` BIGINT(11) UNSIGNED ZEROFILL NOT NULL COMMENT '抢购者id',
    `promotion_id` int UNSIGNED NOT NULL COMMENT '促销活动的id',
    `goods_id` BIGINT(10) UNSIGNED ZEROFILL NOT NULL COMMENT '商品id',
    `status` TINYINT(1) UNSIGNED DEFAULT 0 COMMENT '抢购状态结果: 0无效 1成功(未付款) 2已付款 3已发货 4已签收 5已取消',
    `create_time` datetime DEFAULT NULL COMMENT '抢购成功时的时间',
    foreign key(`buyer_id`) references t_Buyer(`id`),
    foreign key(`promotion_id`) references t_PromotionGoods(`id`),
    foreign key(`goods_id`) references t_PromotionGoods(`goods_id`),
    check(status IN (0, 1, 2, 3, 4, 5))
) COMMENT='抢购成功的订单记录表';
INSERT INTO t_PromotionOrder(code, buyer_id, promotion_id, goods_id, status, create_time) VALUES (0123456789123456789, 12345678900, 1, 1234567891, 1, now());


CREATE TABLE t_BuyerShoppingCart (
    `buyer_id` BIGINT(11) UNSIGNED ZEROFILL NOT NULL COMMENT '抢购者id',
    `goods_id` BIGINT(10) UNSIGNED ZEROFILL NOT NULL COMMENT '商品id',
    `number` INT UNSIGNED NOT NULL COMMENT '购买数量',
    `create_time` datetime NOT NULL COMMENT '添加进入购物车的时间',
    PRIMARY KEY(`buyer_id`, `goods_id`, `number`, `create_time`),
    foreign key(`buyer_id`) references t_Buyer(`id`),
    foreign key(`goods_id`) references t_Goods(`id`)
) COMMENT='买家购物车信息表';
INSERT INTO t_BuyerShoppingCart(buyer_id, goods_id, number, create_time) VALUES (12345678900, 1234567891, 1, now());
INSERT INTO t_BuyerShoppingCart(buyer_id, goods_id, number, create_time) VALUES (12345678900, 1234567892, 2, now());
INSERT INTO t_BuyerShoppingCart(buyer_id, goods_id, number, create_time) VALUES (12345678900, 1234567893, 3, now());

CREATE TABLE t_BuyerOrder (
    `code` BIGINT(19) UNSIGNED ZEROFILL PRIMARY KEY COMMENT '订单编号',
    `buyer_id` BIGINT(11) UNSIGNED ZEROFILL NOT NULL COMMENT '买家id',
    `goods_id` BIGINT(10) UNSIGNED ZEROFILL NOT NULL COMMENT '商品id',
    `number` INT UNSIGNED NOT NULL COMMENT '商品数量',
    `create_time` datetime DEFAULT NULL COMMENT '订单创造时间',
    `status` TINYINT(1) UNSIGNED DEFAULT 0 COMMENT '抢购状态结果: 0无效 1成功(未付款) 2已付款 3已发货 4已签收 5已取消',
    foreign key(`buyer_id`) references t_Buyer(`id`),
    foreign key(`goods_id`) references t_Goods(`id`),
    check(`status` IN (0, 1, 2, 3, 4, 5))
) COMMENT='买家订单记录表（非抢购商品的订单）';
INSERT INTO t_BuyerOrder(code, buyer_id, goods_id, number, create_time, status) VALUES (123456789, 12345678900, 1234567891, 1, now(), 0);
INSERT INTO t_BuyerOrder(code, buyer_id, goods_id, number, create_time, status) VALUES (123456788, 12345678900, 1234567892, 1, now(), 1);
INSERT INTO t_BuyerOrder(code, buyer_id, goods_id, number, create_time, status) VALUES (123456787, 12345678900, 1234567893, 1, now(), 2);
INSERT INTO t_BuyerOrder(code, buyer_id, goods_id, number, create_time, status) VALUES (123456786, 12345678900, 1234567891, 1, now(), 3);


