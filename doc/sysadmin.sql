/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : sysadmin

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-02-04 13:11:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_action`
-- ----------------------------
DROP TABLE IF EXISTS `sys_action`;
CREATE TABLE `sys_action` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `projectid` bigint(20) DEFAULT NULL,
  `menuid` bigint(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `note` varchar(50) DEFAULT NULL,
  `ordernum` bigint(11) DEFAULT '0',
  `eisdel` bit(1) DEFAULT b'0',
  `ectime` datetime DEFAULT NULL,
  `eutime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_action
-- ----------------------------
INSERT INTO `sys_action` VALUES ('15', '7', '13', '测试系统1_菜单1_子菜单1_功能1', 'efe92667ba3b4c6aac5d3b8cd3d7eaf1', '测试系统1_菜单1_子菜单1_功能1', '0', '', null, null);
INSERT INTO `sys_action` VALUES ('16', '7', '13', '测试系统1_菜单1_子菜单1_功能2', 'eb5cec19629c45f99b1fe2b99fe5b96a', '测试系统1_菜单1_子菜单1_功能2', '0', '', null, null);
INSERT INTO `sys_action` VALUES ('17', '7', '11', '测试系统1_菜单1_功能1', 'fa2e6af861f94bc9ba3e151da8c05850', '测试系统1_菜单1_功能1', '0', '', null, null);
INSERT INTO `sys_action` VALUES ('18', '8', '14', '测试系统2_菜单2_功能1', '0cf7e556117642af8d0cd560018b641a', '测试系统2_菜单2_功能1', '0', '', null, null);

