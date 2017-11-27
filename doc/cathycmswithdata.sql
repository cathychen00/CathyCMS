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

 Date: 11/01/2017 13:57:07 PM
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
--  Records of `cms_articles`
-- ----------------------------
BEGIN;
INSERT INTO `cms_articles` VALUES ('1', '1', '4', '2017-10-10 17:01:50', '2017-10-10 17:01:50', '2017-10-10 17:01:43', '<p>所属</p>', null, '超级管理员', '2', 'admin', '水水水水', '两个小时胜多负少', b'0', b'0', b'0', '0', b'0', ''), ('2', '2', '9', '2017-10-10 17:27:55', '2017-10-10 17:42:15', '2017-10-12 17:27:24', '<p>sdfsd<br/></p>', 'http://localhost:8088/uploads/cover/90767f1661b6423193b7c8e3ad43a4fd1504246860519.jpg', '超级管理员', '2', 'admin', '摘要2', '测试文章2', b'0', b'0', b'0', '0', b'0', 'http://localhost:8088/uploads/cover/e40734ffaf564c16b7c4a416cd1ae1381504246823549.jpg');
COMMIT;

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
--  Records of `cms_channel`
-- ----------------------------
BEGIN;
INSERT INTO `cms_channel` VALUES ('1', '频道1', '1', '0', '1', null, '0', '2017-09-27 15:14:41', '2017-09-27 16:39:43'), ('2', '频道2', '1', '0', '2', null, '0', '2017-09-27 15:25:47', '2017-09-27 17:10:21'), ('3', '频道2-1', '1', '2', '1', null, '1', '2017-09-27 15:37:58', '2017-09-27 18:03:47'), ('4', '频道1-2', '2', '1', '1', null, '0', '2017-09-27 17:54:21', '2017-09-27 18:03:34'), ('5', '频道3', '1', '0', '3', null, '0', '2017-09-27 18:12:55', '2017-09-27 18:12:55'), ('6', '频道3-11', '2', '5', '1', null, '0', '2017-09-27 18:14:36', '2017-09-27 18:14:41'), ('7', '频道1-2', '2', '1', '2', null, '0', '2017-09-28 17:43:16', '2017-09-28 17:43:16'), ('8', '频道1-3', '2', '1', '3', null, '0', '2017-09-28 17:43:24', '2017-09-28 17:43:24'), ('9', '频道2-2', '2', '2', '1', null, '0', '2017-09-28 17:43:31', '2017-09-28 17:43:31');
COMMIT;

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
--  Records of `cms_resource`
-- ----------------------------
BEGIN;
INSERT INTO `cms_resource` VALUES ('1', '修改密码', null, '2017-03-17 15:32:19', '1', '2017-09-25 11:04:09', '', '90', 'module', '/user/update_pwd', '-1'), ('2', '内容管理', null, '2017-03-17 15:37:16', '0', '2017-09-26 15:49:25', 'icon-book', '5', 'module', '/article/', '-1'), ('3', '栏目列表', null, '2017-03-17 15:41:21', '1', '2017-09-18 16:48:36', '', '31', 'page', '/cms/column/list', '2'), ('4', '文章列表', null, '2017-03-17 15:42:31', '0', '2017-10-10 17:57:51', 'icon-file', '7', 'page', '/article/list', '2'), ('5', '换肤管理', null, '2017-03-28 16:37:07', '1', '2017-09-18 16:48:33', '', '20', 'module', '/user/skin/list', null), ('6', '权限管理', null, '2016-08-17 17:06:19', '0', '2017-09-19 15:15:08', 'icon-cog', '1', 'module', '/user/list', '-1'), ('7', '用户列表', null, '2016-09-07 15:15:58', '0', '2017-09-26 14:33:49', 'icon-user', '4', 'page', '/user/list', '6'), ('9', '菜单列表', null, '2016-09-18 16:34:14', '0', '2017-09-26 14:33:56', 'icon-list-alt', '2', 'page', '/menu/index', '6'), ('18', '角色列表', null, '2017-09-18 18:09:37', '0', '2017-09-25 11:04:42', 'icon-leaf', '3', 'page', '/role/list', '6'), ('19', '内容管理', null, '2017-09-26 15:45:34', '1', '2017-09-26 15:45:43', '', '5', 'module', '/article/', '-1'), ('20', '频道列表', null, '2017-09-26 15:50:47', '0', '2017-09-26 15:52:09', 'icon-list', '6', 'page', '/channel/list', '2');
COMMIT;

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
--  Records of `cms_role`
-- ----------------------------
BEGIN;
INSERT INTO `cms_role` VALUES ('1', null, '2017-02-24 16:11:40', '0', '2017-09-26 14:41:00', null, '可以分配后台用户', '权限管理员', null, '', null), ('2', null, '2016-10-23 15:37:31', '0', '2017-09-28 09:37:35', null, '拥有所有的权限', '超级管理员', null, 'role_admin', null), ('3', null, '2017-09-19 16:31:20', '1', '2017-09-21 16:30:44', null, '', 'sfsdsfsd', null, null, null), ('9', null, '2017-09-25 17:17:59', '1', '2017-09-25 17:37:29', null, '', 'teset111', null, null, null), ('10', null, '2017-09-25 17:18:00', '1', '2017-09-25 17:37:32', null, '', 'teset111', null, null, null), ('11', null, '2017-09-25 17:18:09', '1', '2017-09-26 09:33:37', null, '', 'teset111', null, null, null), ('12', null, '2017-09-25 17:37:15', '1', '2017-09-26 09:36:06', null, '', 'testsfsfds', null, null, null), ('13', null, '2017-09-26 09:36:22', '1', '2017-09-26 09:36:35', null, '测试角色描述', '测试角色', null, null, null), ('14', null, '2017-09-26 14:41:19', '0', '2017-09-26 14:41:19', null, '', '内容运营', null, null, null);
COMMIT;

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
--  Records of `cms_role_resource_rel`
-- ----------------------------
BEGIN;
INSERT INTO `cms_role_resource_rel` VALUES ('1', '0'), ('1', '6'), ('1', '7'), ('1', '9'), ('1', '18'), ('2', '0'), ('2', '2'), ('2', '4'), ('2', '6'), ('2', '7'), ('2', '9'), ('2', '18'), ('2', '20'), ('5', '0'), ('5', '6'), ('5', '18'), ('11', '6'), ('11', '7'), ('11', '9'), ('11', '18'), ('13', '6'), ('13', '7'), ('13', '9'), ('13', '18');
COMMIT;

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
--  Records of `cms_user`
-- ----------------------------
BEGIN;
INSERT INTO `cms_user` VALUES ('2', null, '2016-08-17 15:17:02', '0', '2017-04-20 21:48:41', null, '13202044010', 'E10ADC3949BA59ABBE56E057F20F883E', '超级管理员', '1', 'admin', '0', 'skin_blue'), ('3', null, '2017-09-25 17:12:13', '0', '2017-09-25 17:49:44', 'chenjing@cathycms.com', '15888888888', '123456', '陈敬', null, 'chenjing', null, null), ('5', null, '2017-09-25 17:21:22', '0', '2017-09-26 10:05:41', '', '', '123456', '陈敬', null, 'chenjing3', null, null), ('8', null, '2017-09-26 10:06:18', '0', '2017-09-26 14:41:38', 'chenjing@cathycms.com', '15888888888', '123456', '陈敬', null, '测试用户', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `cms_user_role_rel`
-- ----------------------------
DROP TABLE IF EXISTS `cms_user_role_rel`;
CREATE TABLE `cms_user_role_rel` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `cms_user_role_rel`
-- ----------------------------
BEGIN;
INSERT INTO `cms_user_role_rel` VALUES ('1', '1'), ('2', '1'), ('3', '1'), ('4', '1'), ('5', '2'), ('7', '1'), ('8', '14');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
