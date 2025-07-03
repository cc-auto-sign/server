package net.kegui.start.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@TableName("sys_role")
public record SysRole(
        @TableId(type = IdType.AUTO)
        Long roleId,

        @TableField("role_key")
        String roleKey,

        @TableField("role_name")
        String roleName,

        @TableField("order_num")
        Integer orderNum,

        @TableField(value = "create_time", fill = FieldFill.INSERT)
        LocalDateTime createTime
) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
