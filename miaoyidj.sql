/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : miaoyidj

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 30/07/2019 21:42:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `a_id` int(7) NOT NULL AUTO_INCREMENT,
  `a_address` varchar(55) NOT NULL,
  `a_address_detail` varchar(155) NOT NULL,
  `u_id` int(7) NOT NULL COMMENT '用户id',
  `a_mobile` varchar(11) NOT NULL COMMENT '手机',
  `a_name` varchar(55) NOT NULL COMMENT '联系人',
  PRIMARY KEY (`a_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of address
-- ----------------------------
BEGIN;
INSERT INTO `address` VALUES (1, 'sfa', 'vvvvvvv啊沙发上', 3, '123456', '哈哈哈');
INSERT INTO `address` VALUES (2, '金牛区', '什么都没有', 3, '12345678901', '小李');
INSERT INTO `address` VALUES (3, '青羊区', 'asd', 3, '45678912301', 'xiao');
COMMIT;

-- ----------------------------
-- Table structure for button
-- ----------------------------
DROP TABLE IF EXISTS `button`;
CREATE TABLE `button` (
  `b_id` int(7) NOT NULL AUTO_INCREMENT,
  `b_base` int(5) NOT NULL COMMENT '充多少',
  `b_give` int(5) NOT NULL COMMENT '送多少',
  `b_rules` text NOT NULL COMMENT '充值规则',
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon` (
  `c_id` int(7) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(55) DEFAULT NULL,
  `c_value` decimal(10,2) DEFAULT NULL,
  `c_status` int(1) DEFAULT NULL COMMENT '1：打折券  2：抵扣券',
  `c_aging` datetime DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of coupon
-- ----------------------------
BEGIN;
INSERT INTO `coupon` VALUES (1, '新人优惠券', 20.00, 1, '2020-07-22 22:07:20');
INSERT INTO `coupon` VALUES (2, '满减', 8.00, 2, '2019-12-11 00:00:00');
INSERT INTO `coupon` VALUES (3, '单项优惠', 50.00, 1, '2019-09-30 09:37:03');
INSERT INTO `coupon` VALUES (4, '测试优惠券', 1.00, 2, '2019-01-23 00:00:00');
COMMIT;

-- ----------------------------
-- Table structure for coupon2product
-- ----------------------------
DROP TABLE IF EXISTS `coupon2product`;
CREATE TABLE `coupon2product` (
  `cp_id` int(7) NOT NULL AUTO_INCREMENT,
  `c_id` int(7) NOT NULL,
  `p_id` int(7) NOT NULL,
  PRIMARY KEY (`cp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `i_id` int(10) NOT NULL AUTO_INCREMENT,
  `p_id` int(7) DEFAULT NULL,
  `i_status` int(1) DEFAULT NULL COMMENT '1:是轮播图  2是热门 3是推荐',
  `i_contro` int(10) DEFAULT NULL COMMENT '控制更新',
  PRIMARY KEY (`i_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of image
-- ----------------------------
BEGIN;
INSERT INTO `image` VALUES (1, 2, 2, 1);
INSERT INTO `image` VALUES (2, 4, 2, 2);
INSERT INTO `image` VALUES (3, 3, 3, 1);
INSERT INTO `image` VALUES (4, 4, 3, 2);
INSERT INTO `image` VALUES (5, 4, 1, 0);
INSERT INTO `image` VALUES (6, 3, 1, 0);
COMMIT;

-- ----------------------------
-- Table structure for miaoyiorder
-- ----------------------------
DROP TABLE IF EXISTS `miaoyiorder`;
CREATE TABLE `miaoyiorder` (
  `o_id` int(7) NOT NULL AUTO_INCREMENT,
  `o_number` varchar(20) NOT NULL COMMENT '订单号',
  `a_id` int(7) DEFAULT NULL,
  `p_id` int(7) DEFAULT NULL,
  `u_id` int(7) DEFAULT NULL,
  `o_total_price` decimal(10,2) DEFAULT NULL COMMENT '订单总价',
  `o_pay_price` decimal(10,2) DEFAULT NULL COMMENT '实际支付',
  `o_user_message` varchar(255) DEFAULT NULL COMMENT '用户备注信息',
  `o_create_time` datetime DEFAULT NULL COMMENT '订单创建时间',
  `o_pay_time` datetime DEFAULT NULL,
  `o_delivery_time` datetime DEFAULT NULL COMMENT '发货时间',
  `o_confirm_time` datetime DEFAULT NULL COMMENT '订单确认时间',
  `o_status` int(1) NOT NULL DEFAULT '1' COMMENT '0：取消 1：未支付 2：已支付 3：已完成',
  `o_subscribe_time` varchar(55) DEFAULT NULL COMMENT '预约时间',
  PRIMARY KEY (`o_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of miaoyiorder
-- ----------------------------
BEGIN;
INSERT INTO `miaoyiorder` VALUES (1, '123', 1, 1, 2, 456.00, 12.00, 'dfdf', '2019-07-18 09:30:38', NULL, NULL, NULL, 1, NULL);
INSERT INTO `miaoyiorder` VALUES (2, '111', 1, 1, 2, 55.00, 30.00, '', '2019-07-18 10:09:18', NULL, NULL, NULL, 1, 'djdjdjd');
INSERT INTO `miaoyiorder` VALUES (3, '15638574485320329499', 2, 4, 3, 599.00, 599.00, NULL, NULL, NULL, NULL, NULL, 0, '2019-07-23  13');
INSERT INTO `miaoyiorder` VALUES (4, '15638593786152307112', 3, 4, 3, 599.00, 569.00, NULL, '2019-07-23 13:22:58', NULL, NULL, NULL, 1, '2019-07-23  14');
INSERT INTO `miaoyiorder` VALUES (5, '15638595769099834639', 3, 4, 3, 599.00, 569.00, NULL, '2019-07-23 13:26:16', NULL, NULL, NULL, 1, '2019-07-23  14');
INSERT INTO `miaoyiorder` VALUES (6, '15638598470689518017', 2, 4, 3, 599.00, 599.00, NULL, '2019-07-23 13:30:47', NULL, NULL, NULL, 2, '2019-07-23  14');
INSERT INTO `miaoyiorder` VALUES (7, '15638599406378585560', 2, 4, 3, 599.00, 599.00, NULL, '2019-07-23 13:32:20', NULL, NULL, NULL, 1, '2019-07-23  14');
INSERT INTO `miaoyiorder` VALUES (8, '15638600331668457304', 2, 3, 3, 499.00, 499.00, NULL, '2019-07-23 13:33:53', NULL, NULL, NULL, 2, '2019-07-23  14');
INSERT INTO `miaoyiorder` VALUES (9, '15638602336306723418', 2, 4, 3, 599.00, 599.00, 'djfhj', '2019-07-23 13:37:13', NULL, NULL, NULL, 1, '2019-07-23  14');
INSERT INTO `miaoyiorder` VALUES (10, '15638668096624557158', 2, 3, 3, 499.00, 449.00, NULL, '2019-07-23 15:26:49', NULL, NULL, NULL, 3, '2019-07-23  16');
INSERT INTO `miaoyiorder` VALUES (11, '15638668389269296602', 2, 3, 3, 499.00, 449.00, NULL, '2019-07-23 15:27:18', NULL, NULL, NULL, 1, '2019-07-23  16');
INSERT INTO `miaoyiorder` VALUES (12, '15638699495455971257', 1, 2, 3, 399.00, 379.00, NULL, '2019-07-23 16:19:09', NULL, NULL, NULL, 3, '2019-07-23  17');
INSERT INTO `miaoyiorder` VALUES (13, '15643898415627803434', 2, 1, 3, 299.00, 240.00, NULL, '2019-07-29 16:44:01', NULL, NULL, NULL, 1, '2019-07-29  17');
COMMIT;

-- ----------------------------
-- Table structure for miaoyirules
-- ----------------------------
DROP TABLE IF EXISTS `miaoyirules`;
CREATE TABLE `miaoyirules` (
  `r_id` int(7) NOT NULL AUTO_INCREMENT,
  `r_den_points` int(7) NOT NULL COMMENT '积分兑换多少分母',
  `r_mol_points` int(7) NOT NULL COMMENT '分子',
  `r_points_rules` text NOT NULL COMMENT '积分兑换规则',
  PRIMARY KEY (`r_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `p_id` int(3) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(55) NOT NULL,
  `p_original_price` decimal(10,2) NOT NULL COMMENT '原价',
  `p_price` decimal(10,2) NOT NULL COMMENT '优惠价',
  `p_cover` varchar(255) NOT NULL COMMENT '封面图',
  `p_intro_info` varchar(55) NOT NULL COMMENT '简介',
  `p_detail_info` varchar(255) DEFAULT NULL COMMENT '详细信息',
  PRIMARY KEY (`p_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of product
-- ----------------------------
BEGIN;
INSERT INTO `product` VALUES (1, '妙尚佳全身按摩', 499.00, 299.00, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E6%8C%89%E6%91%A9/1%E5%89%AF%E6%9C%AC.jpg', '妙手关注健康，服务愉悦身心。专业上门到家，提供酒店，居家服务。', '12');
INSERT INTO `product` VALUES (2, '妙尚佳精油开背', 599.00, 399.00, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E7%B2%BE%E6%B2%B9%E5%BC%80%E8%83%8C/1%E5%89%AF%E6%9C%AC.jpg', '妙手关注健康，服务愉悦身心。专业上门到家，提供酒店，居家服务。', NULL);
INSERT INTO `product` VALUES (3, '妙尚佳全身精油推拿', 699.00, 499.00, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E7%B2%BE%E6%B2%B9%E6%8E%A8%E6%8B%BF/9%E5%89%AF%E6%9C%AC.jpg', '妙手关注健康，服务愉悦身心。专业上门到家，提供酒店，居家服务。', NULL);
INSERT INTO `product` VALUES (4, '妙尚佳精致养生精油SPA', 799.00, 599.00, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%BB%E7%94%9F%E7%B2%BE%E6%B2%B9SPA/10%E6%B7%98%E5%AE%9D.jpg', '妙手关注健康，服务愉悦身心。专业上门到家，提供酒店，居家服务。', NULL);
COMMIT;

-- ----------------------------
-- Table structure for product2img
-- ----------------------------
DROP TABLE IF EXISTS `product2img`;
CREATE TABLE `product2img` (
  `pi_id` int(7) NOT NULL AUTO_INCREMENT,
  `pi_img_url` varchar(255) NOT NULL COMMENT '图片地址',
  `p_id` int(7) NOT NULL COMMENT '对应产品',
  PRIMARY KEY (`pi_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of product2img
-- ----------------------------
BEGIN;
INSERT INTO `product2img` VALUES (1, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E6%8C%89%E6%91%A9/1%E5%89%AF%E6%9C%AC.jpg', 1);
INSERT INTO `product2img` VALUES (2, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E6%8C%89%E6%91%A9/2%E5%89%AF%E6%9C%AC.jpg', 1);
INSERT INTO `product2img` VALUES (3, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E6%8C%89%E6%91%A9/3%E5%89%AF%E6%9C%AC.jpg', 1);
INSERT INTO `product2img` VALUES (4, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E6%8C%89%E6%91%A9/4%E5%89%AF%E6%9C%AC.jpg', 1);
INSERT INTO `product2img` VALUES (5, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E6%8C%89%E6%91%A9/5%E5%89%AF%E6%9C%AC.jpg', 1);
INSERT INTO `product2img` VALUES (6, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E6%8C%89%E6%91%A9/6%E5%89%AF%E6%9C%AC.jpg', 1);
INSERT INTO `product2img` VALUES (7, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E6%8C%89%E6%91%A9/7%E5%89%AF%E6%9C%AC.jpg', 1);
INSERT INTO `product2img` VALUES (8, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E7%B2%BE%E6%B2%B9%E5%BC%80%E8%83%8C/1%E5%89%AF%E6%9C%AC.jpg', 2);
INSERT INTO `product2img` VALUES (9, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E7%B2%BE%E6%B2%B9%E5%BC%80%E8%83%8C/2%E5%89%AF%E6%9C%AC.jpg', 2);
INSERT INTO `product2img` VALUES (10, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E7%B2%BE%E6%B2%B9%E5%BC%80%E8%83%8C/3%E5%89%AF%E6%9C%AC.jpg', 2);
INSERT INTO `product2img` VALUES (11, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E7%B2%BE%E6%B2%B9%E5%BC%80%E8%83%8C/4%E5%89%AF%E6%9C%AC.jpg', 2);
INSERT INTO `product2img` VALUES (12, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E7%B2%BE%E6%B2%B9%E5%BC%80%E8%83%8C/5%E5%89%AF%E6%9C%AC.jpg', 2);
INSERT INTO `product2img` VALUES (13, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E7%B2%BE%E6%B2%B9%E5%BC%80%E8%83%8C/6%E5%89%AF%E6%9C%AC.jpg', 2);
INSERT INTO `product2img` VALUES (14, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E7%B2%BE%E6%B2%B9%E5%BC%80%E8%83%8C/7%E5%89%AF%E6%9C%AC.jpg', 2);
INSERT INTO `product2img` VALUES (15, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E7%B2%BE%E6%B2%B9%E6%8E%A8%E6%8B%BF/10%E5%89%AF%E6%9C%AC.jpg', 3);
INSERT INTO `product2img` VALUES (16, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E7%B2%BE%E6%B2%B9%E6%8E%A8%E6%8B%BF/11%E5%89%AF%E6%9C%AC.jpg', 3);
INSERT INTO `product2img` VALUES (17, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E7%B2%BE%E6%B2%B9%E6%8E%A8%E6%8B%BF/12%E5%89%AF%E6%9C%AC.jpg', 3);
INSERT INTO `product2img` VALUES (18, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E7%B2%BE%E6%B2%B9%E6%8E%A8%E6%8B%BF/13%E5%89%AF%E6%9C%AC.jpg', 3);
INSERT INTO `product2img` VALUES (19, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E7%B2%BE%E6%B2%B9%E6%8E%A8%E6%8B%BF/14%E5%89%AF%E6%9C%AC.jpg', 3);
INSERT INTO `product2img` VALUES (20, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E7%B2%BE%E6%B2%B9%E6%8E%A8%E6%8B%BF/15%E5%89%AF%E6%9C%AC.jpg', 3);
INSERT INTO `product2img` VALUES (21, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E7%B2%BE%E6%B2%B9%E6%8E%A8%E6%8B%BF/16%E5%89%AF%E6%9C%AC.jpg', 3);
INSERT INTO `product2img` VALUES (22, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E7%B2%BE%E6%B2%B9%E6%8E%A8%E6%8B%BF/17%E5%89%AF%E6%9C%AC.jpg', 3);
INSERT INTO `product2img` VALUES (23, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%A8%E8%BA%AB%E7%B2%BE%E6%B2%B9%E6%8E%A8%E6%8B%BF/9%E5%89%AF%E6%9C%AC.jpg', 3);
INSERT INTO `product2img` VALUES (24, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%BB%E7%94%9F%E7%B2%BE%E6%B2%B9SPA/10%E6%B7%98%E5%AE%9D.jpg', 4);
INSERT INTO `product2img` VALUES (25, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%BB%E7%94%9F%E7%B2%BE%E6%B2%B9SPA/11%E6%B7%98%E5%AE%9D.jpg', 4);
INSERT INTO `product2img` VALUES (26, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%BB%E7%94%9F%E7%B2%BE%E6%B2%B9SPA/2%E6%B7%98%E5%AE%9D.jpg', 4);
INSERT INTO `product2img` VALUES (27, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%BB%E7%94%9F%E7%B2%BE%E6%B2%B9SPA/3%E6%B7%98%E5%AE%9D.jpg', 4);
INSERT INTO `product2img` VALUES (28, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%BB%E7%94%9F%E7%B2%BE%E6%B2%B9SPA/5%E6%B7%98%E5%AE%9D.jpg', 4);
INSERT INTO `product2img` VALUES (29, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%BB%E7%94%9F%E7%B2%BE%E6%B2%B9SPA/6%E6%B7%98%E5%AE%9D.jpg', 4);
INSERT INTO `product2img` VALUES (30, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%BB%E7%94%9F%E7%B2%BE%E6%B2%B9SPA/8%E6%B7%98%E5%AE%9D.jpg', 4);
INSERT INTO `product2img` VALUES (31, 'https://miaoyidj-1253818867.cos.ap-chengdu.myqcloud.com/%E5%85%BB%E7%94%9F%E7%B2%BE%E6%B2%B9SPA/9%E6%B7%98%E5%AE%9D.jpg', 4);
COMMIT;

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `r_id` int(7) NOT NULL AUTO_INCREMENT,
  `u_id` int(7) NOT NULL,
  `r_number` decimal(10,2) NOT NULL COMMENT '充值金额',
  `r_time` datetime NOT NULL COMMENT '充值时间',
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `r_id` int(10) NOT NULL AUTO_INCREMENT,
  `u_id` int(7) NOT NULL,
  `p_id` int(7) NOT NULL COMMENT '产品',
  `r_content` varchar(255) NOT NULL,
  `r_review_time` datetime NOT NULL,
  `r_rate` int(1) NOT NULL COMMENT '评分',
  PRIMARY KEY (`r_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of review
-- ----------------------------
BEGIN;
INSERT INTO `review` VALUES (1, 1, 1, '技师手法很好，下次还来。。。。。。', '2019-07-17 19:49:08', 5);
INSERT INTO `review` VALUES (2, 2, 2, '没什么好评的', '2019-07-17 19:49:27', 4);
INSERT INTO `review` VALUES (3, 1, 3, '不想说了', '2019-07-17 19:57:29', 3);
INSERT INTO `review` VALUES (4, 1, 4, '这款产品非常不错！！！', '2019-07-17 19:58:16', 5);
INSERT INTO `review` VALUES (5, 3, 4, '无法评论', '2019-07-22 20:53:00', 4);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(6) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(55) NOT NULL,
  `u_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0为普通 1为会员',
  `u_openid` varchar(55) NOT NULL,
  `u_points` int(8) NOT NULL DEFAULT '0' COMMENT '积分',
  `u_member_money` int(8) NOT NULL DEFAULT '0' COMMENT '会员余额',
  `u_avatar` varchar(255) NOT NULL COMMENT '用户图片',
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '卡萨', 1, '10', 0, 0, 'https://i.loli.net/2017/08/21/599a521472424.jpg');
INSERT INTO `user` VALUES (2, 'kkl', 1, '123', 0, 0, '');
INSERT INTO `user` VALUES (3, 'KaiserZ', 1, 'osMvt0OWnmnWnSWez_WKbdc2Eh_o', 100, 0, 'https://wx.qlogo.cn/mmopen/vi_32/svdwib1rZsYZiasb4W5qicjuNI5ZicFqGfG7e0C3EW9bx3LpHRLmGMwziaXzw4BW0MiaPCRBJCeBAmibaPjbmSECHwD4A/132');
COMMIT;

-- ----------------------------
-- Table structure for user2coupon
-- ----------------------------
DROP TABLE IF EXISTS `user2coupon`;
CREATE TABLE `user2coupon` (
  `uc_id` int(7) NOT NULL AUTO_INCREMENT,
  `u_id` int(7) NOT NULL,
  `c_id` int(7) NOT NULL,
  `uc_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1 :未使用   0：已使用',
  PRIMARY KEY (`uc_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user2coupon
-- ----------------------------
BEGIN;
INSERT INTO `user2coupon` VALUES (1, 3, 1, 0);
INSERT INTO `user2coupon` VALUES (2, 3, 2, 0);
INSERT INTO `user2coupon` VALUES (3, 3, 3, 1);
INSERT INTO `user2coupon` VALUES (4, 3, 4, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
