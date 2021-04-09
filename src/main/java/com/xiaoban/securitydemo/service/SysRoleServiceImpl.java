package com.xiaoban.securitydemo.service;

import com.xiaoban.securitydemo.model.SysRole;
import org.springframework.stereotype.Service;

/**
 * 系统角色接口实现类
 *
 * @author xiaoban
 * @version 1.0.0
 * @create 2021/04/09 - 16:22
 */
@Service
public class SysRoleServiceImpl {
    public SysRole selectById(Integer id){
        if (id==1||id==2){
            String name = id==1?"ROLE_ADMIN":"ROLE_M";
            return SysRole.builder()
                    .name(name)
                    .id(id)
                    .build();
        }
        return SysRole.builder()
                .name("ROLE_USER")
                .id(3)
                .build();
    }
}
