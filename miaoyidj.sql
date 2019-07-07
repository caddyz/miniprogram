/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost:3306
 Source Schema         : miaoyidj

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 07/07/2019 13:50:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `a_id` int(7) NOT NULL AUTO_INCREMENT,
  `a_address` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `u_id` int(7) NOT NULL,
  PRIMARY KEY (`a_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon`  (
  `c_id` int(7) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `c_value` decimal(10, 2) NULL DEFAULT NULL,
  `c_status` int(1) NULL DEFAULT NULL COMMENT '1：打折券  2：抵扣券',
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `i_id` int(10) NOT NULL AUTO_INCREMENT,
  `p_id` int(7) NULL DEFAULT NULL,
  `i_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `i_status` tinyint(1) NULL DEFAULT NULL COMMENT '1:是轮播图  0不是轮播图',
  PRIMARY KEY (`i_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `o_id` int(7) NOT NULL AUTO_INCREMENT,
  `o_number` int(16) NOT NULL,
  `a_id` int(7) NULL DEFAULT NULL,
  `u_id` int(7) NULL DEFAULT NULL,
  `o_mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `o_user_message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户备注信息',
  `o_create_time` datetime(0) NULL DEFAULT NULL,
  `o_pay_time` datetime(0) NULL DEFAULT NULL,
  `o_delivery_time` datetime(0) NULL DEFAULT NULL,
  `o_confirm_time` datetime(0) NULL DEFAULT NULL,
  `o_status` int(1) NULL DEFAULT NULL COMMENT '0：取消 1：未支付 2：已支付 3：接单 4：已完成',
  PRIMARY KEY (`o_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order2product
-- ----------------------------
DROP TABLE IF EXISTS `order2product`;
CREATE TABLE `order2product`  (
  `op_id` int(7) NOT NULL AUTO_INCREMENT,
  `o_number` int(16) NOT NULL,
  `p_id` int(3) NULL DEFAULT NULL,
  PRIMARY KEY (`op_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `p_id` int(3) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `p_price` decimal(10, 2) NOT NULL,
  `p_cover` varchar(155) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '封面图',
  PRIMARY KEY (`p_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review`  (
  `r_id` int(10) NOT NULL AUTO_INCREMENT,
  `u_id` int(7) NULL DEFAULT NULL,
  `r_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `r_review_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`r_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `u_id` int(6) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `u_status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '0为普通 1为会员',
  `u_openid` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `u_points` int(8) NULL DEFAULT NULL COMMENT '积分',
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user2coupon
-- ----------------------------
DROP TABLE IF EXISTS `user2coupon`;
CREATE TABLE `user2coupon`  (
  `uc_id` int(7) NOT NULL AUTO_INCREMENT,
  `u_id` int(7) NULL DEFAULT NULL,
  `c_id` int(7) NULL DEFAULT NULL,
  PRIMARY KEY (`uc_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
