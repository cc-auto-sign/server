package net.kegui.start.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import net.kegui.framework.core.api.exception.AuthException;
import net.kegui.framework.security.domain.LoginUser;
import net.kegui.framework.security.enums.DeviceType;
import net.kegui.framework.security.utils.SecurityUtils;
import net.kegui.start.dto.LoginDto;
import net.kegui.start.entity.SysMenu;
import net.kegui.start.entity.SysRole;
import net.kegui.start.entity.SysUser;
import net.kegui.start.mapper.SysMenuMapper;
import net.kegui.start.mapper.SysRoleMapper;
import net.kegui.start.mapper.SysUserMapper;
import net.kegui.start.service.LoginService;
import net.kegui.start.vo.LoginVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;


@Service
public class LoginServiceImpl implements LoginService {

    final SysUserMapper sysUserMapper;
    final SysRoleMapper roleMapper;
    final SysMenuMapper menuMapper;

    public LoginServiceImpl(SysUserMapper sysUserMapper, SysRoleMapper roleMapper, SysMenuMapper menuMapper) {
        this.sysUserMapper = sysUserMapper;
        this.roleMapper = roleMapper;
        this.menuMapper = menuMapper;
    }

    @Override
    public LoginVo login(LoginDto loginDto) {
        // 查询用户&校验用户密码
        SysUser sysUser = loadUserByUsername(loginDto.username(), loginDto.password());
        // 构造用户信息
        LoginUser loginUser = buildLoginUser(sysUser);
        // 生成token
        SecurityUtils.loginByDevice(loginUser,DeviceType.APP);
        return new LoginVo(StpUtil.getTokenValue());
    }

    /**
     * 通过账号名称登录
     * @param username 账号名称
     * @param password 账号密码
     * @return
     */
    private SysUser loadUserByUsername(String username, String password) {
        // 获取信息
        SysUser sysUser = sysUserMapper.selectOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username));
        if(Objects.isNull(sysUser)){
            throw new AuthException("账号不存在");
        }
        // 校验密码
        if (!BCrypt.checkpw(password, sysUser.getPassword())) {
            throw new AuthException("用户名或密码错误");
        }
        // 登陆成功 返回用户信息
        return sysUser;
    }

    /**
     * 构建用户信息
     * @param sysUser SysUser
     * @return LoginUser
     */
    private LoginUser buildLoginUser(SysUser sysUser) {
        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(sysUser,loginUser);

        List<SysRole> roles = roleMapper.selectRolesByUserId(sysUser.getUserId());
        loginUser.setRoles(roles);

        List<Long> roleIds = roles.stream().map(SysRole::getRoleId).toList();
        if (!roleIds.isEmpty()) {
            Set<String> permissions = menuMapper.selectPermissionsByRoleIds(roleIds);
            loginUser.setPermissions(permissions);

            // 查询菜单信息
            List<SysMenu> menus = menuMapper.selectMenusByRoleIds(roleIds);
            loginUser.setMenus(menus);
        }

        return loginUser;
    }
}
