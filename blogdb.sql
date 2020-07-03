/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : blogdb

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 04/07/2020 01:52:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog_table
-- ----------------------------
DROP TABLE IF EXISTS `blog_table`;
CREATE TABLE `blog_table`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `context` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `writeTime` datetime(0) NOT NULL,
  `user_id` int(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_table
-- ----------------------------
INSERT INTO `blog_table` VALUES (4, 'first', '这是我的第一条博客。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。', '2020-06-26 21:57:51', 4);
INSERT INTO `blog_table` VALUES (6, '三', '这是我的第三篇博客。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。', '2020-06-26 22:10:28', 1);
INSERT INTO `blog_table` VALUES (7, '四', '这是我的第四篇博客。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。', '2020-06-26 22:16:40', 1);
INSERT INTO `blog_table` VALUES (8, '五', '这是我的第5篇博客。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。', '2020-06-26 22:23:44', 1);
INSERT INTO `blog_table` VALUES (13, 'first', '这是我的第一条博客。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。', '2020-06-28 02:49:52', 3);
INSERT INTO `blog_table` VALUES (15, '疫情', '2019年12月和2020年初，中国湖北武汉出现新冠肺炎最初病例，最开始，人们还没有意识到这种病毒的严重性，导致病毒扩散，短短一个月的时间里，病毒呈现指数增长，确诊人数达万人，为控制疫情的不管扩大，在中国共产党的领导下，采取一系列措施，如派遣医疗队伍，加快口罩生产，动用部队等。然而在中国疫情得到明显控制时，国外疫情却开始大范围扩张，并且在很长一段时间内呈现不断增长的趋势。为什么中国可以再短时间内将疫情控制住，而国外却并没有减缓的趋势呢？这一切都要归功于坚持党的领导，这也是中国特色社会主义制度的显著优势。', '2020-06-29 01:57:03', 1);
INSERT INTO `blog_table` VALUES (17, 'first', '2范德萨给第三方华东师范', '2020-06-29 10:09:31', 5);
INSERT INTO `blog_table` VALUES (18, '发表博文', '这是我的一篇博客', '2020-06-29 10:55:44', 1);
INSERT INTO `blog_table` VALUES (19, '五/////', '、、、、、、、、这是我的第四篇博客。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。', '2020-06-29 16:33:36', 5);

-- ----------------------------
-- Table structure for comment_table
-- ----------------------------
DROP TABLE IF EXISTS `comment_table`;
CREATE TABLE `comment_table`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `contentTime` datetime(0) NOT NULL,
  `blog_id` int(255) NOT NULL,
  `user_id` int(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment_table
-- ----------------------------
INSERT INTO `comment_table` VALUES (1, '怎么没有人评论啊', '2020-06-28 16:01:38', 1, 1);
INSERT INTO `comment_table` VALUES (3, '怎么没有人评论啊', '2020-06-28 16:14:41', 1, 1);
INSERT INTO `comment_table` VALUES (4, '怎么没有人评论啊', '2020-06-28 16:21:22', 1, 1);
INSERT INTO `comment_table` VALUES (5, '怎么没有人评论啊', '2020-06-28 16:25:27', 1, 1);
INSERT INTO `comment_table` VALUES (7, '怎么没有人评论啊', '2020-06-28 16:25:34', 1, 1);
INSERT INTO `comment_table` VALUES (8, '怎么没有人评论啊', '2020-06-28 16:25:38', 1, 1);
INSERT INTO `comment_table` VALUES (9, '怎么没有人评论啊', '2020-06-28 16:42:46', 1, 1);
INSERT INTO `comment_table` VALUES (10, '怎么没有人评论啊', '2020-06-28 16:48:16', 1, 1);
INSERT INTO `comment_table` VALUES (11, '怎么都是我自己评论的啊！！！！！！！！！！！！！！1', '2020-06-28 22:36:10', 1, 1);
INSERT INTO `comment_table` VALUES (12, '怎么都是我自己评论的啊！！！！！！！！！！！！！！1', '2020-06-28 22:38:06', 1, 1);
INSERT INTO `comment_table` VALUES (13, '怎么都是我自己评论的啊！！！！！！！！！！！！！！1', '2020-06-28 22:38:20', 1, 1);
INSERT INTO `comment_table` VALUES (14, '怎么都是我自己评论的啊！！！！！！！！！！！！！！1', '2020-06-28 22:42:53', 7, 1);
INSERT INTO `comment_table` VALUES (15, '怎么都是我自己评论的啊！！！！！！！！！！！！！！1', '2020-06-28 22:47:00', 8, 1);
INSERT INTO `comment_table` VALUES (18, '不错不错', '2020-06-29 10:56:08', 18, 1);

-- ----------------------------
-- Table structure for log_table
-- ----------------------------
DROP TABLE IF EXISTS `log_table`;
CREATE TABLE `log_table`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `operate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `operateTime` datetime(0) NOT NULL,
  `user_id` int(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log_table
-- ----------------------------
INSERT INTO `log_table` VALUES (1, '用户登录', '2020-06-29 16:15:28', 5);
INSERT INTO `log_table` VALUES (2, '用户登录', '2020-06-29 16:17:22', 5);
INSERT INTO `log_table` VALUES (3, '用户登录', '2020-06-29 16:20:51', 5);
INSERT INTO `log_table` VALUES (4, '用户登录', '2020-06-29 16:24:11', 1);
INSERT INTO `log_table` VALUES (5, '用户登录', '2020-06-29 16:27:01', 1);
INSERT INTO `log_table` VALUES (6, '用户登录', '2020-06-29 16:27:59', 5);
INSERT INTO `log_table` VALUES (7, '用户登录', '2020-06-29 16:33:17', 5);
INSERT INTO `log_table` VALUES (8, '用户登录', '2020-06-29 16:36:57', 1);
INSERT INTO `log_table` VALUES (9, '用户登录', '2020-06-29 16:37:20', 1);
INSERT INTO `log_table` VALUES (10, '用户登录', '2020-06-29 16:38:22', 1);
INSERT INTO `log_table` VALUES (11, '用户登录', '2020-06-29 16:41:19', 1);
INSERT INTO `log_table` VALUES (12, '用户登录', '2020-06-29 16:41:42', 5);
INSERT INTO `log_table` VALUES (13, '用户登录', '2020-06-29 16:46:08', 5);
INSERT INTO `log_table` VALUES (14, '用户登录', '2020-06-29 16:48:24', 5);

-- ----------------------------
-- Table structure for role_table
-- ----------------------------
DROP TABLE IF EXISTS `role_table`;
CREATE TABLE `role_table`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `power` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` int(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_table
-- ----------------------------
INSERT INTO `role_table` VALUES (1, '普通用户', 1);
INSERT INTO `role_table` VALUES (4, '普通用户', 3);
INSERT INTO `role_table` VALUES (5, '普通用户', 4);
INSERT INTO `role_table` VALUES (6, '普通用户', 5);
INSERT INTO `role_table` VALUES (7, '管理员', 5);

-- ----------------------------
-- Table structure for user_table
-- ----------------------------
DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birthday` date NULL DEFAULT NULL,
  `registerTime` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_table
-- ----------------------------
INSERT INTO `user_table` VALUES (1, 'pp', '222222', '2004-09-19', '2020-06-19 12:32:56');
INSERT INTO `user_table` VALUES (3, 'xx', '222222', '2001-10-13', '2020-06-23 16:42:37');
INSERT INTO `user_table` VALUES (4, 'wq', '1111', '1996-11-25', '2020-06-26 21:57:25');
INSERT INTO `user_table` VALUES (5, '大大', '111111', '1994-05-14', '2020-06-29 08:06:49');

SET FOREIGN_KEY_CHECKS = 1;
