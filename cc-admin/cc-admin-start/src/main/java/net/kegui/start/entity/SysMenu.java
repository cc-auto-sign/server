package net.kegui.start.entity;

import com.baomidou.mybatisplus.annotation.*;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_menu")
public class SysMenu implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long menuId;

    @TableField("menu_name")
    private String menuName;

    @TableField("permission")
    private String permission;

    @TableField("component")
    private String component;

    @TableField("order_num")
    private Integer orderNum;

    @TableField("parent_id")
    private Long parentId;
}
