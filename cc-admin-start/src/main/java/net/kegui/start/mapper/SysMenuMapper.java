package net.kegui.start.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.kegui.start.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    default List<SysMenu> selectRoleMenuTree(Long roleId) {
        return selectList(new LambdaQueryWrapper<SysMenu>()
                .inSql(SysMenu::getMenuId,
                        "SELECT menu_id FROM sys_role_menu WHERE role_id = " + roleId)
                .orderByAsc(SysMenu::getOrderNum));
    }
}
