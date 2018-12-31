/*
 Navicat Premium Data Transfer

 Source Server         : issue-青岛信发系统开发版-本机
 Source Server Type    : MariaDB
 Source Server Version : 100126
 Source Host           : localhost:3306
 Source Schema         : qd_issue

 Target Server Type    : MariaDB
 Target Server Version : 100126
 File Encoding         : 65001

 Date: 31/12/2018 15:44:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ad
-- ----------------------------
DROP TABLE IF EXISTS `ad`;
CREATE TABLE `ad`  (
  `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `title1` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content1` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title2` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title3` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content2` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `video1` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `video2` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ad
-- ----------------------------
INSERT INTO `ad` VALUES (5, '测试广告', '可编辑', '可编辑<br>可编辑drftvgybhnj', '可编辑', '可编辑', '\n                可编辑可编辑<br>\n                可编辑<br>\n                可编辑\n                ', 'G:/workspace_new/di-issue/uploads/1543500085032_17545.mp4', 'G:/workspace_new/di-issue/uploads/1543500093159_17323.mp4');
INSERT INTO `ad` VALUES (8, '顶顶顶顶', '可编辑是的第三方', '可编辑<br>可编辑', '可编辑', '可编辑', '可编辑可编辑<br>可编辑<br>可编辑<br>绘画', 'G:/workspace_new/di-issue/uploads/1544519091416_13792.jpg', 'G:/workspace_new/di-issue/uploads/1544519105972_16481.jpg');
INSERT INTO `ad` VALUES (9, '测试内容', '可编辑', '\n                可编辑<br>\n                可编辑\n                ', '可编辑', '可编辑', '\n                可编辑可编辑<br>\n                可编辑<br>\n                可编辑\n                ', '', '');
INSERT INTO `ad` VALUES (10, ' 好人同意', '可编辑', '\n                可编辑<br>\n                可编辑\n                ', '可编辑', '可编辑', '\n                可编辑可编辑<br>\n                可编辑<br>\n                可编辑\n                ', '', '');
INSERT INTO `ad` VALUES (11, '让他突然有人同意', '可编辑', '\n                可编辑<br>\n                可编辑\n                ', '可编辑', '可编辑', '\n                可编辑可编辑<br>\n                可编辑<br>\n                可编辑\n                ', '', '');
INSERT INTO `ad` VALUES (12, '梵蒂冈梵蒂冈', '可编辑', '\n                可编辑<br>\n                可编辑\n                ', '可编辑', '可编辑', '\n                可编辑可编辑<br>\n                可编辑<br>\n                可编辑\n                ', '', '');
INSERT INTO `ad` VALUES (13, 'we大润发个体户', '可编辑', '\n                可编辑<br>\n                可编辑\n                ', '可编辑', '可编辑', '\n                可编辑可编辑<br>\n                可编辑<br>\n                可编辑\n                ', '', '');
INSERT INTO `ad` VALUES (14, '功放', '可编辑', '\n                可编辑<br>\n                可编辑\n                ', '可编辑', '可编辑', '\n                可编辑可编辑<br>\n                可编辑<br>\n                可编辑\n                ', '', '');
INSERT INTO `ad` VALUES (15, '演示用例a', '演示用例2', '会议流程：<br>日程安排：', '演示用例2', '今日要点1', '今日的风特别大', 'G:/workspace_new/di-issue/uploads/1544008309225_14660.mp4', 'G:/workspace_new/di-issue/uploads/1544007252022_11998.jpg');

-- ----------------------------
-- Table structure for advert
-- ----------------------------
DROP TABLE IF EXISTS `advert`;
CREATE TABLE `advert`  (
  `id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `position` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `building` tinyint(2) UNSIGNED NOT NULL,
  `floor` tinyint(2) UNSIGNED NULL DEFAULT NULL,
  `width` smallint(4) UNSIGNED NOT NULL,
  `height` smallint(4) UNSIGNED NOT NULL,
  `ip` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `devType` tinyint(2) UNSIGNED NOT NULL,
  `devName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mac` varchar(17) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `open` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '1广告，2直播，3危险，9已部署单未开启',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `ip`(`ip`) USING BTREE,
  UNIQUE INDEX `mac`(`mac`) USING BTREE,
  INDEX `advert_building`(`building`) USING BTREE,
  INDEX `advert_floor`(`floor`) USING BTREE,
  CONSTRAINT `advert_building` FOREIGN KEY (`building`) REFERENCES `building` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `advert_floor` FOREIGN KEY (`floor`) REFERENCES `floor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 72 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of advert
-- ----------------------------
INSERT INTO `advert` VALUES (67, '测试用的', '西部电梯', 2, 3, 1920, 1080, '127.0.0.1', 1, '广告机电脑', '备注信息备注信息备注信息', '12-F0-05-1d-FA-77', 2);
INSERT INTO `advert` VALUES (68, '广告位名称', '位置位置sssss', 2, 4, 1920, 1080, '192.168.20.175', 1, '广告机电脑', '', '12-F0-65-1d-FA-77', NULL);
INSERT INTO `advert` VALUES (71, '产品宣传', '东侧客梯', 2, 6, 1920, 1080, '192.168.20.161', 1, '广告机电脑', '', '12-40-30-20-13-16', NULL);

-- ----------------------------
-- Table structure for advert_relation
-- ----------------------------
DROP TABLE IF EXISTS `advert_relation`;
CREATE TABLE `advert_relation`  (
  `advert` tinyint(3) UNSIGNED NULL DEFAULT NULL,
  `ad` smallint(5) UNSIGNED NULL DEFAULT NULL,
  `danger` smallint(5) UNSIGNED NULL DEFAULT NULL,
  INDEX `ad`(`ad`) USING BTREE,
  INDEX `advert`(`advert`) USING BTREE,
  INDEX `danger`(`danger`) USING BTREE,
  CONSTRAINT `ad` FOREIGN KEY (`ad`) REFERENCES `ad` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `advert` FOREIGN KEY (`advert`) REFERENCES `advert` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `danger` FOREIGN KEY (`danger`) REFERENCES `danger` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of advert_relation
-- ----------------------------
INSERT INTO `advert_relation` VALUES (71, 15, 2);
INSERT INTO `advert_relation` VALUES (67, 5, 9);

-- ----------------------------
-- Table structure for building
-- ----------------------------
DROP TABLE IF EXISTS `building`;
CREATE TABLE `building`  (
  `id` tinyint(2) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sort` tinyint(2) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of building
-- ----------------------------
INSERT INTO `building` VALUES (2, '#1', 1);
INSERT INTO `building` VALUES (3, '#2', 2);

-- ----------------------------
-- Table structure for danger
-- ----------------------------
DROP TABLE IF EXISTS `danger`;
CREATE TABLE `danger`  (
  `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `video` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of danger
-- ----------------------------
INSERT INTO `danger` VALUES (1, '2222222', 'G:/workspace_new/di-issue/uploads/1544519150372_12430.jpg');
INSERT INTO `danger` VALUES (2, '是对方答复呃呃', 'G:/workspace_new/di-issue/uploads/1544086435823_13887.mp4');
INSERT INTO `danger` VALUES (3, '是对方水电费', '');
INSERT INTO `danger` VALUES (6, '我发个风格', '');
INSERT INTO `danger` VALUES (7, '发个梵蒂冈', '');
INSERT INTO `danger` VALUES (8, '二手的吃软饭TV', '');
INSERT INTO `danger` VALUES (9, '危险', 'G:/workspace_new/di-issue/uploads/1544414474951_10206.jpg');

-- ----------------------------
-- Table structure for floor
-- ----------------------------
DROP TABLE IF EXISTS `floor`;
CREATE TABLE `floor`  (
  `id` tinyint(2) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `building` tinyint(2) UNSIGNED NOT NULL,
  `sort` tinyint(2) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `building`(`building`) USING BTREE,
  CONSTRAINT `building` FOREIGN KEY (`building`) REFERENCES `building` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of floor
-- ----------------------------
INSERT INTO `floor` VALUES (3, 'B1', 2, 1);
INSERT INTO `floor` VALUES (4, '1F', 2, 2);
INSERT INTO `floor` VALUES (6, '2F', 2, 3);
INSERT INTO `floor` VALUES (7, '3F', 2, 4);
INSERT INTO `floor` VALUES (8, '4F', 2, 5);
INSERT INTO `floor` VALUES (9, 'B1', 3, 1);
INSERT INTO `floor` VALUES (10, '1F', 3, 2);
INSERT INTO `floor` VALUES (11, '2F', 3, 3);
INSERT INTO `floor` VALUES (12, '3F', 3, 4);
INSERT INTO `floor` VALUES (13, '4F', 3, 5);
INSERT INTO `floor` VALUES (14, '5F', 3, 6);
INSERT INTO `floor` VALUES (15, '6F', 3, 7);
INSERT INTO `floor` VALUES (16, '7F', 3, 8);
INSERT INTO `floor` VALUES (17, '8F', 3, 9);
INSERT INTO `floor` VALUES (18, '9F', 3, 10);
INSERT INTO `floor` VALUES (19, '10F', 3, 11);
INSERT INTO `floor` VALUES (20, '11F', 3, 12);
INSERT INTO `floor` VALUES (21, '12F', 3, 13);
INSERT INTO `floor` VALUES (22, '13F', 3, 14);
INSERT INTO `floor` VALUES (23, '14F', 3, 15);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` tinyint(2) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pid` tinyint(2) UNSIGNED NULL DEFAULT NULL,
  `method` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `pid`(`pid`) USING BTREE,
  CONSTRAINT `pid` FOREIGN KEY (`pid`) REFERENCES `permission` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '根目录', '根目录的权限', '/', NULL, '');
INSERT INTO `permission` VALUES (2, '管理员目录', '管理员目录的权限', '/admin', NULL, '');
INSERT INTO `permission` VALUES (3, '获取楼层', '获取全部楼层数据', '/floor/all', NULL, '');

-- ----------------------------
-- Table structure for permission_role
-- ----------------------------
DROP TABLE IF EXISTS `permission_role`;
CREATE TABLE `permission_role`  (
  `role` tinyint(2) UNSIGNED NULL DEFAULT NULL,
  `permission` tinyint(2) UNSIGNED NULL DEFAULT NULL,
  INDEX `permission_role_role`(`role`) USING BTREE,
  INDEX `permission_role_permission`(`permission`) USING BTREE,
  CONSTRAINT `permission_role_permission` FOREIGN KEY (`permission`) REFERENCES `permission` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `permission_role_role` FOREIGN KEY (`role`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of permission_role
-- ----------------------------
INSERT INTO `permission_role` VALUES (1, 1);
INSERT INTO `permission_role` VALUES (1, 2);
INSERT INTO `permission_role` VALUES (2, 1);
INSERT INTO `permission_role` VALUES (3, 3);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` tinyint(2) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nameZh` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '角色名称：管理员；用户',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色：ROLE_ADMIN;ROLE_USER',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '吃瓜群众', 'ROLE_ANONYMOUS');
INSERT INTO `role` VALUES (2, '管理员', 'ADMIN');
INSERT INTO `role` VALUES (3, '大楼管理员', 'BUILD');

-- ----------------------------
-- Table structure for test1
-- ----------------------------
DROP TABLE IF EXISTS `test1`;
CREATE TABLE `test1`  (
  `id` int(5) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of test1
-- ----------------------------
INSERT INTO `test1` VALUES (1, '好好');
INSERT INTO `test1` VALUES (2, '哈哈哈');
INSERT INTO `test1` VALUES (3, '哈哈哈');
INSERT INTO `test1` VALUES (5, '的回电话号');
INSERT INTO `test1` VALUES (6, '666666');

-- ----------------------------
-- Table structure for test2
-- ----------------------------
DROP TABLE IF EXISTS `test2`;
CREATE TABLE `test2`  (
  `id` int(5) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of test2
-- ----------------------------
INSERT INTO `test2` VALUES (3, '打发第三方');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `updateTime` datetime(0) NOT NULL,
  PRIMARY KEY (`id`, `username`) USING BTREE,
  INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, 'build', '$2a$10$iM2DpX0Ap8RD0/KEtZONCeaVGpp0l4os3MUlI9oUMKvGO.vdqhQh2', '0000-00-00 00:00:00');
INSERT INTO `user` VALUES (4, 'test', '$2a$10$oyMKaog1ZpvogMmq6CMbZe3Mfe.S0HXMavP0FI8XlbXa48WQ9cpBy', '0000-00-00 00:00:00');
INSERT INTO `user` VALUES (5, 'clong2', '$2a$10$kGtJFCt86RhBCbGiNGlw3u/xM4kz9i.7RSCrEBYVbk1uCUo00QDNW', '2018-12-24 23:30:16');
INSERT INTO `user` VALUES (6, 'clong17', '$2a$10$2cPgVDu/3qnw.dSY8FlHrOQP4yZUKrUmSKzj7gUNClTSIUZIULrU6', '2018-12-25 01:11:00');
INSERT INTO `user` VALUES (7, 'zoolon', '$2a$10$U3b7wl8td1MP1NtToWa0gexbkOy/94ty0f76jXzHy2rgbtPEO9buu', '2018-12-26 01:18:28');
INSERT INTO `user` VALUES (8, 'clong123', '$2a$10$q5CSRjcbQ54JsQRjKFKyd.J3lyqFoYoiBJWdBElaVCZ.STDLdOgXu', '2018-12-27 18:05:20');
INSERT INTO `user` VALUES (9, 'zoolon5', '$2a$10$0yKvhGcaxfqrx0pbjSl.4uV.3Vpgx3W3MUs43w6WNUQQotUa/RXx.', '2018-12-28 17:08:29');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user` int(10) UNSIGNED NULL DEFAULT NULL,
  `role` tinyint(2) UNSIGNED NULL DEFAULT NULL,
  INDEX `user`(`user`) USING BTREE,
  INDEX `role`(`role`) USING BTREE,
  CONSTRAINT `role` FOREIGN KEY (`role`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (4, 3);
INSERT INTO `user_role` VALUES (5, 1);
INSERT INTO `user_role` VALUES (6, 1);
INSERT INTO `user_role` VALUES (7, 1);
INSERT INTO `user_role` VALUES (8, 1);
INSERT INTO `user_role` VALUES (3, 3);
INSERT INTO `user_role` VALUES (9, 1);

SET FOREIGN_KEY_CHECKS = 1;
