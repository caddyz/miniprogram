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

 Date: 20/07/2019 23:11:40
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
  `a_address_detail` varchar(155) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `u_id` int(7) NOT NULL COMMENT '用户id',
  `a_mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机',
  `a_name` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系人',
  PRIMARY KEY (`a_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (1, 'sfa', 'vvvvvvv', 2, '123', 'asd');

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon`  (
  `c_id` int(7) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `c_value` decimal(10, 2) NULL DEFAULT NULL,
  `c_status` int(1) NULL DEFAULT NULL COMMENT '1：打折券  2：抵扣券',
  `c_aging` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coupon
-- ----------------------------
INSERT INTO `coupon` VALUES (1, 'asdas', 35.00, 1, NULL);
INSERT INTO `coupon` VALUES (2, 'ggg', 8.00, 2, NULL);

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `i_id` int(10) NOT NULL AUTO_INCREMENT,
  `p_id` int(7) NULL DEFAULT NULL,
  `i_status` int(1) NULL DEFAULT NULL COMMENT '1:是轮播图  2是热门 3是推荐',
  `i_contro` int(10) NULL DEFAULT NULL COMMENT '控制更新',
  PRIMARY KEY (`i_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES (1, 2, 2, 1);
INSERT INTO `image` VALUES (2, 4, 2, 2);
INSERT INTO `image` VALUES (3, 3, 3, 1);
INSERT INTO `image` VALUES (4, 4, 3, 2);
INSERT INTO `image` VALUES (5, 4, 1, 0);
INSERT INTO `image` VALUES (6, 3, 1, 0);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `o_id` int(7) NOT NULL AUTO_INCREMENT,
  `o_number` int(16) NOT NULL COMMENT '订单号',
  `a_id` int(7) NULL DEFAULT NULL,
  `p_id` int(7) NULL DEFAULT NULL,
  `u_id` int(7) NULL DEFAULT NULL,
  `o_total_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `o_pay_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '实际支付',
  `o_user_message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户备注信息',
  `o_create_time` datetime(0) NULL DEFAULT NULL COMMENT '订单创建时间',
  `o_pay_time` datetime(0) NULL DEFAULT NULL,
  `o_delivery_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `o_confirm_time` datetime(0) NULL DEFAULT NULL COMMENT '订单确认时间',
  `o_status` int(1) NOT NULL DEFAULT 1 COMMENT '0：取消 1：未支付 2：已支付 3：已完成',
  `o_subscribe_time` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '预约时间',
  PRIMARY KEY (`o_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, 123, 1, 1, 2, 456.00, 12.00, 'dfdf', '2019-07-18 09:30:38', NULL, NULL, NULL, 1, NULL);
INSERT INTO `order` VALUES (2, 111, 1, 1, 2, 55.00, 30.00, 'f', '2019-07-18 10:09:18', NULL, NULL, NULL, 1, 'djdjdjd');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `p_id` int(3) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `p_original_price` decimal(10, 2) NOT NULL COMMENT '原价',
  `p_price` decimal(10, 2) NOT NULL COMMENT '优惠价',
  `p_cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '封面图',
  `p_intro_info` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '简介',
  `p_detail_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '详细信息',
  PRIMARY KEY (`p_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '妙尚佳全身按摩', 499.00, 299.00, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E6%8C%89%E6%91%A9/1%E5%89%AF%E6%9C%AC.jpg', '妙手关注健康，服务愉悦身心。专业上门到家，提供酒店，居家服务。', '12');
INSERT INTO `product` VALUES (2, '妙尚佳精油开背', 599.00, 399.00, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E7%B2%BE%E6%B2%B9%E5%BC%80%E8%83%8C/1%E5%89%AF%E6%9C%AC.jpg', '妙手关注健康，服务愉悦身心。专业上门到家，提供酒店，居家服务。', NULL);
INSERT INTO `product` VALUES (3, '妙尚佳全身精油推拿', 699.00, 499.00, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E7%B2%BE%E6%B2%B9%E6%8E%A8%E6%8B%BF/9%E5%89%AF%E6%9C%AC.jpg', '妙手关注健康，服务愉悦身心。专业上门到家，提供酒店，居家服务。', NULL);
INSERT INTO `product` VALUES (4, '妙尚佳精致养生精油SPA', 799.00, 599.00, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%BB%E7%94%9F%E7%B2%BE%E6%B2%B9SPA/10%E6%B7%98%E5%AE%9D.jpg', '妙手关注健康，服务愉悦身心。专业上门到家，提供酒店，居家服务。', NULL);
INSERT INTO `product` VALUES (5, 'v', 0.00, 98.00, 'https://img-oss.yunshanmeicai.com/goods/default/31d8dfa4-0d7b-4694-80f9-41b07c9d0a3a.png', '656', NULL);
INSERT INTO `product` VALUES (6, 'k', 0.00, 44.00, 'https://img-oss.yunshanmeicai.com/goods/default/31d8dfa4-0d7b-4694-80f9-41b07c9d0a3a.png', '6', NULL);
INSERT INTO `product` VALUES (7, '1', 0.00, 1.00, 'https://img-oss.yunshanmeicai.com/goods/default/31d8dfa4-0d7b-4694-80f9-41b07c9d0a3a.png', '1', NULL);
INSERT INTO `product` VALUES (8, '1', 0.00, 1.00, 'https://img-oss.yunshanmeicai.com/goods/default/31d8dfa4-0d7b-4694-80f9-41b07c9d0a3a.png', '1', NULL);
INSERT INTO `product` VALUES (9, '1', 0.00, 1.00, 'https://img-oss.yunshanmeicai.com/goods/default/31d8dfa4-0d7b-4694-80f9-41b07c9d0a3a.png', '1', NULL);
INSERT INTO `product` VALUES (10, 'f', 0.00, 9.00, 'https://img-oss.yunshanmeicai.com/goods/default/31d8dfa4-0d7b-4694-80f9-41b07c9d0a3a.png', 'd', NULL);

-- ----------------------------
-- Table structure for product2img
-- ----------------------------
DROP TABLE IF EXISTS `product2img`;
CREATE TABLE `product2img`  (
  `pi_id` int(7) NOT NULL AUTO_INCREMENT,
  `pi_img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图片地址',
  `p_id` int(7) NOT NULL COMMENT '对应产品',
  PRIMARY KEY (`pi_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product2img
-- ----------------------------
INSERT INTO `product2img` VALUES (1, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E6%8C%89%E6%91%A9/1%E5%89%AF%E6%9C%AC.jpg', 1);
INSERT INTO `product2img` VALUES (2, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E6%8C%89%E6%91%A9/2%E5%89%AF%E6%9C%AC.jpg', 1);
INSERT INTO `product2img` VALUES (3, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E6%8C%89%E6%91%A9/3%E5%89%AF%E6%9C%AC.jpg', 1);
INSERT INTO `product2img` VALUES (4, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E6%8C%89%E6%91%A9/4%E5%89%AF%E6%9C%AC.jpg', 1);
INSERT INTO `product2img` VALUES (5, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E6%8C%89%E6%91%A9/5%E5%89%AF%E6%9C%AC.jpg', 1);
INSERT INTO `product2img` VALUES (6, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E6%8C%89%E6%91%A9/6%E5%89%AF%E6%9C%AC.jpg', 1);
INSERT INTO `product2img` VALUES (7, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E6%8C%89%E6%91%A9/7%E5%89%AF%E6%9C%AC.jpg', 1);

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review`  (
  `r_id` int(10) NOT NULL AUTO_INCREMENT,
  `u_id` int(7) NOT NULL,
  `r_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `r_review_time` datetime(0) NOT NULL,
  `r_rate` int(1) NOT NULL COMMENT '评分',
  PRIMARY KEY (`r_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES (1, 1, '哈哈哈哈', '2019-07-17 19:49:08', 5);
INSERT INTO `review` VALUES (2, 2, 'afasfa', '2019-07-17 19:49:27', 4);
INSERT INTO `review` VALUES (3, 1, 'fsfs', '2019-07-17 19:57:29', 3);
INSERT INTO `review` VALUES (4, 1, 'Jhjhj骄傲是否', '2019-07-17 19:58:16', 5);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `u_id` int(6) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `u_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '0为普通 1为会员',
  `u_openid` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `u_points` int(8) NOT NULL DEFAULT 0 COMMENT '积分',
  `u_member_money` int(8) NOT NULL DEFAULT 0 COMMENT '会员余额',
  `u_avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户图片',
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'kk', 1, '10', 0, 0, '');
INSERT INTO `user` VALUES (2, 'kkl', 1, '123', 0, 0, '');

-- ----------------------------
-- Table structure for user2coupon
-- ----------------------------
DROP TABLE IF EXISTS `user2coupon`;
CREATE TABLE `user2coupon`  (
  `uc_id` int(7) NOT NULL AUTO_INCREMENT,
  `u_id` int(7) NULL DEFAULT NULL,
  `c_id` int(7) NULL DEFAULT NULL,
  `uc_mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `uc_status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '1 :未使用   0：已使用',
  PRIMARY KEY (`uc_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user2coupon
-- ----------------------------
INSERT INTO `user2coupon` VALUES (1, 1, 1, '12', 0);
INSERT INTO `user2coupon` VALUES (2, 1, 2, '23', 0);

SET FOREIGN_KEY_CHECKS = 1;
