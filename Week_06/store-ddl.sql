-- 用户表
CREATE TABLE IF NOT EXISTS users (
  id                                 bigint(20) NOT NULL AUTO_INCREMENT,
  name                                 varchar(128) NOT NULL comment '用户名' ,
  password                         varchar(256) NOT NULL comment '密码',
  phone_no                         varchar(15) NOT NULL comment '电话号码',
  cert_no                         varchar(16) NOT NULL default '' comment '身份证号码',
  balance                         decimal(17,2) NOT NULL default '0.00' comment '余额',
  address                         varchar(256)  NOT NULL  default '' comment '地址',
  created_by          varchar(20)              DEFAULT ''                    COMMENT '创建人',
  created_date        timestamp(3)  NOT NULL   DEFAULT CURRENT_TIMESTAMP(3)  COMMENT '创建日期时间',
  last_modified_by    varchar(20)              DEFAULT ''                    COMMENT '最后修改人',
  last_modified_date  timestamp(3)  NOT NULL   DEFAULT CURRENT_TIMESTAMP(3)  COMMENT '最后更新日期时间',
  PRIMARY KEY (id),
  key idx_name(name),
  key idx_phone(phone_no)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- 店铺表
CREATE TABLE IF NOT EXISTS stores (
    id                                     bigint(20) NOT NULL AUTO_INCREMENT comment '店铺id',
    name                                 varchar(128) NOT NULL comment '店铺名称' ,
    description         varchar(1024) NOT NULL default '' comment '店铺描述',
        created_by          varchar(20)              DEFAULT ''                    COMMENT '创建人',
    created_date        timestamp(3)  NOT NULL   DEFAULT CURRENT_TIMESTAMP(3)  COMMENT '创建日期时间',
    last_modified_by    varchar(20)              DEFAULT ''                    COMMENT '最后修改人',
    last_modified_date  timestamp(3)  NOT NULL   DEFAULT CURRENT_TIMESTAMP(3)  COMMENT '最后更新日期时间',
    PRIMARY KEY (id),
    key idx_name(name)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 商品表
CREATE TABLE IF NOT EXISTS goods (
    id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品id',
    name varchar(16) NOT NULL COMMENT '名称',
    description varchar(1024) NOT NULL COMMENT '描述',
    price decimal(17,2) NOT NULL COMMENT '价格',
    weight decimal(17,2) NOT NULL COMMENT '重量',
    stocks int(11) not null default 0 COMMENT '数量',
    store_id bigint(20) NOT NULL COMMENT '所属店铺id',
    status int(1) NOT NULL default 0 COMMENT '商品状态0入库,1已锁定,2出库中,3已完成',
    created_by          varchar(20)              DEFAULT ''                    COMMENT '创建人',
    created_date        timestamp(3)  NOT NULL   DEFAULT CURRENT_TIMESTAMP(3)  COMMENT '创建日期时间',
    last_modified_by    varchar(20)              DEFAULT ''                    COMMENT '最后修改人',
    last_modified_date  timestamp(3)  NOT NULL   DEFAULT CURRENT_TIMESTAMP(3)  COMMENT '最后更新日期时间',
    PRIMARY KEY (id),
    index idx_name(name)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


--订单表:
CREATE TABLE IF NOT EXISTS orders (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    req_date DATE NOT NULL COMMENT '订单日期',
    user_id bigint(20) NOT NULL COMMENT '用户id',
    goods_id bigint(20) NOT NULL COMMENT '商品id',
    goods_count int(1) NOT NULL default 0,
    price decimal(17,2) NOT NULL COMMENT '价格',
    discount decimal(17,2) NOT NULL COMMENT '折扣',
    total_price decimal(17,2) NOT NULL COMMENT '总价',
    status int(2) NOT NULL COMMENT '订单状态0未支付,1已支付，待出库,2已出库,3已签收，4退款中，5已退款',
    created_by          varchar(20)              DEFAULT ''                    COMMENT '创建人',
    created_date        timestamp(3)  NOT NULL   DEFAULT CURRENT_TIMESTAMP(3)  COMMENT '创建日期时间',
    last_modified_by    varchar(20)              DEFAULT ''                    COMMENT '最后修改人',
    last_modified_date  timestamp(3)  NOT NULL   DEFAULT CURRENT_TIMESTAMP(3)  COMMENT '最后更新日期时间',
    PRIMARY KEY (id,req_date)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8  PARTITION BY RANGE COLUMNS (req_date)(
        PARTITION P202011 VALUES LESS THAN ('20201130'));