-- ----------------------------
-- Table structure for `sys_admin`
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin`;
CREATE TABLE `sys_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  `note` varchar(50) DEFAULT NULL,
  `expiretime` datetime DEFAULT NULL,
  `lastdate` datetime DEFAULT NULL,
  `lastip` varchar(50) DEFAULT NULL,
  `eisdel` bit(1) DEFAULT b'0',
  `ectime` datetime DEFAULT NULL,
  `eutime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_admin
-- ----------------------------
INSERT INTO `sys_admin` VALUES ('12', 'testuser', 'testuser', null, null, null, null, '', null, null);

-- ----------------------------
-- Table structure for `sys_dic`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dic`;
CREATE TABLE `sys_dic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parentid` bigint(20) DEFAULT '0',
  `kindid` bigint(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `value` varchar(50) DEFAULT NULL,
  `ordernum` int(11) DEFAULT '0',
  `eisdel` bit(1) DEFAULT b'0' COMMENT '删除标记',
  `ectime` datetime DEFAULT NULL,
  `eutime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dic
-- ----------------------------
INSERT INTO `sys_dic` VALUES ('13', '0', '10100', '测试1', '101', '0', '', null, null);
INSERT INTO `sys_dic` VALUES ('14', '0', '10200', '测试2', '102', '0', '', null, null);
INSERT INTO `sys_dic` VALUES ('15', '13', '10101', '测试1_1', '101_1', '0', '', null, null);

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `projectid` bigint(20) DEFAULT NULL,
  `parentid` bigint(20) DEFAULT '0',
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `icostyle` varchar(50) DEFAULT NULL,
  `note` varchar(50) DEFAULT NULL,
  `ordernum` bigint(11) DEFAULT '0',
  `eisdel` bit(1) DEFAULT b'0',
  `ectime` datetime DEFAULT NULL,
  `eutime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('11', '7', '0', '测试系统1_菜单1', '9ea964f7bc7844c4b19a2ae3709f27ac', '/testsystem1/testmenu1', '', '', '0', '', null, null);
INSERT INTO `sys_menu` VALUES ('12', '7', '0', '测试系统1_菜单2', 'ed2da4a536f346fcbe07db4c4f09fd81', '/testsystem1/testmenu2', '', '', '0', '', null, null);
INSERT INTO `sys_menu` VALUES ('13', '7', '11', '测试系统1_菜单1_子菜单1', 'f4bd3611f5db40a1910bc637b491f7bc', '/testsystem1/testmenu1/childmenu1', '', '', '0', '', null, null);
INSERT INTO `sys_menu` VALUES ('14', '8', '0', '测试系统2_菜单2', 'aaea610a8a2d47b9ba90baa22b6d5b66', '/testsystem2/testmenu2', '', '', '0', '', null, null);

-- ----------------------------
-- Table structure for `sys_org`
-- ----------------------------
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parentid` bigint(20) DEFAULT '0',
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `note` varchar(50) DEFAULT NULL,
  `ordernum` int(11) DEFAULT '0',
  `eisdel` bit(1) DEFAULT b'0',
  `ectime` datetime DEFAULT NULL,
  `eutime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_org
-- ----------------------------
INSERT INTO `sys_org` VALUES ('7', '0', '测试组织1', 'e52211fa4a954a689d9da21f65eff547', '测试组织1', '0', '', null, null);
INSERT INTO `sys_org` VALUES ('8', '0', '测试组织2', '8b8d4480fcd74742bf0fad904cff2d37', '测试组织2', '0', '', null, null);
INSERT INTO `sys_org` VALUES ('9', '7', '测试组织1_1', '6c1a643959c24a6eab5f725578290d01', '测试组织1_1', '0', '', null, null);

-- ----------------------------
-- Table structure for `sys_org_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_org_permission`;
CREATE TABLE `sys_org_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `orgid` bigint(20) DEFAULT NULL,
  `permissionid` bigint(20) DEFAULT NULL,
  `eisdel` bit(1) DEFAULT b'0',
  `ectime` datetime DEFAULT NULL,
  `eutime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_org_permission
-- ----------------------------
INSERT INTO `sys_org_permission` VALUES ('16', '7', '6', '', null, null);
INSERT INTO `sys_org_permission` VALUES ('17', '8', '7', '', null, null);

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `projectid` bigint(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `note` varchar(50) DEFAULT NULL,
  `ordernum` bigint(11) DEFAULT '0',
  `eisdel` bit(1) DEFAULT b'0',
  `ectime` datetime DEFAULT NULL,
  `eutime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('6', '7', '测试权限1', '测试权限1', '0', '', null, null);
INSERT INTO `sys_permission` VALUES ('7', '8', '测试权限2', '测试权限2', '0', '', null, null);

-- ----------------------------
-- Table structure for `sys_permission_action`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_action`;
CREATE TABLE `sys_permission_action` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permissionid` bigint(20) DEFAULT NULL,
  `actionid` bigint(20) DEFAULT NULL,
  `eisdel` bit(1) DEFAULT b'0',
  `ectime` datetime DEFAULT NULL,
  `eutime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission_action
-- ----------------------------
INSERT INTO `sys_permission_action` VALUES ('6', '6', '15', '', null, null);
INSERT INTO `sys_permission_action` VALUES ('7', '6', '16', '', null, null);
INSERT INTO `sys_permission_action` VALUES ('8', '6', '17', '', null, null);
INSERT INTO `sys_permission_action` VALUES ('9', '7', '18', '', null, null);

-- ----------------------------
-- Table structure for `sys_permission_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_menu`;
CREATE TABLE `sys_permission_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permissionid` bigint(20) DEFAULT NULL,
  `menuid` bigint(20) DEFAULT NULL,
  `eisdel` bit(1) DEFAULT b'0',
  `ectime` datetime DEFAULT NULL,
  `eutime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission_menu
-- ----------------------------
INSERT INTO `sys_permission_menu` VALUES ('6', '6', '11', '', null, null);
INSERT INTO `sys_permission_menu` VALUES ('7', '6', '13', '', null, null);
INSERT INTO `sys_permission_menu` VALUES ('8', '7', '14', '', null, null);

-- ----------------------------
-- Table structure for `sys_project`
-- ----------------------------
DROP TABLE IF EXISTS `sys_project`;
CREATE TABLE `sys_project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `note` varchar(50) DEFAULT NULL,
  `ordernum` bigint(11) DEFAULT '0',
  `eisdel` bit(1) DEFAULT b'0',
  `ectime` datetime DEFAULT NULL,
  `eutime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_project
-- ----------------------------
INSERT INTO `sys_project` VALUES ('7', '测试系统1', '84a23bce51b9457e959753af181e789b', '测试系统1', '0', '', null, null);
INSERT INTO `sys_project` VALUES ('8', '测试系统2', 'ff3f67def77d45dc9ea5a7920ee0d1cc', '测试系统2', '0', '', null, null);

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `projectid` bigint(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `note` varchar(50) DEFAULT NULL,
  `ordernum` bigint(11) DEFAULT '0',
  `eisdel` bit(1) DEFAULT b'0',
  `ectime` datetime DEFAULT NULL,
  `eutime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('3', '7', '测试角色1', '测试角色1', '0', '', null, null);
INSERT INTO `sys_role` VALUES ('4', '8', '测试角色2', '测试角色2', '0', '', null, null);

-- ----------------------------
-- Table structure for `sys_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleid` bigint(20) DEFAULT NULL,
  `permissionid` bigint(20) DEFAULT NULL,
  `eisdel` bit(1) DEFAULT b'0',
  `ectime` datetime DEFAULT NULL,
  `eutime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('6', '3', '6', '', null, null);
INSERT INTO `sys_role_permission` VALUES ('7', '4', '7', '', null, null);

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `note` varchar(50) DEFAULT NULL,
  `lastdate` datetime DEFAULT NULL,
  `lastip` varchar(50) DEFAULT NULL,
  `eisdel` bit(1) DEFAULT b'0',
  `ectime` datetime DEFAULT NULL,
  `eutime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('13', 'test1', 'test1', '07dc190d82f94bb482cd801e8677ddc5', '测试用户1', null, null, '', null, null);
INSERT INTO `sys_user` VALUES ('14', 'test2', 'test2', 'e076bff409db4c43adbf203bb228d1d0', '测试用户2', null, null, '', null, null);

-- ----------------------------
-- Table structure for `sys_user_org`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_org`;
CREATE TABLE `sys_user_org` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) DEFAULT NULL,
  `orgid` bigint(20) DEFAULT NULL,
  `eisdel` bit(1) DEFAULT b'0',
  `ectime` datetime DEFAULT NULL,
  `eutime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_org
-- ----------------------------
INSERT INTO `sys_user_org` VALUES ('16', null, '7', '', null, null);
INSERT INTO `sys_user_org` VALUES ('17', '13', '7', '', null, null);
INSERT INTO `sys_user_org` VALUES ('18', null, '8', '', null, null);
INSERT INTO `sys_user_org` VALUES ('19', '14', '8', '', null, null);

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) DEFAULT NULL,
  `roleid` bigint(20) DEFAULT NULL,
  `eisdel` bit(1) DEFAULT b'0',
  `ectime` datetime DEFAULT NULL,
  `eutime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('130', '13', '3', '', null, null);
INSERT INTO `sys_user_role` VALUES ('131', null, '4', '', null, null);
INSERT INTO `sys_user_role` VALUES ('132', '14', '4', '', null, null);
