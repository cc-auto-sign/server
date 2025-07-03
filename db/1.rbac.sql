-- 用户表
CREATE TABLE `sys_user`
(
    `user_id`     BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `username`    VARCHAR(50)  NOT NULL COMMENT '登录账号',
    `password`    VARCHAR(100) NOT NULL COMMENT '加密密码',
    `nick_name`   VARCHAR(50)           DEFAULT '' COMMENT '显示名称',
    `avatar`      VARCHAR(500) NOT NULL DEFAULT '' COMMENT '头像地址',
    `status`      TINYINT(1) NOT NULL DEFAULT 1 COMMENT '状态(0停用 1正常)',
    `create_time` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`user_id`),
    UNIQUE INDEX `idx_username` (`username`),
    INDEX         `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- 角色表
CREATE TABLE `sys_role`
(
    `role_id`     BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '角色ID',
    `role_key`    VARCHAR(50) NOT NULL COMMENT '角色标识(英文唯一键)',
    `role_name`   VARCHAR(50) NOT NULL COMMENT '角色名称',
    `order_num`   INT UNSIGNED DEFAULT 0 COMMENT '排序号',
    `create_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`role_id`),
    UNIQUE INDEX `idx_role_key` (`role_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';
-- 用户-角色关联表
CREATE TABLE `sys_user_role`
(
    `id`      BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '关联ID',
    `user_id` BIGINT UNSIGNED NOT NULL COMMENT '用户ID',
    `role_id` BIGINT UNSIGNED NOT NULL COMMENT '角色ID',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `uniq_user_role` (`user_id`, `role_id`),
    CONSTRAINT `fk_user_role_user`
        FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`)
            ON DELETE CASCADE ON UPDATE RESTRICT,
    CONSTRAINT `fk_user_role_role`
        FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
            ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关联表';
-- 菜单权限表
CREATE TABLE `sys_menu`
(
    `menu_id`    BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
    `menu_name`  VARCHAR(50)  NOT NULL COMMENT '菜单名称',
    `permission` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '权限标识(例: system:user:list)',
    `component`  VARCHAR(200)          DEFAULT NULL COMMENT '前端组件路径',
    `order_num`  INT UNSIGNED DEFAULT 0 COMMENT '排序号',
    `parent_id`  BIGINT UNSIGNED DEFAULT 0 COMMENT '父菜单ID',
    PRIMARY KEY (`menu_id`),
    INDEX        `idx_parent_id` (`parent_id`),
    INDEX        `idx_permission` (`permission`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单权限表';
-- 角色-菜单关联表
CREATE TABLE `sys_role_menu`
(
    `id`      BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '关联ID',
    `role_id` BIGINT UNSIGNED NOT NULL COMMENT '角色ID',
    `menu_id` BIGINT UNSIGNED NOT NULL COMMENT '菜单ID',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `uniq_role_menu` (`role_id`, `menu_id`),
    CONSTRAINT `fk_role_menu_role`
        FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
            ON DELETE CASCADE ON UPDATE RESTRICT,
    CONSTRAINT `fk_role_menu_menu`
        FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`menu_id`)
            ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色菜单关联表';