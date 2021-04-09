package com.xiaoban.securitydemo.security;

import com.xiaoban.securitydemo.model.SysRole;
import com.xiaoban.securitydemo.model.SysUser;
import com.xiaoban.securitydemo.model.SysUserRole;
import com.xiaoban.securitydemo.service.SysRoleServiceImpl;
import com.xiaoban.securitydemo.service.SysUserRoleServiceImpl;
import com.xiaoban.securitydemo.service.SysUserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author xiaoban
 * @version 1.0.0
 * @create 2021/04/09 - 16:33
 */
@Service("userDetailsService")
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private SysUserServiceImpl userService;

    @Autowired
    private SysRoleServiceImpl roleService;

    @Autowired
    private SysUserRoleServiceImpl userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息
        SysUser user = userService.getByName(username);

        // 判断用户是否存在
        if(user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        log.info("权限判断 {}",user);
        // 添加权限
        List<SysUserRole> userRoles = userRoleService.listByUserId(user.getId());
        for (SysUserRole userRole : userRoles) {
            SysRole role = roleService.selectById(userRole.getRoleId());
            if (role == null) {
                continue;
            }
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        // 返回UserDetails实现类
        return new User(user.getName(), user.getPassword(), authorities);
    }
}
