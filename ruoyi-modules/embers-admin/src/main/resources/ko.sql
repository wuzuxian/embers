DROP TABLE IF EXIST `t_gateway`;
CREATE TABLE `t_gateway` (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT,
                             `url` varchar(255) NOT NULL COMMENT 'gateway网关地址',
                             `topic` varchar(64) NOT NULL COMMENT '订阅消息主题',
                             `protocol` tinyint(255) NOT NULL DEFAULT '0' COMMENT '支持协议：0=全部支持，1=tcp，2=udp，3=websocket',
                             `secret_key` varchar(512) NOT NULL COMMENT '注册密钥',
                             `register_time` datetime NOT NULL COMMENT '注册时间',
                             `max_connection_number` int(11) NOT NULL DEFAULT '0' COMMENT '最大连接总数',
                             `remaining_connection_number` int(11) NOT NULL DEFAULT '0' COMMENT '剩余连接数',
                             `create_dept` bigint(20) DEFAULT NULL COMMENT '创建部门',
                             `create_by` bigint(20) DEFAULT NULL COMMENT '创建者',
                             `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                             `update_by` bigint(20) DEFAULT NULL COMMENT '更新者',
                             `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COMMENT='长链接接入网关';
