-- CREATE SCHEMA `tittytainment` ;


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `ttmt_user`;
CREATE TABLE `ttmt_user`
(
    `id`           int(20) unsigned NOT NULL AUTO_INCREMENT,
    `phone`        varchar(100)     NOT NULL COMMENT '手机号',
    `password`     varchar(100)     NOT NULL COMMENT '加密后的密码',
    `name`         varchar(100)              DEFAULT '' COMMENT '用户名',
    `cover_url`    varchar(200)              DEFAULT '' COMMENT '头像图片地址',
    `status`       int(10)          NOT NULL DEFAULT 1 COMMENT '1有效账号 0无效账号',
    `created_time` timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time` timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='用户表';


-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `ttmt_role`;
CREATE TABLE `ttmt_role`
(
    `id`           int(20) unsigned NOT NULL AUTO_INCREMENT,
    `name`         varchar(100)              DEFAULT '' COMMENT '角色名',
    `description`  varchar(255)              DEFAULT '' COMMENT '描述',
    `created_time` timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time` timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='角色表';

-- ----------------------------
-- Records of my_role
-- ----------------------------
INSERT INTO `ttmt_role` (id, name, description)
VALUES (1, 'ADMIN', '超级管理员，拥有所有权限');
INSERT INTO `ttmt_role` (id, name, description)
VALUES (2, 'USER', '普通用户');


-- ----------------------------
-- Table structure for role and user
-- ----------------------------
DROP TABLE IF EXISTS `ttmt_user_role`;
CREATE TABLE `ttmt_user_role`
(
    `user_id` int(11) NOT NULL,
    `role_id` int(11) NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='用户-角色关系表';



-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `ttmt_movie`;
CREATE TABLE `ttmt_movie`
(
    `id`           int(20) unsigned NOT NULL AUTO_INCREMENT,
    `movie_name`   varchar(100)     NOT NULL DEFAULT '' COMMENT '电影名称',
    `movie_alias`  varchar(100)              DEFAULT '' COMMENT '电影别名',
    `cover_url`    varchar(200)              DEFAULT '' COMMENT '电影封面地址',
    `douban_score` double unsigned           DEFAULT 0 COMMENT '豆瓣评分',
    `movie_mins`   int(5) unsigned           DEFAULT 0 COMMENT '电影时长(min)',
    `languages`    varchar(100)              DEFAULT '' COMMENT '语言',
    `regions`      varchar(100)              DEFAULT '' COMMENT '地区',
    `release_time` timestamp COMMENT '电影上映时间',
    `storyline`    text(1000) COMMENT '电影情节',
    `created_time` timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time` timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='电影表';

