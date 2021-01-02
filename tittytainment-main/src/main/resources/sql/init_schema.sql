-- CREATE SCHEMA `tittytainment` ;

#
# -- ----------------------------
# -- Table structure for user
# -- ----------------------------
# DROP TABLE IF EXISTS `ttmt_user`;
# CREATE TABLE `ttmt_user`
# (
#     `id`           int(20) unsigned NOT NULL AUTO_INCREMENT,
#     `phone`        varchar(100)     NOT NULL COMMENT '手机号',
#     `password`     varchar(100)     NOT NULL COMMENT '加密后的密码',
#     `name`         varchar(100)              DEFAULT '' COMMENT '用户名',
#     `cover_url`    varchar(200)              DEFAULT '' COMMENT '头像图片地址',
#     `status`       tinyint(1)       NOT NULL DEFAULT 1 COMMENT '1有效账号 0无效账号',
#     `created_time` timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
#     `updated_time` timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
#     PRIMARY KEY (`id`)
# ) ENGINE = InnoDB
#   DEFAULT CHARSET = utf8mb4 COMMENT ='用户表';
#
#
# -- ----------------------------
# -- Table structure for role
# -- ----------------------------
# DROP TABLE IF EXISTS `ttmt_role`;
# CREATE TABLE `ttmt_role`
# (
#     `id`           int(20) unsigned NOT NULL AUTO_INCREMENT,
#     `name`         varchar(100)              DEFAULT '' COMMENT '角色名',
#     `description`  varchar(255)              DEFAULT '' COMMENT '描述',
#     `created_time` timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
#     `updated_time` timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
#     PRIMARY KEY (`id`)
# ) ENGINE = InnoDB
#   DEFAULT CHARSET = utf8mb4 COMMENT ='角色表';
#
# -- ----------------------------
# -- Records of my_role
# -- ----------------------------
# INSERT INTO `ttmt_role` (id, name, description)
# VALUES (1, 'ADMIN', '超级管理员，拥有所有权限');
# INSERT INTO `ttmt_role` (id, name, description)
# VALUES (2, 'USER', '普通用户');
#
#
# -- ----------------------------
# -- Table structure for role and user
# -- ----------------------------
# DROP TABLE IF EXISTS `ttmt_user_role`;
# CREATE TABLE `ttmt_user_role`
# (
#     `user_id` int(11) NOT NULL,
#     `role_id` int(11) NOT NULL,
#     PRIMARY KEY (`user_id`, `role_id`)
# ) ENGINE = InnoDB
#   DEFAULT CHARSET = utf8mb4 COMMENT ='用户-角色关系表';


