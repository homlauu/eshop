/*
Navicat MySQL Data Transfer

Source Server         : redhat
Source Server Version : 50173
Source Host           : 192.168.1.213:3306
Source Database       : eshop

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-03-06 10:33:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `time_series_data`
-- ----------------------------
DROP TABLE IF EXISTS `time_series_data`;
CREATE TABLE `time_series_data` (
  `item_id` varchar(36) NOT NULL DEFAULT '',
  `trading_date` date DEFAULT NULL,
  `stock_code` text,
  `item_value` double(16,2) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of time_series_data
-- ----------------------------
INSERT INTO `time_series_data` VALUES ('e931bd20-1bb6-11e8-8b51-0050563b7c0f', '2018-03-05', '0000001', '0.01');
INSERT INTO `time_series_data` VALUES ('e931be9c-1bb6-11e8-8b51-0050563b7c0f', '2018-03-06', '0000002', '-0.18');
