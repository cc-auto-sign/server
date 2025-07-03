package net.kegui.start.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
@TableName("sys_menu")
public record SysMenu(
        @TableId(type = IdType.AUTO)
        Long menuId,

        String menuName,

        String permission,

        String component,

        Integer orderNum,

        Long parentId
) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}