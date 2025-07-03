package net.kegui.start.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.kegui.start.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
    default List<SysUserRole> selectByUserId(Long userId) {
        return selectList(new LambdaQueryWrapper<SysUserRole>()
                .eq(SysUserRole::userId, userId));
    }
}