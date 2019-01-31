/*
Navicat MySQL Data Transfer

Source Server         : lifusen
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : itfusen

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-07-20 21:51:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for itf_permission
-- ----------------------------
DROP TABLE IF EXISTS `itf_permission`;
CREATE TABLE `itf_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of itf_permission
-- ----------------------------

-- ----------------------------
-- Table structure for itf_role
-- ----------------------------
DROP TABLE IF EXISTS `itf_role`;
CREATE TABLE `itf_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of itf_role
-- ----------------------------

-- ----------------------------
-- Table structure for itf_rolepermission
-- ----------------------------
DROP TABLE IF EXISTS `itf_rolepermission`;
CREATE TABLE `itf_rolepermission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rid` bigint(20) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of itf_rolepermission
-- ----------------------------

-- ----------------------------
-- Table structure for itf_user
-- ----------------------------
DROP TABLE IF EXISTS `itf_user`;
CREATE TABLE `itf_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `login_Name` varchar(50) DEFAULT NULL,
  `login_Pwd` varchar(50) DEFAULT NULL,
  `create_Time` datetime DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of itf_user
-- ----------------------------

-- ----------------------------
-- Table structure for itf_userpermission
-- ----------------------------
DROP TABLE IF EXISTS `itf_userpermission`;
CREATE TABLE `itf_userpermission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of itf_userpermission
-- ----------------------------

-- ----------------------------
-- Table structure for itf_userrole
-- ----------------------------
DROP TABLE IF EXISTS `itf_userrole`;
CREATE TABLE `itf_userrole` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `rid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of itf_userrole
-- ----------------------------
