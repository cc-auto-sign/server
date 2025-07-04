package net.kegui.start.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.kegui.start.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}
