/*
Navicat MySQL Data Transfer

Source Server         : Lineage
Source Server Version : 50523
Source Host           : localhost:3306
Source Database       : confectionery

Target Server Type    : MYSQL
Target Server Version : 50523
File Encoding         : 65001

Date: 2015-03-24 21:05:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `acceptorder`
-- ----------------------------
DROP TABLE IF EXISTS `acceptorder`;
CREATE TABLE `acceptorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` text,
  `deadline` datetime DEFAULT NULL,
  `costDelivery` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `enterpriseId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Order_Еnterprise1_idx` (`enterpriseId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of acceptorder
-- ----------------------------
INSERT INTO `acceptorder` VALUES ('1', 'Торт', '2015-03-19 00:00:00', '123', '451', '1');
INSERT INTO `acceptorder` VALUES ('2', 'Конфеты', '2015-04-19 00:00:00', '4536', '4356', '1');

-- ----------------------------
-- Table structure for `confenterprise`
-- ----------------------------
DROP TABLE IF EXISTS `confenterprise`;
CREATE TABLE `confenterprise` (
  `id` int(11) NOT NULL,
  `name` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of confenterprise
-- ----------------------------
INSERT INTO `confenterprise` VALUES ('1', 'Коммунарка');
INSERT INTO `confenterprise` VALUES ('2', 'Савушкин продукт');

-- ----------------------------
-- Table structure for `crude`
-- ----------------------------
DROP TABLE IF EXISTS `crude`;
CREATE TABLE `crude` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  `article` text,
  `amount` int(11) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `note` text,
  `productId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Crude_Product1_idx` (`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crude
-- ----------------------------
INSERT INTO `crude` VALUES ('1', 'Молоко', '9000', '4325423', '2345', 'Просто текст', '1');
INSERT INTO `crude` VALUES ('2', 'Сахар', '25000', '1234', '2134', 'Просто текст', '1');
INSERT INTO `crude` VALUES ('4', 'Соль', '500', '2343', '2343', 'Морская', '2');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  `count` int(11) DEFAULT NULL,
  `article` text,
  `description` text,
  `weight` int(11) DEFAULT NULL,
  `orderId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Product_Order_idx` (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'Пирожное', '34', '124515', 'Лол', '23', '1');
INSERT INTO `product` VALUES ('2', 'мороженое', '23', '4235', 'Круто', '54', '1');
INSERT INTO `product` VALUES ('4', 'Халва', '1234234', '12341235', 'Хорошо', '12341', '2');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'Администратор');
INSERT INTO `role` VALUES ('2', 'Менеджер');
INSERT INTO `role` VALUES ('3', 'Механик');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` text,
  `password` text,
  `status` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'megadeth', 'eb95fc1ab8251cf1f8f870e7e4dae54d', 'ACTIVE');
INSERT INTO `user` VALUES ('2', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'ACTIVE');

-- ----------------------------
-- Table structure for `userrole`
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userrole
-- ----------------------------
INSERT INTO `userrole` VALUES ('1', '1');
INSERT INTO `userrole` VALUES ('2', '2');

-- ----------------------------
-- Table structure for `worker`
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `surname` text,
  `name` text,
  `patronymic` text,
  `age` int(11) DEFAULT NULL,
  `experience` int(11) DEFAULT NULL,
  `hoursWork` int(11) DEFAULT NULL,
  `hourlyRate` int(11) DEFAULT NULL,
  `award` int(11) DEFAULT NULL,
  `orderId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Worker_Order1_idx` (`orderId`),
  KEY `fk_Worker_Position1_idx` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of worker
-- ----------------------------
INSERT INTO `worker` VALUES ('1', 'Назарчук', 'Дина', 'Олеговна', '45', '23', '8', '423', '1576', '0', '1');
INSERT INTO `worker` VALUES ('2', 'Иванов', 'Иван', 'Иваныч', '12', '12', '12', '12', '12', '0', '2');
INSERT INTO `worker` VALUES ('3', 'Смирнов', 'Олег', 'Михалыч', '123', '31', '4123', '123', '123', '0', '3');
INSERT INTO `worker` VALUES ('4', 'Котов', 'Артем', 'Олегович', '19', '6', '6', '10', '20', '2', '1');
INSERT INTO `worker` VALUES ('5', 'Евлаш', 'Сергей', 'Юрьевич', '7', '5', '4', '3', '4', '2', '1');
