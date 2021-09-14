package com.example.zsmes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.zsmes.entity.SysUser;
import com.example.zsmes.mapper.SysUserMapper;
import com.example.zsmes.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findByUsername(String username) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("user_name",username);
        return sysUserMapper.selectOne(wrapper);
    }

    @Override
    public String insertUser(SysUser user) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("user_name",user.getUserName());
        SysUser sysUser = sysUserMapper.selectOne(wrapper);
        if(sysUser!=null){
            return "该用户名已存在";
        }
        sysUserMapper.insert(user);
        return "添加角色成功";
    }
}
