package net.kegui.start.entity;

import com.baomidou.mybatisplus.annotation.*;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_user")
public class SysUser implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long userId;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("nick_name")
    private String nickName;

    @TableField("avatar")
    private String avatar;

    @TableField("status")
    private Integer status;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    // 扩展方法示例：状态合法性验证
    public boolean isActive() {
        return status != null && status == 1;
    }
}
