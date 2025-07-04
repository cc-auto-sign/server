package net.kegui.start.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@TableName("sys_menu")
@Data  // 自动生成getter/setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysMenu implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Long menuId;
    private String menuName;
    private String permission;
    private String component;
    private Integer orderNum;
    private Long parentId;
}