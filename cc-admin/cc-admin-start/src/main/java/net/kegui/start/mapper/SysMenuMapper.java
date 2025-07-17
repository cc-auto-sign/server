package net.kegui.start.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.kegui.start.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 根据角色ID列表查询权限标识
     * 
     * @param roleIds 角色ID列表
     * @return 权限标识集合
     */
    Set<String> selectPermissionsByRoleIds(@Param("roleIds") List<Long> roleIds);
}
