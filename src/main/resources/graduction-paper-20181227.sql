/*
 Navicat Premium Data Transfer

 Source Server         : base
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : yyl_schema

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 27/12/2018 15:57:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for g_laboratory
-- ----------------------------
DROP TABLE IF EXISTS `g_laboratory`;
CREATE TABLE `g_laboratory`  (
  `id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `adress` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `admin_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理者的id',
  `status` smallint(2) NOT NULL DEFAULT 1 COMMENT '0-删除，1-可使用',
  `created_time` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `changed_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `open_tim` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '开放时间',
  `intr` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '描述信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '毕业论文-实验室预约系统-实验室表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of g_laboratory
-- ----------------------------
INSERT INTO `g_laboratory` VALUES ('176940737622504837', '电子线路研究中心实验室', '杭州电子科技大学8教北218', '15200124', 1, '2018-12-11 11:49:59', '2018-12-12 12:00:15', '全天开放', '实验室');
INSERT INTO `g_laboratory` VALUES ('209177911763468765', '创新实践实验室', '杭州电子科技大学3教101', '15200127', 1, '2018-12-27 10:19:53', '2018-12-27 10:19:53', '全天开放', '用于师生完成创新实践');
INSERT INTO `g_laboratory` VALUES ('257319580548873829', '电子线路焊接实验室', '杭州电子科技大学8教北213', '15200127', 1, '2018-12-10 20:10:15', '2018-12-27 14:33:04', '周一至周五 8:00-18:00', '');
INSERT INTO `g_laboratory` VALUES ('326247931794818460', '电子线路理论实践实验室', '杭州电子科技大学8教北216', '15200124', 1, '2018-12-11 11:49:19', '2018-12-12 11:59:38', '周一至周五 8:00-18:00', NULL);
INSERT INTO `g_laboratory` VALUES ('368125408476653733', '电子线路创新实践实验室', '杭州电子科技大学8教北217', '15200124', 1, '2018-12-11 11:49:41', '2018-12-12 12:00:21', '周一至周五 8:00-18:00', '实验室');
INSERT INTO `g_laboratory` VALUES ('429881701527074609', '大学物理竞赛实验室', '杭州电子科技大学6教南楼606', '15200127', 1, '2018-12-27 10:32:01', '2018-12-27 10:32:01', '周一至周五8点至17点', '');
INSERT INTO `g_laboratory` VALUES ('435416332245604751', '学科指导实验室', '杭州电子科技大学行政楼101', '15200127', 1, '2018-12-27 10:36:50', '2018-12-27 14:32:01', '周一至周五8:00-16:00', '学科指导实验室用于学科指导（测试用）');
INSERT INTO `g_laboratory` VALUES ('511418538301701326', '电子线路实验室', '杭州电子科技大学8教北214', '15200127', 1, '2018-12-10 17:37:39', '2018-12-27 15:49:18', '周一至周五', '');
INSERT INTO `g_laboratory` VALUES ('679048071964308098', '组成原理上机实践实验室', '杭州电子科技大学1教北401', '15200124', 1, '2018-12-11 09:20:59', '2018-12-12 12:00:05', '周六 8:00-20:00', NULL);
INSERT INTO `g_laboratory` VALUES ('847636855782412079', '组成原理理论实践实验室', '杭州电子科技大学1教北402', '15200124', 1, '2018-12-11 09:21:30', '2018-12-11 09:21:30', NULL, NULL);
INSERT INTO `g_laboratory` VALUES ('876885070814104792', '操作系统上机实践实验室', '杭州电子科技大学1教北201', '15200128', 1, '2018-12-11 09:19:03', '2018-12-11 09:19:03', NULL, NULL);
INSERT INTO `g_laboratory` VALUES ('915860828471091721', '单片机上机实践实验室', '杭州电子科技大学1教北301', '15200128', 1, '2018-12-11 09:19:30', '2018-12-11 09:19:30', NULL, NULL);
INSERT INTO `g_laboratory` VALUES ('977814644775900534', '电子线路实习实验室', '杭州电子科技大学8教北215', '15200127', 1, '2018-12-10 20:10:31', '2018-12-10 20:11:31', NULL, NULL);

-- ----------------------------
-- Table structure for g_order
-- ----------------------------
DROP TABLE IF EXISTS `g_order`;
CREATE TABLE `g_order`  (
  `id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `laboratory_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `laboratory_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `laboratory_address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `bespeak_start_time` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `bespeak_end_time` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `used_to` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `remarks` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `status` smallint(2) NOT NULL DEFAULT 1 COMMENT '0-删除，1-待审核，2-审核通过（预约成功），3-审核不通过，4-完成',
  `admin_remarks` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '管理员备注',
  `created_time` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `changed_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '毕业论文-实验室预约系统-预约单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of g_order
-- ----------------------------
INSERT INTO `g_order` VALUES ('148890559548888820', '15200126', '杨应龙', '915860828471091721', '单片机上机实践实验室', '杭州电子科技大学1教北301', '2018-12-25 10:00:00', '2018-12-25 20:00:00', '学生实践', '邮件测试！', 1, NULL, '2018-12-24 13:41:28', '2018-12-24 13:41:28');
INSERT INTO `g_order` VALUES ('280716400863606710', '15200126', '赵楚艳', '257319580548873829', '电子线路焊接实验室', '杭州电子科技大学8教北213', '2018-12-28 10:00:00', '2018-12-29 20:00:00', '教师上课', '重新提交，时间已改变。（测试）', 1, '时间冲突，请选择时间重新提交', '2018-12-24 11:22:40', '2018-12-27 15:52:48');
INSERT INTO `g_order` VALUES ('292033079906591044', '15200126', '杨映龙', '257319580548873829', '电子线路焊接实验室', '杭州电子科技大学8教北213', '2018-12-15 08:00:00', '2018-12-15 18:00:00', '学生实践', '测试专用', 2, NULL, '2018-12-14 15:09:22', '2018-12-14 15:10:57');
INSERT INTO `g_order` VALUES ('350846333422470481', '15200126', '杨映龙', '847636855782412079', '组成原理理论实践实验室', '杭州电子科技大学1教北402', '2018-12-19 08:00:00', '2018-12-19 18:00:00', '其他', '开发测试', 1, NULL, '2018-12-18 14:26:53', '2018-12-18 14:26:53');
INSERT INTO `g_order` VALUES ('404849046719966072', '15200126', '黄贯中', '679048071964308098', '组成原理上机实践实验室', '杭州电子科技大学1教北401', '2018-12-19 20:00:00', '2018-12-20 21:00:00', '学生实践', '开发测试！注意保密', 1, NULL, '2018-12-14 15:19:04', '2018-12-14 18:28:27');
INSERT INTO `g_order` VALUES ('426506284902194600', '15200126', '邵昱文', '977814644775900534', '电子线路实习实验室', '杭州电子科技大学8教北215', '2018-12-26 10:00:00', '2018-12-27 20:00:00', '学生实践', '开发测试！修改预约单', 1, '该时间段已经被预约，请更换时间后再次提交', '2018-12-14 15:18:17', '2018-12-27 15:55:26');
INSERT INTO `g_order` VALUES ('515290435732069732', '15200126', '黄佩琪', '326247931794818460', '电子线路理论实践实验室', '杭州电子科技大学8教北216', '2018-12-12 00:00:00', '2018-12-13 00:00:00', '学生实践', '开发测试', 0, NULL, '2018-12-14 15:21:19', '2018-12-21 16:24:36');
INSERT INTO `g_order` VALUES ('547620723900482692', '15200126', '杨映龙', '847636855782412079', '组成原理理论实践实验室', '杭州电子科技大学1教北402', '2018-12-21 08:00:00', '2018-12-22 12:00:00', '学生实践', '测试开发', 4, NULL, '2018-12-14 15:07:48', '2018-12-21 16:31:52');
INSERT INTO `g_order` VALUES ('993421782012255983', '15200126', '杨映龙', '257319580548873829', '电子线路焊接实验室', '杭州电子科技大学8教北213', '2018-12-13 08:00:00', '2018-12-13 18:00:00', '学生实践', '第一个预约单，测试，预祝成功！', 2, '审核通过，注意实验室安全，保证实验室整洁。（测试）', '2018-12-12 19:00:46', '2018-12-27 15:38:33');

-- ----------------------------
-- Table structure for g_user
-- ----------------------------
DROP TABLE IF EXISTS `g_user`;
CREATE TABLE `g_user`  (
  `id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `status` smallint(2) NOT NULL DEFAULT 1 COMMENT '0-删除状态，1-普通用户，2-管理员用户',
  `created_time` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `changed_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `phone_UNIQUE`(`phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '毕业论文-实验室预约系统的用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of g_user
-- ----------------------------
INSERT INTO `g_user` VALUES ('15200124', '唐奇超', '15968161231', 'yangyl96@foxmail.com', '123456', 2, '2018-12-11 09:14:31', '2018-12-24 11:19:57');
INSERT INTO `g_user` VALUES ('15200126', '杨应龙', '15968161237', 'yangyl96@foxmail.com', '123', 1, '2018-12-07 19:58:06', '2018-12-18 15:59:05');
INSERT INTO `g_user` VALUES ('15200127', '胡望成', '15978900989', 'yangyl96@foxmail.com', '123456', 2, '2018-12-09 00:24:15', '2018-12-10 16:47:18');
INSERT INTO `g_user` VALUES ('15200128', '吴羽伦', '15968161235', 'yangyl96@foxmail.com', '123456', 2, '2018-12-11 09:12:27', '2018-12-11 09:16:20');

SET FOREIGN_KEY_CHECKS = 1;
