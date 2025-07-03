package net.kegui.start.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
@TableName("sys_user_role")
public record SysUserRole(
        @TableId(type = IdType.AUTO)
        Long id,

        Long userId,

        Long roleId
) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
