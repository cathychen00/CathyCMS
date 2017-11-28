/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost
 Source Database       : cathycms

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : utf-8

 Date: 11/28/2017 17:29:26 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `cms_articles`
-- ----------------------------
DROP TABLE IF EXISTS `cms_articles`;
CREATE TABLE `cms_articles` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `channel1` int(11) DEFAULT NULL,
  `channel2` int(11) DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL,
  `publish_time` datetime DEFAULT NULL,
  `content` longtext,
  `cover_image_url` varchar(128) DEFAULT NULL,
  `publisher` varchar(64) DEFAULT NULL,
  `admin_id` int(11) NOT NULL DEFAULT '0',
  `admin_name` varchar(50) DEFAULT NULL,
  `summary` varchar(512) DEFAULT NULL,
  `title` varchar(256) DEFAULT NULL,
  `is_audit` bit(1) DEFAULT NULL,
  `is_top` bit(1) DEFAULT NULL,
  `is_delete` bit(1) NOT NULL,
  `pc_pv` int(11) unsigned DEFAULT NULL,
  `is_draft` bit(1) NOT NULL DEFAULT b'0',
  `cover_image` varchar(300) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `cms_channel`
-- ----------------------------
DROP TABLE IF EXISTS `cms_channel`;
CREATE TABLE `cms_channel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `channelName` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `level` varchar(45) NOT NULL DEFAULT '0',
  `parentId` int(11) NOT NULL DEFAULT '0',
  `orderNum` int(11) NOT NULL DEFAULT '0',
  `icon` varchar(45) DEFAULT NULL,
  `isDel` varchar(45) NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `cms_resource`
-- ----------------------------
DROP TABLE IF EXISTS `cms_resource`;
CREATE TABLE `cms_resource` (
  `resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(50) DEFAULT NULL,
  `audit_flag` varchar(2) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `delete_flag` varchar(1) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `icon` varchar(512) DEFAULT NULL,
  `order_no` int(11) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `cms_role`
-- ----------------------------
DROP TABLE IF EXISTS `cms_role`;
CREATE TABLE `cms_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `audit_flag` varchar(2) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `delete_flag` varchar(1) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `code` varchar(128) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `no` int(11) DEFAULT NULL,
  `role_name` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `cms_role_resource_rel`
-- ----------------------------
DROP TABLE IF EXISTS `cms_role_resource_rel`;
CREATE TABLE `cms_role_resource_rel` (
  `role_id` int(11) NOT NULL,
  `resources_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`resources_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `cms_user`
-- ----------------------------
DROP TABLE IF EXISTS `cms_user`;
CREATE TABLE `cms_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `audit_flag` varchar(2) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `delete_flag` varchar(1) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `real_name` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `type` int(11) DEFAULT '0',
  `current_skin` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `cms_user_role_rel`
-- ----------------------------
DROP TABLE IF EXISTS `cms_user_role_rel`;
CREATE TABLE `cms_user_role_rel` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
