package com.xiaoban.securitydemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 系统用户
 *
 * @author xiaoban
 * @version 1.0.0
 * @date 2021/04/09 16:19
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysUser implements Serializable {

    private Integer id;

    private String name;

    private String password;

    // 省略getter/setter
}
