package net.kegui.start.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.kegui.start.entity.SysRole;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * 用户信息视图对象
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVo {
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     * 返回给前端时会自动转换为时间戳
     */
    private LocalDateTime createTime;

    /**
     * 角色列表
     */
    private List<SysRole> roles;

    /**
     * 权限列表
     */
    private Set<String> permissions;

    /**
     * 菜单列表
     */
    private List<?> menus;
}