-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `ttmt_movie`;
CREATE TABLE `ttmt_movie`
(
    `id`           bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `douban_id`    bigint(20) unsigned NOT NULL default 0 COMMENT '豆瓣id',
    `name`         varchar(100)        NOT NULL DEFAULT '' COMMENT '电影名称',
    `alias`        varchar(100)                 DEFAULT '' COMMENT '电影别名',
    `cover_url`    varchar(200)                 DEFAULT '' COMMENT '电影封面地址',
    `douban_score` double unsigned              DEFAULT 0 COMMENT '豆瓣评分',
    `douban_vote`  int(10) unsigned             DEFAULT 0 COMMENT '豆瓣打分人数',
    `mins`         int(5) unsigned              DEFAULT 0 COMMENT '电影时长(min)',
    `release_date` datetime                     DEFAULT CURRENT_TIMESTAMP COMMENT '电影上映时间',
    `year`         int(5) unsigned              DEFAULT 0 COMMENT '电影所属年份(比上映时间更全)',
    `storyline`    text(1000) COMMENT '电影情节',
    `tags`         text(1000) COMMENT '标签',
    `created_time` timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time` timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='电影表';

############################ movie - category ###########################

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `ttmt_category`;
CREATE TABLE `ttmt_category`
(
    `id`            bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `category_name` varchar(100)        NOT NULL DEFAULT '' COMMENT '分类名称',
    `created_time`  timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time`  timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='分类表';

-- ----------------------------
-- Table structure for movie-category
-- ----------------------------
DROP TABLE IF EXISTS `ttmt_movie_category`;
CREATE TABLE `ttmt_movie_category`
(
    `id`              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `movie_id`        bigint(20) unsigned NOT NULL default 0 COMMENT '电影id',
    `movie_douban_id` bigint(20) unsigned NOT NULL default 0 COMMENT '电影豆瓣id',
    `category_id`     bigint(20) unsigned NOT NULL default 0 COMMENT '分类id',
    `created_time`    timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time`    timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='电影-分类表';


############################ movie - language ###########################

-- ----------------------------
-- Table structure for language
-- ----------------------------
DROP TABLE IF EXISTS `ttmt_language`;
CREATE TABLE `ttmt_language`
(
    `id`            bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `language_name` varchar(100)        NOT NULL DEFAULT '' COMMENT '语言名称',
    `created_time`  timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time`  timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='语言表';

-- ----------------------------
-- Table structure for movie-language
-- ----------------------------
DROP TABLE IF EXISTS `ttmt_movie_language`;
CREATE TABLE `ttmt_movie_language`
(
    `id`              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `movie_id`        bigint(20) unsigned NOT NULL default 0 COMMENT '电影id',
    `movie_douban_id` bigint(20) unsigned NOT NULL default 0 COMMENT '电影豆瓣id',
    `language_id`     bigint(20) unsigned NOT NULL default 0 COMMENT '语言id',
    `created_time`    timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time`    timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='电影-分类表';

############################ movie - region ###########################

-- ----------------------------
-- Table structure for region
-- ----------------------------
DROP TABLE IF EXISTS `ttmt_region`;
CREATE TABLE `ttmt_region`
(
    `id`           bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `region_name`  varchar(100)        NOT NULL DEFAULT '' COMMENT '地区名称',
    `created_time` timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time` timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='地区表';

-- ----------------------------
-- Table structure for movie-region
-- ----------------------------
DROP TABLE IF EXISTS `ttmt_movie_region`;
CREATE TABLE `ttmt_movie_region`
(
    `id`              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `movie_id`        bigint(20) unsigned NOT NULL default 0 COMMENT '电影id',
    `movie_douban_id` bigint(20) unsigned NOT NULL default 0 COMMENT '电影豆瓣id',
    `region_id`       bigint(20) unsigned NOT NULL default 0 COMMENT '地区id',
    `created_time`    timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time`    timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='电影-地区表';


#
# -- ----------------------------
# -- Table structure for filmmaker
# -- ----------------------------
# DROP TABLE IF EXISTS `ttmt_filmmaker`;
# CREATE TABLE `ttmt_filmmaker`
# (
#     `id`            bigint(20) unsigned NOT NULL AUTO_INCREMENT,
#     `douban_id`     bigint(20) unsigned NOT NULL default 0 COMMENT '豆瓣演员id',
#     `name`          varchar(100)        NOT NULL DEFAULT '' COMMENT '演员名称',
#     `name_en`       varchar(1000)                 DEFAULT '' COMMENT '英文全名',
#     `name_zh`       varchar(1000)                 DEFAULT '' COMMENT '中文全名',
#     `sex`           varchar(10)         NOT NULL DEFAULT '' COMMENT '性别',
#     `birth`         datetime                     DEFAULT CURRENT_TIMESTAMP COMMENT '出生日期',
#     `birth_place`   varchar(100)                 DEFAULT '' COMMENT '出生地点',
#     `constellation` varchar(10)                  DEFAULT '' COMMENT '星座',
#     `biography`     text(1000) COMMENT '人物简介',
#     `created_time`  timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
#     `updated_time`  timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
#     PRIMARY KEY (`id`)
# ) ENGINE = InnoDB
#   DEFAULT CHARSET = utf8mb4 COMMENT ='电影演员与导演';
#
# -- ----------------------------
# -- Table structure for profession
# -- ----------------------------
# DROP TABLE IF EXISTS `ttmt_profession`;
# CREATE TABLE `ttmt_profession`
# (
#     `id`           bigint(20) unsigned NOT NULL AUTO_INCREMENT,
#     `name`         varchar(100)        NOT NULL DEFAULT '' COMMENT '职业名称',
#     `created_time` timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
#     `updated_time` timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
#     PRIMARY KEY (`id`)
# ) ENGINE = InnoDB
#   DEFAULT CHARSET = utf8mb4 COMMENT ='职业表';
#
# -- ----------------------------
# -- Table structure for profession-movie
# -- ----------------------------
# DROP TABLE IF EXISTS `ttmt_filmmaker_profession`;
# CREATE TABLE `ttmt_filmmaker_profession`
# (
#     `id`                  bigint(20) unsigned NOT NULL AUTO_INCREMENT,
#     `filmmaker_id`        bigint(20) unsigned NOT NULL default 0 COMMENT '演员id',
#     `filmmaker_douban_id` bigint(20) unsigned NOT NULL default 0 COMMENT '演员豆瓣id',
#     `profession_id`       bigint(20) unsigned NOT NULL default 0 COMMENT '职业id',
#     `created_time`        timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
#     `updated_time`        timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
#     PRIMARY KEY (`id`)
# ) ENGINE = InnoDB
#   DEFAULT CHARSET = utf8mb4 COMMENT ='职业-演员表';

-- ----------------------------
-- Table structure for filmmaker-movie
-- ----------------------------
DROP TABLE IF EXISTS `ttmt_movie_filmmaker`;
CREATE TABLE `ttmt_movie_filmmaker`
(
    `id`                  bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `movie_id`            bigint(20) unsigned NOT NULL default 0 COMMENT '电影id',
    `movie_douban_id`     bigint(20) unsigned NOT NULL default 0 COMMENT '电影豆瓣id',
    `filmmaker_id`        bigint(20) unsigned NOT NULL default 0 COMMENT '演员id',
    `filmmaker_douban_id` bigint(20) unsigned NOT NULL default 0 COMMENT '演员豆瓣id',
    `profession_id`       bigint(20) unsigned NOT NULL default 0 COMMENT '职业id',
    `created_time`        timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time`        timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='电影-演员关系表';






# -- ----------------------------
# -- Table structure for filmmaker-movie
# -- ----------------------------
# DROP TABLE IF EXISTS `ttmt_movie_filmmaker`;
# CREATE TABLE `ttmt_movie_filmmaker`
# (
#     `id`                  bigint(20) unsigned NOT NULL AUTO_INCREMENT,
#     `movie_id`            bigint(20) unsigned NOT NULL default 0 COMMENT '电影id',
#     `movie_douban_id`     bigint(20) unsigned NOT NULL default 0 COMMENT '电影豆瓣id',
#     `filmmaker_id`        bigint(20) unsigned NOT NULL default 0 COMMENT '演员id',
#     `filmmaker_douban_id` bigint(20) unsigned NOT NULL default 0 COMMENT '演员豆瓣id',
#     `profession_id`       bigint(20) unsigned NOT NULL default 0 COMMENT '职业id',
#     `created_time`        timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
#     `updated_time`        timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
#     PRIMARY KEY (`id`)
# ) ENGINE = InnoDB
#   DEFAULT CHARSET = utf8mb4 COMMENT ='电影-演员关系表';







