/*
 Navicat Premium Data Transfer

 Source Server         : 测试数据库
 Source Server Type    : MariaDB
 Source Server Version : 100126
 Source Host           : 127.0.0.1:3306
 Source Schema         : di

 Target Server Type    : MariaDB
 Target Server Version : 100126
 File Encoding         : 65001

 Date: 31/12/2018 15:44:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for red_packet_account
-- ----------------------------
DROP TABLE IF EXISTS `red_packet_account`;
CREATE TABLE `red_packet_account`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `balance_amount` decimal(19, 2) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nameZh` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '角色名称：管理员；用户',
  `name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色：ROLE_ADMIN;ROLE_USER',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '用户', 'ROLE_USER');
INSERT INTO `sys_role` VALUES (2, '管理员', 'ROLE_ADMIN');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `nickname` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'string', '', '$2a$10$OUhyAMb9xz/y.En09L2u9O1JE.n2kaXjczzvIcEGHE2Wuv9NeW.SW');
INSERT INTO `sys_user` VALUES (3, 'clong', '', '$2a$10$ZHdJMNkRLZKAWPv75Y4MhOJO1wnVAJhRqfKVlYCpuVdsMq2yTzIjy');
INSERT INTO `sys_user` VALUES (4, 'clong1', '', '$2a$10$T/3P.KWn4EEZXveRo1/Wk...v4H7jhcxzOKKCo4QUvj8g69xm1Jdm');
INSERT INTO `sys_user` VALUES (5, 'clong3', '', '$2a$10$fXgdhforFctiqQXZQdn8YuJK7ljygpkJPkFhnbzeQYPBn5VQ1D2UO');
INSERT INTO `sys_user` VALUES (6, 'clong4', '', '$2a$10$pfq6umyIIgQD46PVVUOirOibaFXoCuwjMqMsOY9N2qGi6qKlXS14i');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1);
INSERT INTO `sys_user_role` VALUES (4, 4, 1);
INSERT INTO `sys_user_role` VALUES (5, 5, 1);
INSERT INTO `sys_user_role` VALUES (6, 6, 1);

-- ----------------------------
-- Table structure for test1
-- ----------------------------
DROP TABLE IF EXISTS `test1`;
CREATE TABLE `test1`  (
  `id` int(5) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
