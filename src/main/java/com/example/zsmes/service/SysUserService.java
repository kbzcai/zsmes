package com.example.zsmes.service;

import com.example.zsmes.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
public interface SysUserService extends IService<SysUser> {
    public SysUser findByUsername(String username);

    public String insertUser(SysUser user);
}
