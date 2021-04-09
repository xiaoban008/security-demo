package com.xiaoban.securitydemo.service;

import com.xiaoban.securitydemo.model.SysUser;
import org.springframework.stereotype.Service;

/**
 * 系统用户接口实现类
 *
 * @author xiaoban
 * @version 1.0.0
 * @create 2021/04/09 - 16:22
 */
@Service
public class SysUserServiceImpl {
    public SysUser getByName(String name){
        if (!"xiaoban".equals(name)){
            return null;
        }
        return SysUser.builder()
                .id(1215)
                .name("xiaoban")
                .password("123456")
                .build();
    }
}
