/*
 Navicat Premium Data Transfer

 Source Server         : 123
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost:3306
 Source Schema         : clothing

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : 65001

 Date: 22/05/2021 20:03:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'yjc', '15918306613', '1');
INSERT INTO `admin` VALUES (2, '店长', '123', '123');
INSERT INTO `admin` VALUES (3, 'asd', '123123', 'asd');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `number` int(10) NULL DEFAULT NULL COMMENT '编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物品名称',
  `price` decimal(10, 0) NULL DEFAULT NULL COMMENT '价格',
  `quantity` int(10) NULL DEFAULT NULL COMMENT '数量',
  `cid` int(10) NULL DEFAULT NULL COMMENT '用户ID',
  `img_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `brand` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `size` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `material` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `totalPrice` decimal(10, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cid`(`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '目录名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '服装');
INSERT INTO `category` VALUES (2, '鞋类');
INSERT INTO `category` VALUES (3, '内衣裤');

-- ----------------------------
-- Table structure for clothes
-- ----------------------------
DROP TABLE IF EXISTS `clothes`;
CREATE TABLE `clothes`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `number` int(10) NULL DEFAULT NULL COMMENT '编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `size` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '尺寸',
  `brand` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌',
  `price` decimal(10, 0) NULL DEFAULT NULL COMMENT '价格',
  `color` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '颜色',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '种类',
  `material` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '面料',
  `quantity` int(10) NULL DEFAULT NULL COMMENT '数量',
  `img_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `cid` int(10) NULL DEFAULT NULL COMMENT '目录ID',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态：上架下架',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `clothes_cons`(`cid`) USING BTREE,
  CONSTRAINT `clothes_cons` FOREIGN KEY (`cid`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clothes
-- ----------------------------
INSERT INTO `clothes` VALUES (2, 10001, '长袖T恤', 'L', 'L', 99, '白色', '上衣', '纯棉', 4, 'images/2.jpg', 1, 0);
INSERT INTO `clothes` VALUES (3, 10003, '条纹衫', 'S', '群岛', 222, '深蓝色', '上衣', '纯棉', 2, 'images/product-item-3.jpg', 1, 0);
INSERT INTO `clothes` VALUES (4, 10004, '衬衣', 'L', '群岛', 111, '粉色', '上衣', '纯棉', 1, 'images/product-item-4.jpg', 1, 0);
INSERT INTO `clothes` VALUES (5, 10005, '长袖T恤', 'L', '群岛', 111, '白色', '上衣', '纯棉', 4, 'images/product-item-5.jpg', 1, 0);
INSERT INTO `clothes` VALUES (6, 10006, '裙子', 'S', '群岛', 333, '黑色', '衣裙', '纯棉', 5, 'images/product-item-6.jpg', 1, 0);
INSERT INTO `clothes` VALUES (8, 10008, '拉链外套', 'XL', '群岛', 555, '黑色', '外套', '纯棉', 2, 'images/product-item-8.jpg', 1, 0);
INSERT INTO `clothes` VALUES (9, 10009, '条纹T恤', 'L', '群岛', 199, '黑白', '上衣', '纯棉', 1, 'images/product-item-9.jpg', 1, 0);
INSERT INTO `clothes` VALUES (10, 10010, '白卫衣', 'S', '群岛', 95, '白色', '上衣', '纯棉', 1, 'images/product-item-10.jpg', 1, 0);
INSERT INTO `clothes` VALUES (11, 10011, '短袖T恤', 'S', '群岛', 222, '豹纹色', '上衣', '纯棉', 6, 'images/product-item-11.jpg', 1, 0);
INSERT INTO `clothes` VALUES (13, 10012, '圆领短袖', 'M', '群岛', 600, '绿色', '套装', '纯棉', 9, 'images/product-item-12.jpg', 1, 0);
INSERT INTO `clothes` VALUES (14, 10014, '灰卫衣', 'S', '群岛', 99, '黑色', '上衣', '纯棉', 10, 'images/product-item-13.jpg', 1, 0);
INSERT INTO `clothes` VALUES (18, 10008, '套装', 'S', '群岛', 99, '白色', '上衣', '纯棉', 2, 'images/product-item-14.jpg', 1, 0);
INSERT INTO `clothes` VALUES (20, 10012, '黑短袖', 'XL', '群岛', 333, '黑色', '上衣', '纯棉', 2, 'images/product-item-15.jpg', 1, 0);
INSERT INTO `clothes` VALUES (21, 10013, '白短袖', 'S', '群岛', 333, '白色', '上衣', '纯棉', 2, 'images/product-item-16.jpg', 1, 0);
INSERT INTO `clothes` VALUES (22, 10015, '帆布鞋', '42', '群岛', 199, '蓝色', '鞋', '纯棉', 4, 'images/banner-home-8.jpg', 2, 0);
INSERT INTO `clothes` VALUES (23, 10016, '板鞋', '43', '群岛', 400, '红白色', '鞋', '纯棉', 2, 'images/shoes1.jpg', 2, 0);
INSERT INTO `clothes` VALUES (24, 10017, 'BB鞋', 'XX', '群岛', 99, '粉色', '鞋', '纯棉', 2, 'images/shoes2.jpg', 2, 0);
INSERT INTO `clothes` VALUES (25, 10018, '高帮鞋', '44', '群岛', 699, '白色', '鞋', '纯棉', 4, 'images/shoes3.jpg', 2, 0);
INSERT INTO `clothes` VALUES (26, 10019, 'BB鞋', 'XX', '群岛', 99, '白棕色', '内衣', '纯棉', 2, 'images/shoes4.jpg', 2, 0);
INSERT INTO `clothes` VALUES (29, 10021, '白内衣', 'L', '群岛', 149, '白色', '内衣', '纯棉', 1, 'images/product-item-black-6.jpg', 3, 0);
INSERT INTO `clothes` VALUES (30, 10022, '黑内衣', 'M', '群岛', 149, '黑色', '内衣', '纯棉', 2, 'images/product-item-21.jpg', 3, 0);
INSERT INTO `clothes` VALUES (31, 10023, '红内衣', 'S', '群岛', 199, '红色', '内衣', '纯棉', 2, 'images/product-item-7.jpg', 3, 0);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买家地址',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `phone`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, '庾君成', '15918306613', 'yujuncheng', '广东东莞');
INSERT INTO `customer` VALUES (3, '比比', '123456789', '123', '33栋335');
INSERT INTO `customer` VALUES (6, '锌', '12345678910', 'saasas', '33栋334');
INSERT INTO `customer` VALUES (8, '萝卜', '12345678910', '123', '123');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `number` int(10) NULL DEFAULT NULL COMMENT '衣服编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '衣服名称',
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `quantity` int(10) NULL DEFAULT NULL,
  `customerId` int(10) NULL DEFAULT NULL COMMENT '用户id',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户手机',
  `size` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `brand` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `color` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `material` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `totalPrice` decimal(10, 2) NULL DEFAULT NULL,
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `customerId`(`customerId`) USING BTREE,
  INDEX `phone`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (43, 10002, '长袖T恤', 99.00, 1, 1, '15918306613', 'M', '群岛', '白色', '上衣', '纯棉', 'images/product-item-2.jpg', 321.00, '2021-05-22 10: 49: 55');
INSERT INTO `order` VALUES (44, 10003, '条纹衫', 222.00, 1, 1, '15918306613', 'S', '群岛', '深蓝色', '上衣', '纯棉', 'images/product-item-3.jpg', 321.00, '2021-05-22 10: 49: 55');
INSERT INTO `order` VALUES (47, 10004, '衬衣', 111.00, 1, 8, '12345678910', 'L', '群岛', '粉色', '上衣', '纯棉', 'images/product-item-4.jpg', 309.00, '2021-05-21 23: 47: 35');
INSERT INTO `order` VALUES (48, 10017, 'BB鞋', 99.00, 1, 8, '12345678910', 'XX', '群岛', '粉色', '鞋', '纯棉', 'images/shoes2.jpg', 309.00, '2021-05-21 23: 47: 35');
INSERT INTO `order` VALUES (49, 10004, '衬衣', 111.00, 1, 1, '15918306613', 'L', '群岛', '粉色', '上衣', '纯棉', 'images/product-item-4.jpg', 222.00, '2021-05-22 10: 49: 55');
INSERT INTO `order` VALUES (50, 10005, '长袖T恤', 111.00, 1, 1, '15918306613', 'L', '群岛', '白色', '上衣', '纯棉', 'images/product-item-5.jpg', 222.00, '2021-05-22 10: 49: 55');
INSERT INTO `order` VALUES (52, 10004, '衬衣', 111.00, 1, 8, '12345678910', 'L', '群岛', '粉色', '上衣', '纯棉', 'images/product-item-4.jpg', 1060.00, '2021-05-21 23: 47: 35');
INSERT INTO `order` VALUES (53, 10016, '板鞋', 400.00, 2, 8, '12345678910', '43', '群岛', '红白色', '鞋', '纯棉', 'images/shoes1.jpg', 1060.00, '2021-05-21 23: 47: 35');
INSERT INTO `order` VALUES (54, 10022, '黑内衣', 149.00, 1, 8, '12345678910', 'M', '群岛', '黑色', '内衣', '纯棉', 'images/product-item-21.jpg', 1060.00, '2021-05-21 23: 47: 35');
INSERT INTO `order` VALUES (55, 10001, '衬衣', 199.00, 2, 1, '15918306613', 'M', 'M', '蓝色', '上衣', '纯棉', 'images/1.jpg', 497.00, '2021-05-22 10: 49: 55');
INSERT INTO `order` VALUES (56, 10002, '长袖T恤', 99.00, 1, 1, '15918306613', 'L', '群岛', '白色', '上衣', '纯棉', 'images/product-item-2.jpg', 497.00, '2021-05-22 10: 49: 55');

SET FOREIGN_KEY_CHECKS = 1;
