----- 用户表--------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) CHARACTER SET utf8mb4  COMMENT '用户名',
  `phone_number` varchar(15) NOT NULL COMMENT '手机号',
  `password` varchar(64) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '登录密码',
  `salt` varchar(16) CHARACTER SET utf8mb4  DEFAULT NULL '密码加密使用的盐',
  `status` tinyint(2) DEFAULT NULL COMMENT '0: 注销；1：正常',
  `create_time` datetime(0) DEFAULT NULL,
  `create_user` int(10) DEFAULT NULL,
  `update_time` datetime(0) DEFAULT NULL,
  `update_user` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4;

----系统角色表-----
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) CHARACTER SET utf8mb4  DEFAULT NULL,
  `role_desc` varchar(64) CHARACTER SET utf8mb4  DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL COMMENT '0: 不可用；1：可用',
  `create_time` datetime(0) DEFAULT NULL,
  `create_user` int(10) DEFAULT NULL,
  `update_time` datetime(0) DEFAULT NULL,
  `update_user` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4;


--------用户角色映射表-------
DROP TABLE IF EXISTS `t_sys_user_role`;
CREATE TABLE `t_sys_user_role`  (
  `user_id` int(10) NOT NULL,
  `role_id` int(10) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4;

--------事件登记表----------
DROP TABLE IF EXISTS `t_event_record`;
CREATE TABLE `t_event_record`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `event` varchar(1024) CHARACTER SET utf8mb4  DEFAULT NULL,
  `user_id` int(10) NOT NULL,
  `desc` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL,
  `score` double DEFAULT NULL,
  `create_time` datetime(0) DEFAULT NULL,
  `create_user` int(10) DEFAULT NULL,
  `update_time` datetime(0) DEFAULT NULL,
  `update_user` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4;