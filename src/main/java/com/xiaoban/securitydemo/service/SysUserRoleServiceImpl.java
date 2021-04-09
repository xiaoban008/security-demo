package com.xiaoban.securitydemo.service;

import com.xiaoban.securitydemo.model.SysUserRole;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoban
 * @version 1.0.0
 * @create 2021/04/09 - 16:27
 */
@Service
public class SysUserRoleServiceImpl {
    public List<SysUserRole> listByUserId(Integer userId) {
        if (userId==1215){
            List<SysUserRole> list = new ArrayList<>();
            list.add(SysUserRole.builder().roleId(1).userId(1).build());
            list.add( SysUserRole.builder().roleId(2).userId(1).build());
            return list;
        }
        return null;
    }
}
