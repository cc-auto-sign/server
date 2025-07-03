package net.kegui.start.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;

@TableName("sys_role_menu")
public record SysRoleMenu(
        @TableId(type = IdType.AUTO)
        Long id,

        Long roleId,

        Long menuId
) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}