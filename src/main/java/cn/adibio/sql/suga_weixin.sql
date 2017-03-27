/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : suga_weixin

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-03-14 20:21:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `order_id` varchar(255) NOT NULL COMMENT '订单流水号',
  `open_id` varchar(255) NOT NULL COMMENT '下单的微信用户openid',
  `create_time` varchar(255) NOT NULL COMMENT '订单创建时间',
  `state` varchar(255) NOT NULL COMMENT '订单状态',
  `address` varchar(255) NOT NULL COMMENT '订单收货地址',
  `phone` varchar(255) NOT NULL COMMENT '订单收货人电话号码',
  `name` varchar(255) NOT NULL COMMENT '订单收货人姓名',
  `age` int(11) NOT NULL COMMENT '订单收货人年龄',
  `gender` varchar(255) NOT NULL COMMENT '订单收货人性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '201702190001', 'aaabbbccc', '11111111', 'wait1', '广东省广州市', '13318455656', '米克', '20', '男');
INSERT INTO `order` VALUES ('2', '2017024556464', 'asdasdsadas', '151313546', 'finished', '广东省汕头市', '15222122232', '苦海', '32', '女');

-- ----------------------------
-- Table structure for receive_info
-- ----------------------------
DROP TABLE IF EXISTS `receive_info`;
CREATE TABLE `receive_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '收货信息id',
  `open_id` varchar(255) NOT NULL COMMENT '填写该收货信息的微信用户openid',
  `name` varchar(255) NOT NULL COMMENT '收货人姓名',
  `gender` varchar(255) NOT NULL COMMENT '收货人性别',
  `age` int(11) NOT NULL COMMENT '收货人年龄',
  `address` varchar(255) NOT NULL COMMENT '收货地址',
  `phone` varchar(255) NOT NULL COMMENT '收货人电话号码',
  `token` varchar(255) NOT NULL COMMENT '无法用id查询时，用于标识该收货信息的唯一性',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of receive_info
-- ----------------------------
INSERT INTO `receive_info` VALUES ('1', 'aaabbbccc', '花花', '男', '20', '广东省深圳市的拉升阶段卢卡斯的', '11011011101', '');
INSERT INTO `receive_info` VALUES ('2', 'aaabbbcccddd', '草草', '女', '25', '被送进打算大苏打', '132323323233', '');
INSERT INTO `receive_info` VALUES ('16', 'aaabbbccc', '树树', '女', '54', '的速度撒打算大是', '213213211', '1487667557781aaabbbccc4STD');
INSERT INTO `receive_info` VALUES ('17', 'aaabbbccc', '强吻', '男', '54', 'affgsgfr', '213213123', '1487772493599aaabbbcccvRQy');
INSERT INTO `receive_info` VALUES ('18', 'aaabbbccc', '那节', '男', '54', 'affgsgfr', '213213123', '1487772637449aaabbbccc0gKa');
INSERT INTO `receive_info` VALUES ('19', 'aaabbbccc', '烘干机', '女', '32', '啊实打实大苏打撒旦', '12333333333', 'iamtoken12341234');
INSERT INTO `receive_info` VALUES ('21', 'aaabbbcccddd', '阿斯顿', '男', '34', '撒大苏打实打实的撒', '13223223333', '1489476837108aaabbbcccdddKRsm');
INSERT INTO `receive_info` VALUES ('22', 'aaabbbcccddd', '阿斯顿', '男', '34', '撒大苏打实打实的撒', '13223223333', '1489477590825aaabbbcccdddv2Ta');
INSERT INTO `receive_info` VALUES ('23', 'aaabbbcccddd', '阿斯顿', '男', '34', '撒大苏打实打实的撒', '13223223333', '1489477808053aaabbbcccdddBIsh');
INSERT INTO `receive_info` VALUES ('24', 'aaabbbccc', '大老怪的爸爸', '女', '23', '撒法发个凤凰股份', '1223123123123', '1489480529210null3o02');
INSERT INTO `receive_info` VALUES ('25', 'aaabbbccc', '小心点', '女', '23', '撒法发个凤凰股份', '1223123123123', '1489480672342nullEuYk');
INSERT INTO `receive_info` VALUES ('26', 'aaabbbccc', '人天空', '女', '23', '但是发射点风格', '2132132131231', '1489483171139aaabbbcccZlO2');
INSERT INTO `receive_info` VALUES ('27', 'aaabbbcccddd', '枯竭', '男', '34', '撒大苏打实打实的撒', '13223223333', '1489483337196aaabbbcccdddx39d');
INSERT INTO `receive_info` VALUES ('28', 'aaabbbcccddd', '阿斯顿', '男', '34', '撒大苏打实打实的撒', '13223223333', '1489483345896aaabbbcccdddvM1K');
INSERT INTO `receive_info` VALUES ('29', 'aaabbbcccddd', '枯竭', '男', '34', '撒大苏打实打实的撒', '13223223333', '1489483373281aaabbbcccdddc5oD');
INSERT INTO `receive_info` VALUES ('30', 'aaabbbcccddd', '枯竭', '男', '34', '撒大苏打实打实的撒', '13223223333', '1489483613193aaabbbcccdddMurc');
INSERT INTO `receive_info` VALUES ('31', 'aaabbbcccddd', '枯竭', '男', '34', '撒大苏打实打实的撒', '13223223333', '1489483853779aaabbbcccdddcRgO');
INSERT INTO `receive_info` VALUES ('32', 'aaabbbcccddd', '枯竭', '男', '34', '撒大苏打实打实的撒', '13223223333', '1489483911560aaabbbcccdddYztw');
INSERT INTO `receive_info` VALUES ('33', 'aaabbbcccddd', '枯竭', '男', '34', '撒大苏打实打实的撒', '13223223333', '1489484177282aaabbbcccdddIA6S');
INSERT INTO `receive_info` VALUES ('34', 'aaabbbcccddd', '枯竭', '男', '34', '撒大苏打实打实的撒', '13223223333', '1489484228253aaabbbcccdddaCQL');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `open_id` varchar(255) NOT NULL,
  `order_ids` varchar(255) DEFAULT NULL,
  `receinfo_ids` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`open_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('aaabbbccc', '1:2:', '1:16:17:18:35:');
INSERT INTO `user` VALUES ('aaabbbcccddd', null, '2:33:34:');
