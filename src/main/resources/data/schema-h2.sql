DROP TABLE IF EXISTS goods;
CREATE TABLE `goods`
(
    `goods_no`   int(11) NOT NULL DEFAULT '0' COMMENT '상품번호',
    `goods_nm`   varchar(100) DEFAULT NULL COMMENT '상품명',
    `goods_cont` text COMMENT '상품설명',
    `com_id`     varchar(20)  DEFAULT NULL COMMENT '업체 아이디',
    `reg_dm`     datetime     DEFAULT NULL COMMENT '상품정보 최초등록일시',
    `upd_dm`     datetime     DEFAULT NULL COMMENT '상품정보 수정일시',
    PRIMARY KEY (goods_no)
);
