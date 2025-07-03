package net.kegui.start.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@TableName("sys_user")
public record SysUser(
        @TableId(type = IdType.AUTO)
        Long userId,

        @TableField("username")
        String username,

        @TableField("password")
        String password,

        @TableField("nick_name")
        String nickName,

        @TableField("avatar")
        String avatar,

        @TableField("status")
        Integer status,

        @TableField(value = "create_time", fill = FieldFill.INSERT)
        LocalDateTime createTime
) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}