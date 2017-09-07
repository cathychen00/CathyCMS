
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cms_resource`
-- ----------------------------
DROP TABLE IF EXISTS `cms_resource`;
CREATE TABLE `cms_resource` (
  `resource_id` INT NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(50) DEFAULT NULL,
  `audit_flag` varchar(2) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `delete_flag` varchar(1) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `icon` varchar(512) DEFAULT NULL,
  `order_no` int(11) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `parent_id` INT DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_resource
-- ----------------------------
INSERT INTO `cms_resource` VALUES ('1', '修改密码',null, '2017-03-17 15:32:19', '0', '2017-03-17 15:32:19', '',  '90', 'module', '/user/update_pwd', null);
INSERT INTO `cms_resource` VALUES ('2','内容管理', null, '2017-03-17 15:37:16', '0', '2017-03-17 15:37:16', '',  '30', 'module', '', null);
INSERT INTO `cms_resource` VALUES ('3','栏目列表', null, '2017-03-17 15:41:21', '0', '2017-03-17 16:17:12', '',  '31', 'page', '/cms/column/list', '2');
INSERT INTO `cms_resource` VALUES ('4','文章列表', null, '2017-03-17 15:42:31', '0', '2017-03-17 16:17:21', '',  '32', 'page', '/cms/article/list', '2');
INSERT INTO `cms_resource` VALUES ('5','换肤管理', null, '2017-03-28 16:37:07', '0', '2017-03-28 16:37:07', '',  '20', 'module', '/user/skin/list', null);
INSERT INTO `cms_resource` VALUES ('6', '权限管理',null, '2016-08-17 17:06:19', '0', '2016-10-28 17:02:57', '',  '10', 'module', '/user/list', null);
INSERT INTO `cms_resource` VALUES ('7','用户列表', null, '2016-09-07 15:15:58', '0', '2016-10-28 17:03:06', '',  '11', 'page', '/user/list', '6');
INSERT INTO `cms_resource` VALUES ('8','角色列表', null, '2016-09-07 15:17:37', '0', '2016-10-28 17:03:13', '',  '12', 'page', '/user/role_list', '6');
INSERT INTO `cms_resource` VALUES ('9','菜单列表', null, '2016-09-18 16:34:14', '0', '2016-10-28 17:03:19', '',  '13', 'page', '/user/menu_list', '6');

-- ----------------------------
-- Table structure for `cms_role`
-- ----------------------------
DROP TABLE IF EXISTS `cms_role`;
CREATE TABLE `cms_role` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_role
-- ----------------------------
INSERT INTO `cms_role` VALUES ('1', null, '2017-02-24 16:11:40', '0', '2017-02-24 16:11:40', null, '可以分配后台用户', '权限管理员', null, '', null);
INSERT INTO `cms_role` VALUES ('2', null, '2016-10-23 15:37:31', '0', '2017-02-24 16:11:20', null, '拥有所有的权限', '超级管理员', null, 'role_admin', null);

-- ----------------------------
-- Table structure for `cms_role_resource_rel`
-- ----------------------------
DROP TABLE IF EXISTS `cms_role_resource_rel`;
CREATE TABLE `cms_role_resource_rel` (
  `role_id` INT NOT NULL,
  `resources_id` INT NOT NULL,
  PRIMARY KEY (`role_id`,`resources_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_role_resource_rel
-- ----------------------------
INSERT INTO `cms_role_resource_rel` VALUES (1, '1');
--//TODO
-- ----------------------------
-- Table structure for `org_user`
-- ----------------------------
DROP TABLE IF EXISTS `cms_user`;
CREATE TABLE `cms_user` (
  `user_id` INT NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_user
-- ----------------------------
INSERT INTO `cms_user` VALUES (1, null, '2017-02-24 15:48:34', '0', '2017-03-27 15:01:12', null, '13202044010', '21218CCA77804D2BA1922C33E0151105', 'xujeff', '1', 'xujeff', '0', null);
INSERT INTO `cms_user` VALUES (2, null, '2016-08-17 15:17:02', '0', '2017-04-20 21:48:41', null, '13202044010', 'E10ADC3949BA59ABBE56E057F20F883E', '超级管理员', '1', 'admin', '0', 'skin_blue');

-- ----------------------------
-- Table structure for `cms_user_role_rel`
-- ----------------------------
DROP TABLE IF EXISTS `cms_user_role_rel`;
CREATE TABLE `cms_user_role_rel` (
  `user_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_user_role_rel
-- ----------------------------
INSERT INTO `cms_user_role_rel` VALUES (1,1);
INSERT INTO `cms_user_role_rel` VALUES (2,1);
